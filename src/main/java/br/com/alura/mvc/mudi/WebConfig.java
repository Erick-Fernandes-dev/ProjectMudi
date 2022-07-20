package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.alura.mvc.mudi.interceptor.InterceptadorDeAcessos;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override//criar um interceptador
    protected void addInterceptors(InterceptorRegistry registry) {
        
        //vai interceptar todas as requisições
        registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**");


    }
    
}
