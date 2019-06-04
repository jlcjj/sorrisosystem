package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Procedimentos;
import br.com.repository.interfaces.RepositoryProcedimentos;

@Repository
public class DaoProcedimento extends ImplementacaoCrud<Procedimentos> implements RepositoryProcedimentos{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}