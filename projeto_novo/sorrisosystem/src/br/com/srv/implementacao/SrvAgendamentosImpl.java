package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryAgendamentos;
import br.com.srv.interfaces.SrvAgendamentos;

@Service
public class SrvAgendamentosImpl implements SrvAgendamentos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryAgendamentos repositoryAgendamentos;

}
