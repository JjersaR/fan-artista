package com.rsj.sg.impanun.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.impanun.repository.IImpAnunRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpAnunService {

  private final IImpAnunRepository repository;
}
