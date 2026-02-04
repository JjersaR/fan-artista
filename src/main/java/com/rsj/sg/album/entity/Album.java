package com.rsj.sg.album.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rsj.sg.autor.entity.Artista;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")
@EntityListeners(AuditingEntityListener.class)
public class Album {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String titulo;

  @ManyToOne
  @JoinColumn(name = "artista_id", nullable = false)
  private Artista artista;

  private String portadaUrl;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoAlbum tipo; // ALBUM, EP, SINGLE, COMPILACION

  /*
   * @CollectionTable(name = "album_generos", joinColumns = @JoinColumn(name =
   * "album_id"))
   *
   * @Column(name = "genero")
   * private Generos generos = new HashSet<>();
   * private List<Generos> generos;
   */

  private LocalDate fechaLanzamiento;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasGeneradas = BigDecimal.ZERO;

  private Long totalReproducciones = 0L;

  // Audit
  @CreatedDate
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
