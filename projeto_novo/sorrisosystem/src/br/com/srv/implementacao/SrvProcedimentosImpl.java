package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryProcedimentos;
import br.com.srv.interfaces.SrvProcedimentos;

@Service
public class SrvProcedimentosImpl implements SrvProcedimentos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryProcedimentos repositoryProcedimentos;

}
