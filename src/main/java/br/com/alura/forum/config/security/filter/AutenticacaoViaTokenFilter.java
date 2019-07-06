package br.com.alura.forum.config.security.filter;


import br.com.alura.forum.config.security.TokenService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public AutenticacaoViaTokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperaToken(request);

        boolean valido = tokenService.isTokenValido(token);

        System.out.println(valido);
        filterChain.doFilter(request,response);
    }

    private String recuperaToken(HttpServletRequest request) {

        String token =  request.getHeader("Authorization");
        if( token == null || !token.startsWith("Bearer ") || token.isEmpty()){
            return null;
        }
        return token.substring(7,token.length());

    }
}
