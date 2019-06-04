package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Clientes;
import br.com.project.model.classes.Procedimentos;
import br.com.repository.interfaces.RepositoryProcedimentos;
import br.com.srv.interfaces.SrvProcedimentos;

@Controller
public class ProcedimentosController extends ImplementacaoCrud<Procedimentos> implements InterfaceCrud<Procedimentos> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvProcedimentos srvProcedimentoss;
	
	@Resource
	private RepositoryProcedimentos repositoryProcedimentos;

	public List<SelectItem> getListProcedimentos() throws Exception {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Procedimentos> proc = super.findListByQueryDinamica(" from Procedimentos");

		for (Procedimentos procedimentos : proc) {
			list.add(new SelectItem(procedimentos, procedimentos.getDescricao()));
		}
		/*for (Procedimentos procedimentos : procedimento) {
			list.add(new SelectItem(procedimentos, procedimentos.getDescricao()));
		}*/
		return list;
	}
	
}
