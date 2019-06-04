package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryEntidadeAcesso;
import br.com.srv.interfaces.SrvEntidadeAcesso;




@Service
public class SrvEntidadeAcessoImpl implements SrvEntidadeAcesso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryEntidadeAcesso repositoryEntidadeAcesso;

}
