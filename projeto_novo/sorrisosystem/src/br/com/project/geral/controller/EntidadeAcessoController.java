package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.EntidadeAcesso;
import br.com.repository.interfaces.RepositoryEntidadeAcesso;
import br.com.srv.interfaces.SrvEntidadeAcesso;


@Controller
public class EntidadeAcessoController extends ImplementacaoCrud<EntidadeAcesso> implements InterfaceCrud<EntidadeAcesso> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvEntidadeAcesso srvEntidadeAcesso;
	
	@Resource
	private RepositoryEntidadeAcesso repositoryEntidadeAcesso;

	
}
