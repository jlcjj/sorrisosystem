package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Agendamentos;
import br.com.project.model.classes.Clientes;
import br.com.repository.interfaces.RepositoryAgendamentos;
import br.com.srv.interfaces.SrvAgendamentos;

@Controller
public class AgendamentosController extends ImplementacaoCrud<Agendamentos> implements InterfaceCrud<Agendamentos> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvAgendamentos srvAgendamentos;
	
	@Resource
	private RepositoryAgendamentos repositoryAgendamentos;

	public List<SelectItem> getListAgendados() throws Exception {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Agendamentos> ag = super.findListByQueryDinamica(" from Agendamentos ");

		
			
		
		
	for (Agendamentos agendamentos : ag) {
			list.add(new SelectItem(ag, agendamentos.getClientes().getNome()));
		}
		return list;
	}
}
