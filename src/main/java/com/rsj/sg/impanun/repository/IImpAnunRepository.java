package com.rsj.sg.impanun.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.impanun.entity.ImpresionAnuncio;

@Repository
public interface IImpAnunRepository extends JpaRepository<ImpresionAnuncio, UUID> {

}
