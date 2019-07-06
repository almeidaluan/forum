package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void findByEmail(){

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setEmail("aluno@email.com");
        usuario.setSenha("1234");

        Optional<Usuario> usuarioExiste = userRepository.findByEmail("aluno@email.com");
        Optional<Usuario> usuarioNExiste = userRepository.findByEmail("Fualano@Ciclano.com");

        Assert.assertEquals(userRepository.findByEmail("aluno@email.com"),Optional.of(usuario));
        Assert.assertNotNull(usuarioExiste);
        Assert.assertEquals(Optional.empty(),usuarioNExiste);

    }

}
