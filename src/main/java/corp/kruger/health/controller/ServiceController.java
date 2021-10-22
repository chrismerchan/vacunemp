package corp.kruger.health.controller;

import java.net.URI;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import corp.kruger.health.exception.ResourceNotFoundException;
import corp.kruger.health.model.Employee;
import corp.kruger.health.repository.EmployeeRepository;

/*
 * Class: ServiceController
 * 
 * Clase controlador que define las operaciones o metodos
 * HTML que seran empleados en la implementacion del 
 * servicio REST
 */

@RestController
@RequestMapping("/api")
@Validated
public class ServiceController {
	
	private EmployeeRepository repository;

	// constructor
	@Autowired
	public ServiceController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	/*
	 * Metodo: findall
	 * 
	 * Implementa la operacion GET, findall 
	 * Retorna la estructura de un empleado, puede retornar varios registros
	 * 
	 */
	@RolesAllowed("admin")
	@GetMapping("/findall")
	  public ResponseEntity<Iterable<Employee>> findAll(@RequestHeader String Authorization){
		  return ResponseEntity.ok(repository.findAll());
	}
	
	/*
	 * Metodo: findAllByVaccinationStatus
	 * 
	 * Implementa la operacion GET, findAllByVaccinationStatus 
	 * Retorna la estructura de un empleado, puede retornar varios registros
	 * 
	 */
	@RolesAllowed("admin")
	@GetMapping("/findall/{status}")
	  public ResponseEntity<Iterable<Employee>> findAllByVaccinationStatus(@PathVariable String status, 
			  @RequestHeader String Authorization){
		  return ResponseEntity.ok(repository.findAllByVaccinationStatus(status));
	 }
	
	/*
	 * Metodo: findbyid
	 * 
	 * Implementa la operacion GET, findbyid 
	 * Retorna la estructura de un empleado 
	 * 
	 */
	@RolesAllowed("admin")
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable long id, 
			@RequestHeader String Authorization) {
		Optional<Employee> employee = Optional.of(repository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Employee with ID :"+id+" Not Found!")));
    
		return ResponseEntity.ok().body(employee);
	}
	  
	/*
	 * Metodo: update
	 * 
	 * Implementa la operacion PUT, update sobre un 
	 * empleado existente
	 * 
	 */  
	@RolesAllowed({ "admin", "user" })
	@RequestMapping(value="/update/{id}", method = {RequestMethod.PUT})
	public ResponseEntity<?> update(@Valid @PathVariable("id") long id, @RequestBody Employee employee,
			Errors errors, @RequestHeader String Authorization){
	  
	  Optional<Employee> employeeData = repository.findById(id);
		//Employee result = repository.save(employee);
		
		if (employeeData.isPresent()) {
			
			Employee _employee = employeeData.get();
			_employee.setFirstName(employee.getFirstName());
			_employee.setLastName(employee.getLastName());
			_employee.setEmail(employee.getEmail());
			_employee.setDocumentID(employee.getDocumentID());
			_employee.setBirthday(employee.getBirthday());
			_employee.setAddress(employee.getAddress());
			_employee.setMobilePhone(employee.getMobilePhone());
			_employee.setVaccinationStatus(employee.getVaccinationStatus());
			_employee.setVaccine(employee.getVaccine());
			_employee.setVaccinationDate(employee.getVaccinationDate());
			_employee.setNumberDoses(employee.getNumberDoses());
			
			return new ResponseEntity<>(repository.save(_employee), HttpStatus.OK);
	    
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	  
	}
	
	/*
	 * Metodo: create
	 * 
	 * Implementa la operacion POST, create sobre un nuevo
	 * empleado
	 * 
	 */
	@RolesAllowed("admin")
	@RequestMapping(value="/create", method = {RequestMethod.POST})
	public ResponseEntity<?> create(@Valid @RequestBody Employee employee,
			Errors errors, @RequestHeader String Authorization){
	  
		Employee result = repository.save(employee);
		
		if (result.getId()!=0) {
			
			result.setUserDefault();
			result.setPasswordDefault();
			repository.save(result);
		}
		
		URI location = 
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
						result.getId()).toUri();
		return ResponseEntity.created(location).build();
	  
	}

}
