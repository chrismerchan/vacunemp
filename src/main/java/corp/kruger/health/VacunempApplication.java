package corp.kruger.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/*
 * Clase principal del proyecto Spring Boot
 * Ejecuta la aplicacion vacunemp
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
public class VacunempApplication {

	// main
	public static void main(String[] args) {
		SpringApplication.run(VacunempApplication.class, args);
	}

}
