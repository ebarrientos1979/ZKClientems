package pe.edu.nh.binding;

import pe.edu.nh.ClienteData;
import pe.edu.nh.ModelMapperConfig;
import pe.edu.nh.data.Cliente;
import java.util.*;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class ClienteViewModel {	
	private Cliente miSeleccionado;
	private Cliente selected;
	private List<Cliente> clientes = new ArrayList<Cliente>(new ClienteData().getClientes());
	
	@Init
	public void init(@ExecutionArgParam("cliente") Cliente cliente) {
		this.selected = cliente;		
	}
	
	public Cliente getClienteSeleccionado() {
		miSeleccionado = new Cliente();
		ModelMapperConfig.copyProperties(selected, miSeleccionado);
		return miSeleccionado;
	}
	
		
	public List<Cliente> getClienteList(){
		return clientes;
	}
	
	public Cliente getSelectedCliente() {
		return this.selected;
	}
	
	@GlobalCommand
	@NotifyChange("clienteList")
	public void refrescarListaClientes(@BindingParam("cliente") Cliente cliente) {
		ModelMapperConfig.copyProperties(cliente, this.selected);
	}
	
	@Command
	public void grabar() {
		Map<String, Object> parametro = new HashMap<>();
		System.out.println(miSeleccionado.toString());
		parametro.put("cliente", miSeleccionado);
		BindUtils.postGlobalCommand(null, null, "refrescarListaClientes", parametro);
		this.cerrarModal();
	}
	
	@Command
	public void cerrarModal() {
		Component window = Executions.getCurrent().
					getDesktop().getFirstPage().getFellow("modalDialog");
		window.detach();
	}
	
	@Command	
	public void seleccionarCliente( @BindingParam("cliente") Cliente cliente ) {		
		this.selected = cliente;
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("cliente", cliente);
		
		Window window = (Window) Executions.
							createComponents("/cliente_modal.zul", null, parametros);
		
		window.doModal();
	}

}
