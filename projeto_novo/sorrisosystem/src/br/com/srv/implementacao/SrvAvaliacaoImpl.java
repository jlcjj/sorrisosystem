package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryAvaliacao;
import br.com.srv.interfaces.SrvAvaliacao;

@Service
public class SrvAvaliacaoImpl implements SrvAvaliacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryAvaliacao repositoryAvaliacao;

}