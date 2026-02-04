package com.rsj.sg.anun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.anun.service.AnuncioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anuncio/v1")
public class AnuncioController {

  private final AnuncioService service;

}
