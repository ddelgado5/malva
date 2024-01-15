package com.example.apitienda.repository;

import com.example.apitienda.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE u.usuario = ?1")
    User findByUsuario(String usuario);

    @Query("SELECT u FROM users u WHERE u.usuario = ?1 AND u.clave = ?2")
    User findByUsuarioClave(String usuario, String clave);
}
