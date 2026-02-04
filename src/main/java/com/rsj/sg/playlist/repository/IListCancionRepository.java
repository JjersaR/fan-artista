package com.rsj.sg.playlist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsj.sg.playlist.entity.PlaylistCancion;

@Repository
public interface IListCancionRepository extends JpaRepository<PlaylistCancion, UUID> {

}
