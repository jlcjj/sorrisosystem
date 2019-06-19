package br.com.project.bean.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.ProcedimentosController;
import br.com.project.model.classes.Procedimentos;

@Controller
@Scope(value="session")
@ManagedBean(name = "procedimentosBeanView")
public class ProcedimentosBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_procedimentos.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_procedimentos.jsf?faces-redirect=true";
	
	private Procedimentos objetoSelecionado = new Procedimentos();
	
	private CarregamentoLazyListForObject<Procedimentos> list = new CarregamentoLazyListForObject<Procedimentos>();
	//private List<Procedimentos> list = new ArrayList<Procedimentos>();
	
	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_procedimentos");
		super.setNomeRelatorioSaida("report_procedimentos");
		super.setListDataBeanCollectionReport(procedimentosController.findList(getClassImplement()));
		return super.getArquivoReport();
	}	
	
	
	public CarregamentoLazyListForObject<Procedimentos> getList() throws Exception {
		//list = procedimentosController.findList(getClassImplement());
		return list;
	}

	
	
	protected Class<Procedimentos> getClassImplement() {
		return Procedimentos.class;

	}



	@Override
	public String save() throws Exception {
		//System.out.println(objetoSelecionado.getNomeMedico());
			objetoSelecionado = procedimentosController.merge(objetoSelecionado);
			novo();
		return "";
	}
	
	
	@Override
	public void saveEdit() throws Exception {
		// TODO Auto-generated method stub
		saveNotReturn();
	}
	@Override
	public void saveNotReturn() throws Exception {
		list.clean();
		objetoSelecionado = procedimentosController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Procedimentos();
		sucesso();
	}
		
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}
	
	@Override
	public void setarVariaveisNulas() throws Exception {
		list.clean();
		objetoSelecionado = new Procedimentos();
	}
	
	@Override
	public String editar() throws Exception {
		list.clean();
		return url;
	}

	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		objetoSelecionado = (Procedimentos) procedimentosController.getSession()
				.get(getClassImplement(), objetoSelecionado.getProcedimento_id());
		procedimentosController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		novo();
		sucesso();
	}
	
	@Autowired
	private ProcedimentosController procedimentosController;

	public Procedimentos getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Procedimentos objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	public List<SelectItem> getProcedimentos() throws Exception{
		return procedimentosController.getListProcedimentos();
	}
	
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}
	
	@Override
	protected InterfaceCrud<Procedimentos> getController() {
	
		return procedimentosController;
	}
	
	@Override
	public void consultarEntidade() throws Exception {
		objetoSelecionado = new Procedimentos();
		list.clean();
		list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.SqlLazyQuery());
	}


	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return "";
	}


	@Override
	public void saveNotReturnHorario() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
