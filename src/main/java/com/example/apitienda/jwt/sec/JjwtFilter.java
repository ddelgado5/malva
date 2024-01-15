package com.example.apitienda.jwt.sec;

import com.example.apitienda.jwt.Customerlp;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JjwtFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "dianaDelgado";
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private Customerlp customerlp;
    private String usuario = null;
    Claims claims  = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        if(request.getServletPath().matches("/user/login|/user/signup")){
            chain.doFilter(request, response);
        }else{
            String authorizationHeader = request.getHeader(HEADER);
            String token = null;

            if(authorizationHeader != null && authorizationHeader.startsWith(PREFIX)){
                token = authorizationHeader.substring(7);
                usuario = jwtUtil.extraerUsuario(token);
                claims = jwtUtil.extraerAllClaims(token);
            }
            if(usuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = customerlp.loadUserByUsername(usuario);
                if(jwtUtil.validar(token, userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    new WebAuthenticationDetailsSource().buildDetails(request);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request,response);
        }
    }

    public String obtenerUsuarioActual(){
        return usuario;
    }
}
