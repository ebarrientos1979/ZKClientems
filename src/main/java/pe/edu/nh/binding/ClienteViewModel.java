package pe.edu.nh.binding;

import pe.edu.nh.ClienteData;
import pe.edu.nh.data.Cliente;
import java.util.*;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class ClienteViewModel {
	private Cliente selected;
	private List<Cliente> clientes = new ArrayList<Cliente>(new ClienteData().getClientes());
	
	@Init
	public void init(@ExecutionArgParam("cliente") Cliente cliente) {
		this.selected = cliente;
	}
	
	public List<Cliente> getClienteList(){
		return clientes;
	}
	
	public Cliente getSelectedCliente() {
		return this.selected;
	}
	
	@Command
	public void grabar( @BindingParam("selectedCliente") Cliente selectedCliente) {
		System.out.println(selectedCliente.getNombre());
	}
	
	@Command
	public void cerrarModal() {
		Component window = Executions.getCurrent().
					getDesktop().getFirstPage().getFellow("modalDialog");
		window.detach();
	}
	
	@Command
	@NotifyChange("*")
	public void seleccionarCliente( @BindingParam("cliente") Cliente cliente ) {
		System.out.println(cliente.getNombre());
		this.selected = cliente;
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("cliente", cliente);
		
		Window window = (Window) Executions.
							createComponents("/cliente_modal.zul", null, parametros);
		
		window.doModal();
	}

}
