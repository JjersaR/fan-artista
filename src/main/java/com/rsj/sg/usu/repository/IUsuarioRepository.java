package com.rsj.sg.usu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.usu.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {

}
