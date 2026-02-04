package com.rsj.sg.pago.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.pago.repository.IPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoService {

  private final IPagoRepository repository;
}
