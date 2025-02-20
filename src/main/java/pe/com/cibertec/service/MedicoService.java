package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.MedicoEntity;

public interface MedicoService {
	

	List<MedicoEntity>buscarTodosMedicos();
	MedicoEntity buscarMedicoPorId(Integer id);
	void crearMedico(MedicoEntity medicoEntity);
	void actualizarMedico(Integer id, MedicoEntity medicoEntity);
	void eliminarMedico(Integer id);
	MedicoEntity buscarPorEmail(String email);

}
