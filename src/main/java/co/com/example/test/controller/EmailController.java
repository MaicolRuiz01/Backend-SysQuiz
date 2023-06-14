package co.com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.entity.PreRegistro;
import co.com.example.test.entity.Usuario;
import co.com.example.test.service.MailService;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class EmailController {
	
	@Autowired
	MailService mailService;
	
	@GetMapping("/new")
	public ResponseEntity<?> correoBienvenida(@RequestBody PreRegistro usuario){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mailService.usuarioNuevo(usuario));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	@GetMapping("/cambio")
	public ResponseEntity<?> correoCodigoCambio(@RequestBody Usuario usuario,Integer codigo){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mailService.cambioPassword(usuario,codigo));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
	}
	

}
