package br.com.alura.forum.config.security.filter;


import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;
    public AutenticacaoViaTokenFilter(TokenService tokenService,UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperaToken(request);

        boolean valido = tokenService.isTokenValido(token);

        if(valido){
            autenticarCliente(token);
        }

        System.out.println(valido);
        filterChain.doFilter(request,response);
    }

    private void autenticarCliente(String token) {

        long idUsuario = tokenService.getIdUsuario(token);
        Usuario usuario = userRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperaToken(HttpServletRequest request) {

        String token =  request.getHeader("Authorization");
        if( token == null || !token.startsWith("Bearer ") || token.isEmpty()){
            return null;
        }
        return token.substring(7,token.length());

    }
}
