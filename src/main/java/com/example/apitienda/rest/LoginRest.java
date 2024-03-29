//package com.example.apitienda.rest;
//
//import com.example.apitienda.pojo.User;
//import com.example.apitienda.service.LoginService;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//import io.jsonwebtoken.Jwts;
//
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//public class LoginRest {
//
//    private LoginService loginService;
//
//    public LoginRest(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @PostMapping("/login")
//    ResponseEntity login(@RequestBody User user){
//
//
//        String token = getJWTToken(user.getUsuario());
//        System.out.println("token");
//        System.out.println(token);
//
//        boolean isValida = loginService.login(user.getUsuario(), user.getClave());
//        if(isValida){
//            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
//        }
//        return new ResponseEntity<>("Usuario o contraseña no válido", HttpStatus.UNAUTHORIZED);
//    }
//
//    private String getJWTToken(String username) {
//        String secretKey = "dianaDelgado";
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
//
//        String token = Jwts
//                .builder()
//                .setId("softtekJWT")
//                .setSubject(username)
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 600000))
//                .signWith(SignatureAlgorithm.HS256,
//                        secretKey.getBytes()).compact();
//
//        return "Bearer " + token;
//    }
//}
