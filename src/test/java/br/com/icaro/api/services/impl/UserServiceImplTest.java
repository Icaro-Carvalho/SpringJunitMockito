package br.com.icaro.api.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.icaro.api.domain.User;
import br.com.icaro.api.domain.dto.UserDTO;
import br.com.icaro.api.repositories.UserRepository;
import br.com.icaro.api.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class UserServiceImplTest {
	
	@InjectMocks //Vai criar uma instância real, pq vou testar os métodos dela
	private UserServiceImpl userServiceImpl;
	@Mock //Dados de mentira
	private UserRepository userRepository;
	@Mock
	private ModelMapper mapper;
	private User user;
	private UserDTO userDTO;
	private Optional<User> optionalUser;
	
	@BeforeEach //Antes de tudo, faça o seguinte código
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(optionalUser); //Mockando o repository
		User response = userServiceImpl.findById(user.getId()); //Criando uma resposta com o User
		Assertions.assertNotNull(response); //Assegunrado se a resposta não é nula
		assertEquals(User.class, response.getClass()); //Verificando se a resposta é um user
		assertEquals(user.getId(), response.getId());
		assertEquals(user.getName(), response.getName());
		assertEquals(user.getEmail(), response.getEmail());
	}
	
	@Test
	void whenFindByIdThenReturnAnObjectNotFoundException() {
		when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));
		try {
			userServiceImpl.findById(user.getId());
		} catch (Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
			assertEquals("Objeto não encontrado", ex.getMessage());
		}
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	
	private void startUser() {
		user = new User(1, "Valdir", "valdir@email.com", "123");
		userDTO = new UserDTO(1, "Valdir", "valdir@email.com", "123");
		optionalUser = Optional.of(new User(1, "Valdir", "valdir@email.com", "123"));
	}

}
