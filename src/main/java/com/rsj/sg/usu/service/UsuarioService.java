package com.rsj.sg.usu.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.usu.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

  private final IUsuarioRepository repository;
}
