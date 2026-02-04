package com.rsj.sg.autor.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.autor.repository.IArtistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistaService {

  private final IArtistaRepository repository;
}
