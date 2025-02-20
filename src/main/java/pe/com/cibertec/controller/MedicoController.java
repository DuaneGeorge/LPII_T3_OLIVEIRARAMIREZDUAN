package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.cibertec.model.MedicoEntity;
import pe.com.cibertec.service.MedicoService;




@Controller
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	//METODO LISTAR MEDICO
		@GetMapping("/")
		public String home(Model model) {
			List<MedicoEntity>listaMedico = medicoService.buscarTodosMedicos();
			model.addAttribute("lst_medico", listaMedico);
			return"listar_medico";
		}//fin del metodo listar
		
		//METODO BUSCAR MEDICO
		@GetMapping("/detalle_medico/{id}")
		public String verDetalle(Model model, @PathVariable("id")Integer id) {
			MedicoEntity medicoEncontrado = medicoService.buscarMedicoPorId(id);
			model.addAttribute("user", medicoEncontrado);
			return "detalle_medico";
		}//fin del metodo buscar
		
		//METODO BORRAR MEDICO
		@GetMapping("/delete/{id}")
		public String deleteMedico(@PathVariable("id")Integer id) {
			medicoService.eliminarMedico(id);
			return "redirect:/";
		}//fin del metodo borrar 
		
		//METODO REGISTRAR MEDICO
		@GetMapping("/registrar_medico")
		public String mostrarRegistrarMedico(Model model) {
			model.addAttribute("user", new MedicoEntity());
			return "registrar_medico";
		}//fin del metodo registar
		
		//METODO REGISTRAR USUARIO GUARDAR EN LA BD...
		@PostMapping("/registrar_medico")
		public String registrarMedico(@ModelAttribute("user") MedicoEntity user, Model model) {
		if (medicoService.buscarPorEmail(user.getEmail()) != null) {
			model.addAttribute("errorMessage", "El correo ya existe, usa otro");
			model.addAttribute("user", user);
			return "registrar_medico";
		}
			medicoService.crearMedico(user);
			return "redirect:/";
		}

}
