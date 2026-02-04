package com.rsj.sg.rep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.rep.service.ReproduccionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reproduccion/v1")
public class ReproduccionController {

  private final ReproduccionService service;

}
