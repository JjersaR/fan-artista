package com.rsj.sg.autor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.autor.entity.Artista;

@Repository
public interface IArtistaRepository extends JpaRepository<Artista, UUID> {

}
