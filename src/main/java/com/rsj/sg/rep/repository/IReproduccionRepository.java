package com.rsj.sg.rep.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.rep.entity.Reproduccion;

@Repository
public interface IReproduccionRepository extends JpaRepository<Reproduccion, UUID> {

}
