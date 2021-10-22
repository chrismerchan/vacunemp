package corp.kruger.health.exception;

import org.springframework.http.ResponseEntity;


/*
 * Class: ResponseEntityBuilder
 * 
 * Clase publica que construye un objeto Response
 * para el manejo de excepciones con mensaje personalizado
 */
public class ResponseEntityBuilder {
	
	public static ResponseEntity<Object> build(ApiError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}