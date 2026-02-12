package com.rsj.sg.cancion.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.cancion.repository.ICancionArchivoAudioRepository;
import com.rsj.sg.cancion.repository.ICancionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CancionService {

  private final ICancionRepository repository;
  private final ICancionArchivoAudioRepository cancionAArepository;
}
