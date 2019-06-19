package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Atendimento;
import br.com.repository.interfaces.RepositoryAtendimento;
import br.com.srv.interfaces.SrvAtendimento;

@Controller
public class AtendimentoController extends ImplementacaoCrud<Atendimento> implements InterfaceCrud<Atendimento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvAtendimento srvAtendimento;
	
	@Resource
	private RepositoryAtendimento repositoryAtendimento;

	
}
