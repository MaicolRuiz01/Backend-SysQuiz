package co.com.example.test.entity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.util.XRLog;

import com.itextpdf.text.DocumentException;

import co.com.example.test.repository.IRolRepository;
import co.com.example.test.service.SpringUtil;

@Service
public class PDFGenerator {
	
	@Autowired
	IRolRepository rolRepository;
	private Date fecha=new Date();
	
	  public static byte[] generatePlatillaPDF(List<Rol> rol) throws DocumentException, com.lowagie.text.DocumentException {
	        // Crea un contexto Thymeleaf y agrega los datos
	        Context context = new Context();
	        context.setVariable("date", new java.util.Date());
	        context.setVariable("rol", rol);

	        // Procesa la plantilla y obtiene el HTML resultante
	        String html = SpringUtil.processTemplate("template", context);

	        // Carga el HTML en el renderizador de XHTML
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocumentFromString(html);

	        // Agrega las fuentes necesarias para el renderizador
	        try {
	            renderer.getFontResolver().addFont("classpath:/fonts/arial.ttf", "Arial", true);
	        } catch (Exception e) {
	            XRLog.exception("No se pudo cargar la fuente", e);
	        }

	        // Renderiza el documento PDF
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        renderer.layout();
	        renderer.createPDF(out);

	        return out.toByteArray();
	    }
	
	 public  void generatePDF() throws Exception {
		 
		 	List<Rol>lista=rolRepository.findAll();
		 	String body="";
		 	for (int i = 0; i < lista.size(); i++) {
		 		body+="<tr>"
		 				+ "<td>"+lista.get(i).getId()+"</td>"
		 				+ "<td>"+lista.get(i).getNombre()+"</td>"
		 				+ "<td>"+fecha+"</td>"
		 				+ "<td><a href=\"#\" class=\"text-dark \">CAMBIAR</a></td>"
		 			+ "</tr>";
				
			}
		 	
	        String html = "<html> "
	        		+ " <meta charset=\"UTF-8\" />"
	        		+ " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />"
	        		+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
	        		+ "<head> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\"/></head>"
	        		+ "<body>"
	        		+ "<p class=\"fw-bold\"> MY NOTEBOOK</p>"
	        		+ "<h1 class=\"text-center\" >Reporte Autoevaluacion 2023 </h1> "
	        		+ "<p class=\"fw-bold\"> Ejemplo reporte roles registrados en el sistema "+fecha+"</p>"
	        		+ "<div class=\"col-8 text-center\">"
	        		+ "<table class=\"table text-center \">"
	        		+ "<thead>"
	        		+ "<tr>"
	        		+ "<th>ID</th>"
	        		+ "<th>NOMBRE</th>"
	        		+ "<th>FECHA</th>"
	        		+ "<th>OPCION</th>"
	        		+ "</tr>"
	        		+ "</thead>"
	        		+ "<tbody>"+body+"</tbody>"
	        		+ "</table>"
	        		+ "</div>"
	        		+ "</body>"
	        		+ "</html>";
	       
	        
	        List<String> fontFamilies = new ArrayList<>();
	        
	        fontFamilies.add("Arial");
	        Resource resource=new ClassPathResource("/index.html");
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocumentFromString(html);
	     //  renderer.getFontResolver().setFont("Arial", "C:\\Windows\\Fonts\\arial.ttf");
	        renderer.layout();
	        
	        OutputStream outputStream = new FileOutputStream(new File("reporte.pdf"));
	        renderer.createPDF(outputStream);
	        outputStream.close();
	    }
	   
	 
	

}
