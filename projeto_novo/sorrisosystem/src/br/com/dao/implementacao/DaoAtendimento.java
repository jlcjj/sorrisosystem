package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Atendimento;
import br.com.repository.interfaces.RepositoryAvaliacao;

@Repository
public class DaoAtendimento extends ImplementacaoCrud<Atendimento> implements RepositoryAvaliacao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
