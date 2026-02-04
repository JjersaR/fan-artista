package com.rsj.sg.anun.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.anun.entity.Anuncio;

@Repository
public interface IAnuncioRepository extends JpaRepository<Anuncio, UUID> {

}
