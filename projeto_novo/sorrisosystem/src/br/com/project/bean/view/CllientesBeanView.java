package br.com.project.bean.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.ClientesController;
import br.com.project.model.classes.Clientes;

@Controller
@Scope(value="session")
@ManagedBean(name = "cllientesBeanView")
public class CllientesBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String url = "/cadastro/cad_clientes.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_clientes.jsf?faces-redirect=true";
	
	private Clientes objetoSelecionado = new Clientes();
	
	
	private CarregamentoLazyListForObject<Clientes> list = new CarregamentoLazyListForObject<Clientes>();
	//private List<Procedimentos> list = new ArrayList<Procedimentos>();
	
	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_procedimentos");
		super.setNomeRelatorioSaida("report_procedimentos");
		ImplementacaoCrud<Clientes> procedimentosController;
		super.setListDataBeanCollectionReport(clientesController.findList(getClassImplement()));
		return super.getArquivoReport();
	}	
	
	
	public CarregamentoLazyListForObject<Clientes> getList() throws Exception {
		//list = procedimentosController.findList(getClassImplement());
		return list;
	}

	
	
	protected Class<Clientes> getClassImplement() {
		return Clientes.class;

	}

	@Autowired
	private ClientesController clientesController;
	
	
	@Override
	public String save() throws Exception {
			objetoSelecionado = clientesController.merge(objetoSelecionado);
		
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
		objetoSelecionado = clientesController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Clientes();
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
		objetoSelecionado = new Clientes();
	}
	
	@Override
	public String editar() throws Exception {
		list.clean();
		return url;
	}

	@Override
	public void excluir() throws Exception {
		// TODO Auto-generated method stub
		objetoSelecionado = (Clientes) clientesController.getSession()
				.get(getClassImplement(), objetoSelecionado.getCliente_id());
		clientesController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		novo();
		sucesso();
	}
	
	
	
	public Clientes getObjetoSelecionado() {
		return objetoSelecionado;
	}
	public void setObjetoSelecionado(Clientes objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	
	
	public List<SelectItem> getClientes() throws Exception{
		return clientesController.getListClientes();
	}
	
	public List<SelectItem> getProntuario() throws Exception{
		return clientesController.getListClientesPront();
	}	
	
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}
	
	@Override
	protected InterfaceCrud<Clientes> getController() {
	
		return clientesController;
	}
	
	@Override
	public void consultarEntidade() throws Exception {
		objetoSelecionado = new Clientes();
		list.clean();
		list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.SqlLazyQuery());
	}


	@Override
	public String condicaoAndParaPesquisa() throws Exception {
		// TODO Auto-generated method stub
		return "";
	}
	
	
}
