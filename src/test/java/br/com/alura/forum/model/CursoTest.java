package br.com.alura.forum.model;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoTest {

    @Test
    public void getIdTest(){
        Curso curso = new Curso();
        curso.setId(1L);
       Assert.assertEquals(curso.getId(),Long.valueOf(1));
    }

    @Test
    public void getNomeTest(){
        Curso curso = new Curso();
        curso.setNome("NovoNome");
        Assert.assertEquals(curso.getNome(),"NovoNome");
    }

    @Test
    public void getCategoriaTest(){
        Curso curso = new Curso();
        curso.setCategoria("NovaCategoria");
        Assert.assertEquals(curso.getCategoria(),"NovaCategoria");
    }



}
