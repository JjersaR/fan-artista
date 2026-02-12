package com.rsj.sg.cancion.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table(name = "cancion_archivos_audio", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "cancion_id", "version", "codec", "bitrate" })
})
@EntityListeners(AuditingEntityListener.class)
public class CancionArchivoAudio {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private UUID cancionId;

  @Version
  private Integer version = 1;

  private String codec; // mp3, aac, flac

  private Integer bitrate; // kbps

  private String extension;

  private String objectKey; // MinIO key

  private Long sizeBytes;

  private Integer duracionSegundos;

  private boolean activo;

  @CreatedDate
  private LocalDateTime creadoEn;
}
