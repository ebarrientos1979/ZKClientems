package pe.edu.nh.msClientes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.nh.msClientes.dto.ClienteDTO;
import pe.edu.nh.msClientes.model.Respuesta;
import pe.edu.nh.msClientes.service.ClienteService;

@RestController
@RequestMapping("/v1/cliente")
@CrossOrigin(origins="*")
public class ClienteController {
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@GetMapping("listar")
	public ResponseEntity<List<ClienteDTO>> getClientes(){
		return ResponseEntity.ok(this.clienteService.getAllClientes());
	}
	
	@PostMapping("save")
	public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDto){
		return ResponseEntity.ok(this.clienteService.saveCliente( clienteDto ));
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Respuesta> eliminarCliente(@RequestBody ClienteDTO clienteDto){
		this.clienteService.eliminarCliente(clienteDto);
		return ResponseEntity.ok( Respuesta.builder().
				valor(1).mensaje("El cliente se elimino correctamente").build() );
	}
}