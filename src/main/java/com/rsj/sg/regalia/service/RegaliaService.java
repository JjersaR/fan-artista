package com.rsj.sg.regalia.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.regalia.repository.IRegaliaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegaliaService {

  private final IRegaliaRepository repository;
}
