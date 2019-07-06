package br.com.alura.forum.config.security.filter;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperaToken(request);
        System.out.println("O Token Recuperado:" + token);
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
