package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Clientes;
import br.com.project.model.classes.Entidade;
import br.com.srv.interfaces.SrvEntidade;

@Controller
public class EntidadeController extends ImplementacaoCrud<Entidade> implements
		InterfaceCrud<Entidade> {
	
	@Autowired
	private SrvEntidade srvEntidade;

	private static final long serialVersionUID = 1L;
	
	
	public Entidade findUserLogado(String userLogado) throws Exception {
		return super.findInuqueByProperty(Entidade.class, 
				userLogado, "ent_login", " and entity.ent_inativo = 0");
	}
	
	public Date getUltimoAcessoEntidadeLogada(String login) {
		return srvEntidade.getUltimoAcessoEntidadeLogada(login);
	}

	public void updateUltimoAcessoUser(String name) {
		srvEntidade.updateUltimoAcessoUser(name);
	}
	
	public List<SelectItem> getListEntidade() throws Exception {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Entidade> entidade = super.findListByQueryDinamica(" from Entidade");
			
		for (Entidade entidade2 : entidade) {
			list.add(new SelectItem(entidade2, entidade2.getEnt_nome()));
		}
		return list;
	}
}
