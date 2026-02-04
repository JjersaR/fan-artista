package com.rsj.sg.playlist.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_canciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "playlistId", "posicion" })
}, indexes = {
    @Index(name = "idx_pc_playlist", columnList = "playlistId"),
    @Index(name = "idx_pc_cancion", columnList = "cancionId")
})
@EntityListeners(AuditingEntityListener.class)
public class PlaylistCancion {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private UUID playlistId;

  @Column(nullable = false)
  private UUID cancionId;

  @Column(nullable = false)
  private Integer posicion;

  @CreatedDate
  private LocalDateTime agregadoEn;
}
