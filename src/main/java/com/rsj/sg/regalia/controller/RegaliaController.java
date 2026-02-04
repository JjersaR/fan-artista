package com.rsj.sg.regalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.regalia.service.RegaliaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regalia/v1")
public class RegaliaController {

  private final RegaliaService service;

}
