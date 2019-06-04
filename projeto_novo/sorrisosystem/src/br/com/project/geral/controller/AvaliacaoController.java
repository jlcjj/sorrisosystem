package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Avaliacao;
import br.com.repository.interfaces.RepositoryAvaliacao;
import br.com.srv.interfaces.SrvAvaliacao;

@Controller
public class AvaliacaoController extends ImplementacaoCrud<Avaliacao> implements InterfaceCrud<Avaliacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvAvaliacao srvAvaliacao;
	
	@Resource
	private RepositoryAvaliacao repositoryAvaliacao;

	
}
