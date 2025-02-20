package pe.com.cibertec.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_medicot3")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedicoT3;
	
	@Column(name = "nombreT3", nullable = false)
	private String nombre;
	
	@Column(name = "apellidoT3", nullable = false)
	private String apellido;
	
	@Column(name = "emailT3", nullable = false, unique = true)
	private String email;
	
	@Column(name = "dniT3", nullable = false)
	private Integer dni;
	
	@Column(name = "estadoCivilT3", nullable = false)
	private String estadoCivil;
	
	@Column(name = "fechaNacimT3", nullable = false)
	private Date fechaNacimiento;
}
