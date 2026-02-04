package com.rsj.sg.impanun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.impanun.service.ImpAnunService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/impanun/v1")
public class ImpAnunController {

  private final ImpAnunService service;

}
