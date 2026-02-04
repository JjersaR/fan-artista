package com.rsj.sg.autor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.autor.service.ArtistaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/artista/v1")
public class ArtistaController {

  private final ArtistaService service;

}
