package com.rsj.sg.usu.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rsj.sg.usu.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {

  Optional<Usuario> findById(UUID id);

  Optional<Usuario> findByUsername(String username);

  Optional<Usuario> findByEmail(String email);

  @Query("SELECT u FROM Usuario u WHERE u.username = ?1 OR u.email = ?1")
  Optional<Usuario> findByUsernameOrEmail(String username);

}
