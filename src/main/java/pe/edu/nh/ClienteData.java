package pe.edu.nh;

import java.util.*;

import pe.edu.nh.data.Cliente;

public class ClienteData {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteData() {				
		/*clientes.add(new Cliente("Edwin", "Barrientos", "Retuerto", 45, "Las Magnolias 123", 60F) );
		
		clientes.add(new Cliente("Luis", "Atencio", "Ignacio", 25, "Los Girasoles 235", 67.5F) );
		clientes.add(new Cliente("Miguel", "Mendoza", "Lopez", 37, "Los Cipreses 234", 40F) );
		clientes.add(new Cliente("Antonio", "Perez", "De la Cruz", 29, "Carretera Central 654", 70.4F) );
		clientes.add(new Cliente("Jose Miguel", "Porras", "Colchado", 31, "Los Jeroglifos 239", 80.5F) );
		*/
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
}
