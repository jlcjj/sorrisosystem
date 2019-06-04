package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Agendamentos;
import br.com.repository.interfaces.RepositoryAgendamentos;

@Repository
public class DaoOdontograma extends ImplementacaoCrud<Agendamentos> implements RepositoryAgendamentos{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
