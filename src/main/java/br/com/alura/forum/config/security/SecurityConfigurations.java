package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //Configuração de autenticação
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/topicos").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/topicos/*").permitAll();
    }
    //Configuração de Autorização
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);

    }

    //Configuração de recursos estaticos(js,css,imagens,etc ...) utilizado quando se usa jsp,thymeleaf
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}