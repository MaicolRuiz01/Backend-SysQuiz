package co.com.example.test.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import co.com.example.test.entity.PDFGenerator;
import co.com.example.test.entity.Rol;
import co.com.example.test.repository.IRolRepository;

@RestController
@RequestMapping()
@CrossOrigin
public class PDFController {
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	IRolRepository rolRepository;
	
	  @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<byte[]> generatePdf() throws DocumentException, com.lowagie.text.DocumentException {
	        // Crea algunos datos de ejemplo
	        List<Rol> rol = rolRepository.findAll();
	        
	        

	        // Genera el PDF
	        byte[] pdf = PDFGenerator.generatePlatillaPDF(rol);

	        // Devuelve el PDF como una respuesta HTTP
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("attachment", "documento.pdf");
	        headers.setContentLength(pdf.length);

	        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
	    }
	
	   @GetMapping("/generate")
	    public ResponseEntity<?> generatePDF() throws Exception {
	        pdfGenerator.generatePDF(); 
	        File file = new File("reporte.pdf");
	        FileSystemResource resource = new FileSystemResource(file);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("attachment", file.getName());
	        headers.setContentLength(file.length());
	        
	        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	    }

}
