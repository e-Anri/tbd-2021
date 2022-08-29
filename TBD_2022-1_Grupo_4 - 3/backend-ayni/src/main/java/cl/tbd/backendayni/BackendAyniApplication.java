package cl.tbd.backendayni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Voluntario;
import cl.tbd.backendayni.repositories.Dump;
import cl.tbd.backendayni.repositories.TareaRepository;
import cl.tbd.backendayni.repositories.VoluntarioRepository;

@SpringBootApplication
@RestController
public class BackendAyniApplication implements CommandLineRunner {
	@Autowired
	private TareaRepository repositoryTarea;
	@Autowired
	private VoluntarioRepository repositoryVoluntario;

	public static void main(String[] args) {
		SpringApplication.run(BackendAyniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repositoryTarea.deleteAll();
		// get today date as string
		repositoryTarea.save(new Tarea("1", "Recoger basura", "Recoger escombros, botarlos en un sitio seguro", "07/09/2022", "Pala, Rastrillo", "-33.389.804",
				"-70.655.240"));
		repositoryTarea.save(new Tarea("2", "Recoger ropa", "Recoger ropa para los necesitados", "28/06/2022", "Auto, Bolsas tamaño jumbo", "-33.450.758",
				"-70.679.715"));
		repositoryTarea.save(new Tarea("3", "Limpiar zona", "Limpiar zona afectada por la emergencia", "08/11/2022", "Pala, Chuzo", "-32.878.800",
				"-71.455.213"));
		repositoryTarea.save(new Tarea("4", "Alertar a personas", "Anunciar a las personas sobre la emergencia", "14/02/2022", "Megafono, Parlante", "-33.444.194",
				"-70.653.674"));
		repositoryTarea.save(new Tarea("5", "Poner centros de acopio", "Colocar centros de acopio para las personas necesitadas", "01/10/2022", "Mesas, Toldos", "-33.458.078",
				"-70.640.655"));

		repositoryVoluntario.deleteAll();
		repositoryVoluntario.save(new Voluntario("michaelRThomas@gmail.com", "Hatter", "Michael Thomas", "baebe2jei1Oh", "Responsable, Esforzado"));
		repositoryVoluntario.save(new Voluntario("kyleFDulac@gmail.com", "Hinceeng49", "Kyle Dulac", "jeeFi7ae", "Eficiente, Acertivo"));
		repositoryVoluntario.save(new Voluntario("susanBTaylor@gmail.com", "Beeked", "Susan Taylor", "oahee9AeNg5", "Flojo, Certero"));
		repositoryVoluntario.save(new Voluntario("maryDWisniewski@gmail.com", "Dialt1937", "Mary DWisneiwski", "Aeveip5xu2", "Honesto, Insoportable"));

	}

}