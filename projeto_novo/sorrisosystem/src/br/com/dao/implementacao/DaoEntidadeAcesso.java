package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.EntidadeAcesso;
import br.com.repository.interfaces.RepositoryEntidadeAcesso;


@Repository
public class DaoEntidadeAcesso extends ImplementacaoCrud<EntidadeAcesso> implements RepositoryEntidadeAcesso{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
