package com.example.apitienda.jwt.sec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET = "dianadelgado";

    public String extraerUsuario(String token) {
        return extraerClaims(token, Claims::getSubject);
    }

    public Date extraerExpiracion(String token) {
        return extraerClaims(token, Claims::getExpiration);
    }
    public Boolean isValidToken(String token) {
        return extraerExpiracion(token).before(new Date());
    }

    public <T> T extraerClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extraerAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extraerAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public String generarToken(String usuario, String clave) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("clave",clave);
        return crearToken(claims, usuario);
    }

    public String crearToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256,
                        SECRET).compact();

    }

    public Boolean validar(String token, UserDetails userDetails) {
        final String username = extraerUsuario(token);
        return username.equals(userDetails.getUsername()) && !isValidToken(token);
    }
}
