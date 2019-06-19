package br.com.project.bean.view;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.enums.CondicaoPesquisa;
import br.com.project.geral.controller.AgendamentosController;
import br.com.project.model.classes.Agendamentos;
import br.com.project.util.all.UtilitariaRegex;

@Controller
@Scope(value = "session")
@ManagedBean(name = "agendamentosBeanView")
public class AgendamentosBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_agendamentos.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_agendamentos.jsf?faces-redirect=true";

	private Agendamentos objetoSelecionado = new Agendamentos();

	private CarregamentoLazyListForObject<Agendamentos> list = new CarregamentoLazyListForObject<Agendamentos>();
	// private List<Procedimentos> list = new ArrayList<Procedimentos>();

	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_agendamentos");
		super.setNomeRelatorioSaida("report_agendamentos");
		super.setListDataBeanCollectionReport(agendamentosController.findList(getClassImplement()));
		return super.getArquivoReport();
	}

	public CarregamentoLazyListForObject<Agendamentos> getList() throws Exception {
		// list = procedimentosController.findList(getClassImplement());
		return list;
	}

	protected Class<Agendamentos> getClassImplement() {
		return Agendamentos.class;

	}

	@Override
	public String save() throws Exception {
		// System.out.println(objetoSelecionado.getNomeMedico());
		objetoSelecionado = agendamentosController.merge(objetoSelecionado);
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
		objetoSelecionado = agendamentosController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Agendamentos();
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
		objetoSelecionado = new Agendamentos();
	}

	@Override
	public String editar() throws Exception {
		list.clean();
		return url;
	}

	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		objetoSelecionado = (Agendamentos) agendamentosController.getSession().get(getClassImplement(),
				objetoSelecionado.getAgendamento_id());
		agendamentosController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		novo();
		sucesso();
	}

	@Autowired
	private AgendamentosController agendamentosController;

	public Agendamentos getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Agendamentos objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}

	@Override
	protected InterfaceCrud<Agendamentos> getController() {

		return agendamentosController;
	}

	@Override
	public void consultarEntidade() throws Exception {
		objetoSelecionado = new Agendamentos();
		list.clean();
		list.setTotalRegistroConsulta(totalRegistroConsulta(), SqlLazyQuery());
	}

	public String SqlLazyQuery() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entity from ");
		sql.append(getQueryConsulta(false));
		sql.append(" order by entity.");
		sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
		return sql.toString();
	}

	protected int totalRegistroConsulta() throws Exception {

		StringBuilder sql = new StringBuilder();
		if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {

			sql.append(
					" select count(1) from agendamentos as entity inner join clientes cli on cli.cliente_id = entity.clientes ");
			sql.append(" where  ").append(getQueryConsulta(true));
		} else {
			sql.append(" select count(1) from ").append(getQueryConsulta(false));

		}
		return getController().getJdbcTemplate().queryForInt(sql.toString().toLowerCase());

	}

	private StringBuilder  getQueryConsulta(boolean isJDBC) throws Exception {
		valorPesquisa = new UtilitariaRegex().retiraAcentos(valorPesquisa);
		StringBuilder sql = new StringBuilder();
		/*if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {

			sql.append(" (upper(cli.");

		}else {
			sql.append(" Agendamentos entity where");
			sql.append(" (upper(entity.");

		}*/

		
		
		
		if (!isJDBC){
			sql.append(" Agendamentos entity where");
			sql.append(" (upper(entity.");
		}else {
			sql.append(" (upper(cli.");

		}

		
		if (!isJDBC){
		 sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
		}else {
			if (objetoCampoConsultaSelecionado.getCampoBanco().contains(".")) {
			 sql.append(objetoCampoConsultaSelecionado.getCampoBanco().split("\\.")[1]);
			}else {
				sql.append(objetoCampoConsultaSelecionado.getCampoBanco());
			}
		}
		 
		sql.append(")) ");
		
		 if (condicaoPesquisaSelecionado.name().equals(
				CondicaoPesquisa.IGUAL_A.name())) {
			sql.append(" = (upper('");
			sql.append(valorPesquisa);
			sql.append("'))");
		} else if (condicaoPesquisaSelecionado.name().equals(
				CondicaoPesquisa.CONTEM.name())) {
			sql.append(" like (upper('%");
			sql.append(valorPesquisa);
			sql.append("%'))");
		} else if (condicaoPesquisaSelecionado.name().equals(
				CondicaoPesquisa.INICIA_COM.name())) {
			sql.append(" like (upper('");
			sql.append(valorPesquisa);
			sql.append("%'))");
		} else if (condicaoPesquisaSelecionado.name().equals(
				CondicaoPesquisa.TERMINA_COM.name())) {
			sql.append(" like (upper('%");
			sql.append(valorPesquisa);
			sql.append("'))");
		}
		sql.append(" ");
		sql.append(condicaoAndParaPesquisa());
		return sql;
	}

	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void saveNotReturnHorario() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
