package com.rsj.sg.album.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsj.sg.album.service.AlbumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/album/v1")
public class AlbumController {

  private final AlbumService service;

}
