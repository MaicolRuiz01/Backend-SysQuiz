package co.com.example.test.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import lombok.Data;
@Component
@Data
public class SpringUtil implements ApplicationContextAware{
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
	}

	public static String processTemplate(String templateName, Context context) {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());
	    return templateEngine.process("templates/" + templateName + ".html", context);
	}


	

}
