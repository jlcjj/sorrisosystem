package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.EntidadeAcessoController;
import br.com.project.model.classes.EntidadeAcesso;

@Controller
@Scope(value="session")
@ManagedBean(name = "entidadeAcessoBeanView")
public class EntidadeAcessoBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_acessos.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_acessos.jsf?faces-redirect=true";
	
	private EntidadeAcesso objetoSelecionado = new EntidadeAcesso();
	
	private List<EntidadeAcesso> list = new ArrayList<EntidadeAcesso>();
	
	
	
	public List<EntidadeAcesso> getList() throws Exception {
		list = entidadeAcessoController.findList(getClassImplement());
		return list;
	}

	
	
	protected Class<EntidadeAcesso> getClassImplement() {
		return EntidadeAcesso.class;

	}



	@Override
	public String save() throws Exception {
		//System.out.println(objetoSelecionado.getEntidade().getEnt_nome());
			objetoSelecionado = entidadeAcessoController.merge(objetoSelecionado);
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
		objetoSelecionado = entidadeAcessoController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new EntidadeAcesso();
		sucesso();
	}
		
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}
	
	@Override
	public void setarVariaveisNulas() throws Exception {
		list.clear();
		objetoSelecionado = new EntidadeAcesso();
	}
	
	@Override
	public String editar() throws Exception {
		list.clear();
		return url;
	}
	
	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		objetoSelecionado = (EntidadeAcesso) entidadeAcessoController.getSession()
				.get(getClassImplement(), objetoSelecionado.getEnt_acesso_id());
		entidadeAcessoController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		novo();
		sucesso();
	}
	
	@Autowired
	private EntidadeAcessoController entidadeAcessoController;

	public EntidadeAcesso getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(EntidadeAcesso objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}
	
	@Override
	protected InterfaceCrud<EntidadeAcesso> getController() {
	
		return entidadeAcessoController;
	}



	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
