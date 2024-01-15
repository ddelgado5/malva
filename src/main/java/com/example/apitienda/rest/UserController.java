package com.example.apitienda.rest;

import com.example.apitienda.constantes.TiendaConstantes;
import com.example.apitienda.service.UserService;
import com.example.apitienda.util.TiendaUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path="/user")
public class UserController {

    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<String> registroUsuario(@RequestBody(required=true)Map<String, String> requestMap){
        try{
            return userService.signUp(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return TiendaUtils.getResponseEntity(TiendaConstantes.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody(required=true)Map<String, String> requestMap){
        try{
            return userService.login(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return TiendaUtils.getResponseEntity(TiendaConstantes.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
