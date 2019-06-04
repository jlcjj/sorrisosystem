package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Clientes;
import br.com.project.model.classes.OdontogramaCliente;
import br.com.repository.interfaces.RepositoryClientes;

@Repository
public class DaoOdontogramaCliente extends ImplementacaoCrud<OdontogramaCliente> implements RepositoryClientes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
