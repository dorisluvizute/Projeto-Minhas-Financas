package com.udemy.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.udemy.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//Isso faz com que ao rodar ele execute o banco de teste (application-test.properties)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//ação / execução
		boolean result = repository.existsByEmail("usuario@email.com");		
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}
	
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//cenário
		repository.deleteAll();
		
		//ação / execução
		boolean result = repository.existsByEmail("usuario@email.com");	
		
		//verificação
		Assertions.assertThat(result).isFalse();		
	}
	
	

}
