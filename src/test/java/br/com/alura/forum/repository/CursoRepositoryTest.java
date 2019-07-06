package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.service.AutenticacaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void CursoRepository(){

        Curso cursoExiste = cursoRepository.findByNome("Spring Boot");
        Curso cursoNExiste = cursoRepository.findByNome("Curso Aleatorio");

        Assert.assertNotNull(cursoExiste);
        Assert.assertNull(cursoNExiste);
    }
}
