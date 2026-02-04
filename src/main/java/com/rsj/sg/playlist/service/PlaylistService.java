package com.rsj.sg.playlist.service;

import org.springframework.stereotype.Service;

import com.rsj.sg.playlist.repository.IListCancionRepository;
import com.rsj.sg.playlist.repository.IPlaylistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistService {

  private final IPlaylistRepository repository;
  private final IListCancionRepository listRepository;
}
