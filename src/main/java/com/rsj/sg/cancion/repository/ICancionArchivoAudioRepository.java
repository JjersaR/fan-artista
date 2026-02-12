package com.rsj.sg.cancion.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.cancion.entity.CancionArchivoAudio;

@Repository
public interface ICancionArchivoAudioRepository extends JpaRepository<CancionArchivoAudio, UUID> {

}
