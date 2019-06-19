package br.com.project.bean.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.AgendamentosController;
import br.com.project.model.classes.Agendamentos;

@Controller
@Scope(value="session")
@ManagedBean(name = "agendamentosBeanView")
public class AgendamentosBeanView_old extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_agendamentos.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_agendamentos.jsf?faces-redirect=true";
	
	private Agendamentos objetoSelecionado = new Agendamentos();
	

	
	private CarregamentoLazyListForObject<Agendamentos> list = new CarregamentoLazyListForObject<Agendamentos>();
	
	
	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_agendamentos");
		super.setNomeRelatorioSaida("report_agendamentos");
		super.setListDataBeanCollectionReport(agendamentosController.findList(getClassImplement()));
		return super.getArquivoReport();
	}	
	
	
	public CarregamentoLazyListForObject<Agendamentos> getList() throws Exception {
		
		return list;
	}

	
	
	protected Class<Agendamentos> getClassImplement() {
		return Agendamentos.class;

	}



	@Override
	public String save() throws Exception {
		//System.out.println(objetoSelecionado.getNomeMedico());
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
		objetoSelecionado = (Agendamentos) agendamentosController.getSession()
				.get(getClassImplement(), objetoSelecionado.getAgendamento_id());
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
	
	public List<SelectItem> getAgendados() throws Exception{
		return agendamentosController.getListAgendados();
	}
	
	@Override
	public void consultarEntidade() throws Exception {
		objetoSelecionado = new Agendamentos();
		list.clean();
		list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.SqlLazyQuery());
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
