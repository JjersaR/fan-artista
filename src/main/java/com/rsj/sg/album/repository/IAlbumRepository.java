package com.rsj.sg.album.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.album.entity.Album;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, UUID> {

}
