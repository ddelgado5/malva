package com.example.apitienda.service.impl;

import com.example.apitienda.constantes.TiendaConstantes;
import com.example.apitienda.jwt.Customerlp;
import com.example.apitienda.jwt.sec.JwtUtil;
import com.example.apitienda.pojo.User;
import com.example.apitienda.repository.UserDao;
import com.example.apitienda.service.UserService;
import com.example.apitienda.util.TiendaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Customerlp customerlp;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap){
        log.info("resgistro nuevo de usuario: ", requestMap);

        try{
            if(validateSignUp(requestMap)) {
                User user = userDao.findByUsuario(requestMap.get("usuario"));
                if (!Objects.isNull(user)) {
                    return TiendaUtils.getResponseEntity("El usuario ya existe", HttpStatus.BAD_REQUEST);
                }
                userDao.save(getUserFrom(requestMap));
                return TiendaUtils.getResponseEntity("Registro Éxitoso", HttpStatus.CREATED);
            }else{
                return TiendaUtils.getResponseEntity(TiendaConstantes.ERROR, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return TiendaUtils.getResponseEntity(TiendaConstantes.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requeMap) {
        log.info("********* Login *********");
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(requeMap.get("usuario"), requeMap.get("clave")));
            if(authentication.isAuthenticated()){
                return new ResponseEntity<String>("{\"token\":\"" + jwtUtil
                        .generarToken(customerlp.getUserDetail().getUsuario(), customerlp.getUserDetail().getClave())+ "\"}", HttpStatus.OK);

            }
        }catch (Exception e){
            log.error("Error: ", e);
        }
        return new ResponseEntity<String>("{\"mensaje\":\"" +"Credenciales incorrectas "+ "\"}", HttpStatus.BAD_REQUEST);
    }

    private boolean validateSignUp(Map<String, String> requestMap){
        if(requestMap.containsKey("usuario") && requestMap.containsKey("clave")){
            return true;
        }
        return false;
    }
    private User getUserFrom(Map<String, String> requestMap){
        User user = new User();
        user.setUsuario(requestMap.get("usuario"));
        user.setClave(requestMap.get("clave"));
        return user;
    }
}
