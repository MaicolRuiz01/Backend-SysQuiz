package co.com.example.test.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import co.com.example.test.entity.PreRegistro;
import co.com.example.test.entity.Usuario;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;

	public boolean usuarioNuevo(PreRegistro preRegistro) throws MessagingException {

		MimeMessage mimeMessageHelpe = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessageHelpe, "UTF-8");
		String titulo = "PRE-REGISTRO";
		String url = "https://brayanguerreroxd.github.io/seadoc-frontend/register.html";
		String message = "Link página web :";
		String detalle = "El siguiente enlace es para completar el proceso de registro y  habilitar su cuenta para realizar las evaluciones correspondientes";
		Date fecha = new Date();
		Context context = new Context();
		context.setVariable("titulo", titulo);
		context.setVariable("message", message);
		context.setVariable("detalle", detalle);
		context.setVariable("url", url);
		context.setVariable("docente", preRegistro);
		context.setVariable("fecha", fecha);

		String htmlContent = templateEngine.process("email-template", context);
		messageHelper.setTo(preRegistro.getEmail());
		messageHelper.setSubject("EVALUACION DOCENTE");
		// messageHelper.setFrom("MENSAJE DE BIENVENIDA");
		messageHelper.setText(htmlContent, true);

		javaMailSender.send(mimeMessageHelpe);
		return true;

	}

	public boolean cambioPassword(Usuario usuario,Integer codigo) throws MessagingException {

		MimeMessage mimeMessageHelpe = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessageHelpe, "UTF-8");
		
		String titulo = "Recuperar Contraseña";
		String url = codigo+"";
		
		String detalle = "El siguiente codigo es para recuperar su contraseña en el sitio web evaluacion docente ";
		String message = "CODIGO : "  ;
		Date fecha = new Date();
		Context context = new Context();

		context.setVariable("titulo", titulo);
		context.setVariable("message", message);
		context.setVariable("detalle", detalle);
		context.setVariable("url", url);
		context.setVariable("docente", usuario);
		context.setVariable("fecha", fecha);

		String htmlContent = templateEngine.process("email-template", context);
		
		messageHelper.setTo(usuario.getEmail());
		messageHelper.setSubject("EVALUACION DOCENTE CODIGO RECUPERAR CONTRASEÑA");
		messageHelper.setText(htmlContent, true);

		javaMailSender.send(mimeMessageHelpe);
		return true;

	}

	public void cambioClaveExito(Usuario usuario) {
		SimpleMailMessage email = new SimpleMailMessage();

		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");

		String date = dateFormat.format(new java.util.Date());
		email.setTo(usuario.getEmail());
		email.setFrom("seadocingsistemas@gmail.com");
		email.setSubject(" MY NOTEBOOK'S :Cambio Clave");
		email.setText(
				"Estimado usuario se cambio la clave de tu cuenta personal :  \n \n \n No responder este mensaje \n \n BY:  MY NOTEBOOK "
						+ "\n \n Este correo se genero automaticamente: \n \n " + date);

		javaMailSender.send(email);

	}

}
