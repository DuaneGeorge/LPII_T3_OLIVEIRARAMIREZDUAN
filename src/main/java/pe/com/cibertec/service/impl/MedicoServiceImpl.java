package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.MedicoEntity;
import pe.com.cibertec.repository.MedicoRepository;
import pe.com.cibertec.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;

	//METODO LISTAR MEDICOS
	@Override
	public List<MedicoEntity> buscarTodosMedicos() {
		// TODO Auto-generated method stub
		return medicoRepository.findAll();
	}

	//METODO BUSCAR MEDICO
	@Override
	public MedicoEntity buscarMedicoPorId(Integer id) {
		// TODO Auto-generated method stub
		return medicoRepository.findById(id).get();
	}

	//METODO CREAR MEDICO(FORMULARIO)
	@Override
	public void crearMedico(MedicoEntity medicoEntity) {
		// TODO Auto-generated method stub
		medicoRepository.save(medicoEntity);
	}

	//METODO ACTUALIZAR
		@Override
		public void actualizarMedico(Integer id, MedicoEntity medicoNuevo) {
			// TODO Auto-generated method stub
			MedicoEntity medicoEncontrado = buscarMedicoPorId(id);
			if (medicoEncontrado == null) {
				throw new RuntimeException("Medico no encontrado");			
			}try {
				medicoEncontrado.setNombre(medicoNuevo.getNombre());
				medicoEncontrado.setApellido(medicoNuevo.getApellido());
				medicoEncontrado.setDni(medicoNuevo.getDni());
				medicoEncontrado.setEstadoCivil(medicoNuevo.getEstadoCivil());
				medicoEncontrado.setFechaNacimiento(medicoNuevo.getFechaNacimiento());
				medicoRepository.save(medicoEncontrado);
			} catch (Exception e) {
				throw new RuntimeException("Ocurrio un error al actualizar");
			}		
		}

	@Override
	public void eliminarMedico(Integer id) {
		// TODO Auto-generated method stub
		MedicoEntity medicoEncontrado = buscarMedicoPorId(id);
		if (medicoEncontrado != null) {
			medicoRepository.delete(medicoEncontrado);
		}
		
	}

	@Override
	public MedicoEntity buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return medicoRepository.findByEmail(email);
	}

}
