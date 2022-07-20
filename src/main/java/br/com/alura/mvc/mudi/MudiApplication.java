package br.com.alura.mvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching//habilitar o cash
@SpringBootApplication
public class MudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}
	
//	obs: toda vez que eu tentar acessar e outros usuários tentarem acessar
//	esse conteúdo dessa página, nossa aplicação não vai mais no banco
//	de dados, ou seja, é um descanso para o MariaDB, esse cache, ou seja, 
//	Ele cacheou aquele conteúdo.
	
}
