package br.com.alura.forum.modelo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;


    public String getId() {
        return id;
    }

    public String getPerfil() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerfil(String nome) {
        this.nome = nome;
    }


    @Override
    public String getAuthority() {
        return this.nome;
    }
}
