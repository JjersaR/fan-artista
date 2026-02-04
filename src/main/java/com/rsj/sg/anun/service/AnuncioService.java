package com.rsj.sg.anun.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.anun.repository.IAnuncioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnuncioService {

  private final IAnuncioRepository repository;
}
