package com.rsj.sg.playlist.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist", indexes = {
    @Index(name = "idx_playlist_usuario", columnList = "usuarioId"),
    @Index(name = "idx_playlist_publica", columnList = "publica")
})
@EntityListeners(AuditingEntityListener.class)
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String nombre;

  private String descripcion;

  private UUID usuarioId;

  private String portadaUrl;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoPlaylist publica = ETipoPlaylist.PRIVADA;

  private Integer totalCanciones = 0;

  private Integer duracion = 0;

  // Audit
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
