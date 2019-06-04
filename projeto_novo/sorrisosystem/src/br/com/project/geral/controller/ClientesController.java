package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Clientes;
import br.com.repository.interfaces.RepositoryClientes;
import br.com.srv.interfaces.SrvClientes;

@Controller
public class ClientesController extends ImplementacaoCrud<Clientes> implements InterfaceCrud<Clientes> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvClientes srvClientes;
	
	@Resource
	private RepositoryClientes repositoryClientes;
	
	public List<SelectItem> getListClientes() throws Exception {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Clientes> cliente = super.findListByQueryDinamica(" from Clientes");

		for (Clientes clientes : cliente) {
			list.add(new SelectItem(clientes, clientes.getNome()));
		}
		return list;
	}
	
	
	public List<SelectItem> getListClientesPront() throws Exception {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Clientes> clienteProt = super.findListByQueryDinamica(" from Clientes");

		for (Clientes clientes2 : clienteProt) {
			list.add(new SelectItem(clientes2, clientes2.getProntuario()));
		}
		return list;
	}

}
