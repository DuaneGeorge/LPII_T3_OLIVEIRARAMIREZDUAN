package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.MedicoEntity;
import java.util.List;



@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {
	
	//creamos el metodo para buscar por correo//ESTA ES UNA CONSULTA DERIVADA
		MedicoEntity findByEmail(String email);
	
}
