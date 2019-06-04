package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.AgendamentosController;
import br.com.project.model.classes.Agendamentos;
import br.com.project.model.classes.Procedimentos;

@Controller
@Scope(value="session")
@ManagedBean(name = "agendamentosBeanView")
public class AgendamentosBeanViewCopy extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_agendamentos.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_agendamentos.jsf?faces-redirect=true";
	
	private Agendamentos objetoSelecionado = new Agendamentos();
	
	private List<Agendamentos> list = new ArrayList<Agendamentos>();
		
	
	public List<Agendamentos> getList() throws Exception {
		list = agendamentosController.findList(getClassImplement());
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
		list.clear();
		objetoSelecionado = agendamentosController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Agendamentos();
		sucesso();
	}
	@Override
	public void setarVariaveisNulas() throws Exception {
		list.clear();
		objetoSelecionado = new Agendamentos();
	}
	
	
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}
	
	@Override
	public String editar() throws Exception {
	
		list.clear();
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
	protected InterfaceCrud<Agendamentos> getController() {
	
		return agendamentosController;
	}



	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
