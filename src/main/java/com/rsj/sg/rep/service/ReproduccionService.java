package com.rsj.sg.rep.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.rep.repository.IReproduccionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReproduccionService {

  private final IReproduccionRepository repository;
}
