package com.rsj.sg.album.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.album.repository.IAlbumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final IAlbumRepository repository;
}
