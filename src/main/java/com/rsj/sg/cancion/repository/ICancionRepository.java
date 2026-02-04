package com.rsj.sg.cancion.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.cancion.entity.Cancion;

@Repository
public interface ICancionRepository extends JpaRepository<Cancion, UUID> {

}
