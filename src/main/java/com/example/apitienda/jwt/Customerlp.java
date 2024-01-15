package com.example.apitienda.jwt;

import com.example.apitienda.pojo.User;
import com.example.apitienda.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class Customerlp implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    private User user;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        log.info("usuario: ", usuario);
        user = userDao.findByUsuario(usuario);
        if(!Objects.isNull(user)){
            System.out.println("------------------------------*************************************------------------------------");
            return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getClave(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("No existe en la DB.");
        }
    }

    public User getUserDetail(){
        return user;
    }
}
