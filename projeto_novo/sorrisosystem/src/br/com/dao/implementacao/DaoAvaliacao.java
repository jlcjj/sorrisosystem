package br.com.dao.implementacao;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Avaliacao;
import br.com.repository.interfaces.RepositoryAvaliacao;

@Repository
public class DaoAvaliacao extends ImplementacaoCrud<Avaliacao> implements RepositoryAvaliacao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}