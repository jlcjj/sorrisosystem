package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.EntidadeController;
import br.com.project.model.classes.Entidade;
import br.com.project.model.classes.Procedimentos;

@Controller
@Scope(value = "session")
@ManagedBean(name = "entidadeBeanView")
public class EntidadeBeanView extends BeanManagedViewAbstract{
	
	@Autowired
	private ContextoBean contextoBean;

	private static final long serialVersionUID = 1L;
	
	private String url = "/cadastro/cad_usuarios.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_usuarios.jsf?faces-redirect=true";
	
	@Autowired
	private EntidadeController entidadeController;
	
	private Entidade objetoSelecionado = new Entidade();
	
	private List<Entidade> list = new ArrayList<Entidade>();
	
	public List<Entidade> getList() throws Exception {
		list = entidadeController.findList(getClassImplement());
		return list;
	}
	
	
	

	protected Class<Entidade> getClassImplement() {
		return Entidade.class;

	}

	public String getUsuarioLogadoSecurity() {
		return contextoBean.getAuthentication().getName();
	}
	
	public Date getUltimoAcesso() throws Exception {
		return contextoBean.getEntidadeLogada().getEnt_ultimoacesso();
	
	}

	public List<SelectItem> getEntidade() throws Exception{
		return entidadeController.getListEntidade();
	}


	public Entidade getObjetoSelecionado() {
		return objetoSelecionado;
	}


	public void setObjetoSelecionado(Entidade objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	
	
	@Override
	public String save() throws Exception {
		//System.out.println(objetoSelecionado.getEntidade().getEnt_nome());
			objetoSelecionado = entidadeController.merge(objetoSelecionado);
			novo();
		return "";
	}
	
	@Override
	public String novo() throws Exception {
		objetoSelecionado = new Entidade();
		return url;
	}
	
	@Override
	public String editar() throws Exception {
	
		return url;
	}
	
	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		entidadeController.delete(objetoSelecionado);
		novo();
	}


	@Override
	protected InterfaceCrud<?> getController() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void saveNotReturnHorario() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
