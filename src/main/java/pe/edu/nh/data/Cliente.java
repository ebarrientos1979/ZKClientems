package pe.edu.nh.data;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer edad;
	private String direccion;
	private Float peso;

}
