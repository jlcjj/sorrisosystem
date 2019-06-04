package br.com.project.bean.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.bean.geral.ObjetoCampoConsulta;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.enums.CondicaoPesquisa;
import br.com.project.geral.controller.AvaliacaoController;
import br.com.project.geral.controller.SessionController;
import br.com.project.model.classes.Avaliacao;
import br.com.project.util.all.UtilitariaRegex;
import br.com.srv.interfaces.SrvAvaliacao;
import br.com.srv.interfaces.SrvLogin;

@Controller
@Scope(value="session")
@ManagedBean(name = "avaliacaoBeanView")
public class AvaliacaoBeanView extends BeanManagedViewAbstract {
	private Date data1;
	public Date getData1() {
        return data1;
    }
 
    public void setData1(Date data1) {
        this.data1 = data1;
    }
    private String Data_formatada = ""; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario = "";
	private String url = "/cadastro/cad_avaliacao.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_avaliacao.jsf?faces-redirect=true";
	
	private String username;
	private String password;
	
	
	@Resource
	private SrvLogin srvLogin;
	
	
	
	private Avaliacao objetoSelecionado = new Avaliacao();
	
	private CarregamentoLazyListForObject<Avaliacao> list = new CarregamentoLazyListForObject<Avaliacao>();
	//private List<Avaliacao> list = new ArrayList<Avaliacao>();
	
	
	
	public CarregamentoLazyListForObject<Avaliacao> getList() throws Exception {
		//list = avaliacaoController.findList(getClassImplement());
		return list;
	}
	
	
	
	protected Class<Avaliacao> getClassImplement() {
		return Avaliacao.class;

	}

	 public void onDateSelect(SelectEvent event) throws Exception {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
	        //facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	        Data_formatada = formata.format(data1);;
	        consultarEntidade();
	        Data_formatada = "";
	    }

	@Override
	public String save() throws Exception {
		//System.out.println(objetoSelecionado.getNomeMedico());
			objetoSelecionado = avaliacaoController.merge(objetoSelecionado);
			novo();
		return "";
	}

	@Override
	public void saveEdit() throws Exception {
		// TODO Auto-generated method stub
		saveNotReturn();
	}
	
	@Override
	public void saveNotReturn() throws Exception {
		list.clean();
		objetoSelecionado = avaliacaoController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Avaliacao();
		sucesso();
	}
		
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}
	
	@Override
	public void setarVariaveisNulas() throws Exception {
		list.clean();
		objetoSelecionado = new Avaliacao();
	}
	
	@Override
	public String editar() throws Exception {
		list.clean();
		return url;
	}
	
	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		objetoSelecionado = (Avaliacao) avaliacaoController.getSession()
				.get(getClassImplement(), objetoSelecionado.getAvaliacao_id());
		avaliacaoController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		novo();
		sucesso();
	}
	
	@Autowired
	private AvaliacaoController avaliacaoController;

	public Avaliacao getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Avaliacao objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	

	public String verificaUsuario() throws Exception{
		FacesMessage message = null;
		boolean loggedIn = false;
		usuario = "";
		if (srvLogin.autentico(getUsername(), getPassword())){
			usuario = getUsername();
			loggedIn = true;
		}else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Acesso negado", "Login ou senha incorretos");
		}

		return usuario;
	}
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}
	
	@Override
	protected InterfaceCrud<Avaliacao> getController() {
	
		return avaliacaoController;
	}



	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return " and entity.horario_agendamento = '' ";
	}
	@Override
	public void consultarEntidade() throws Exception {
		objetoSelecionado = new Avaliacao();
		list.clean();
		list.setTotalRegistroConsulta(totalRegistroConsulta(), SqlLazyQuery());
	}

	public String SqlLazyQuery() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entity from ");
		sql.append(getQueryConsulta(false));
		sql.append("  order by data_avaliacao");
		
		if (!Data_formatada.equals("")) {
			sql.append("");
		}else {
			sql.append("  , entity.");
		sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
		}
		
		return sql.toString();
	}

	protected int totalRegistroConsulta() throws Exception {

		StringBuilder sql = new StringBuilder();
		if(!Data_formatada.equals(""))
		{
			
			sql.append(" select count(1) from ").append(getQueryConsulta(false));	
		}else {
		if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {

			sql.append(
					" select count(1) from avaliacao as entity inner join clientes cli on cli.cliente_id = entity.clientes ");
			sql.append(" where  ").append(getQueryConsulta(true));
		} else {
			sql.append(" select count(1) from ").append(getQueryConsulta(false));

		}}
		return getController().getJdbcTemplate().queryForInt(sql.toString().toLowerCase());

	}

	private StringBuilder  getQueryConsulta(boolean isJDBC) throws Exception {
		if (!Data_formatada.equals(""))
		{	
			valorPesquisa = Data_formatada.toString();
			
		}else {
		valorPesquisa = new UtilitariaRegex().retiraAcentos(valorPesquisa);
		}
		StringBuilder sql = new StringBuilder();
		/*if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {

			sql.append(" (upper(cli.");

		}else {
			sql.append(" Agendamentos entity where");
			sql.append(" (upper(entity.");

		}*/

		
		
		
		if (!isJDBC){
			sql.append(" Avaliacao entity where");
			sql.append(" (upper(entity.");
		}else {
			sql.append(" (upper(cli.");

		}

		
		if (!isJDBC){
			if(!Data_formatada.equals("")) 
			{
				sql.append(" data_avaliacao ");
			}else {
		 sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
			}
		}else {
			if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {
			 sql.append(objetoCampoConsultaSelecionado.getCampoBanco().split("\\.")[1]);
			//	sql.append("nome ");
			}else {
				sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
			}
		}
		 
		sql.append(")) ");
		
		
			sql.append(" like (upper('%");
			sql.append(valorPesquisa);
			sql.append("%'))");
		
		sql.append(" ");
		sql.append(condicaoAndParaPesquisa());
		return sql;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
