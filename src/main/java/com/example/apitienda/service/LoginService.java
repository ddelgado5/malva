package com.example.apitienda.service;

import com.example.apitienda.pojo.User;
import com.example.apitienda.repository.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private Log LOG = LogFactory.getLog(LoginService.class);

    private UserDao userDao;

    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(String usuario, String clave){
        System.out.println("login: " + usuario + " - "+ clave);
        User user = userDao.findByUsuarioClave(usuario, clave);
        if(user != null){
            System.out.println("se loguea: " + usuario + " - "+ clave);
            return true;
        }
        return false;
    }

}
