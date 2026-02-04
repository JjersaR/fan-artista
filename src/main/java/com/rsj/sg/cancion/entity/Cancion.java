package com.rsj.sg.cancion.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import lombok.Data;

@Data
@Entity
@Table(name = "canciones")
@EntityListeners(AuditingEntityListener.class)
public class Cancion {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String titulo;

  @ManyToOne
  @JoinColumn(name = "artista_id", nullable = false)
  private Artista artista;

  /*
   * @ManyToOne
   *
   * @JoinColumn(name = "album_id")
   * private Album album;
   */

  private Integer numeroPista;

  @Column(nullable = false)
  private Integer duracionSegundos;

  @Column(nullable = false)
  private String archivoAudioUrl;

  private String archivoAudioKey; // Key en S3/Cloud Storage

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EEstadoContenido estado = EEstadoContenido.PENDIENTE;

  /*
   * @ElementCollection
   *
   * @CollectionTable(name = "cancion_generos", joinColumns = @JoinColumn(name =
   * "cancion_id"))
   *
   * @Column(name = "genero")
   * private Set<String> generos = new HashSet<>();
   */

  private LocalDate fechaLanzamiento;

  @Column(precision = 10, scale = 4)
  private BigDecimal precioStream = BigDecimal.ZERO; // Para streams pagados

  private boolean explicita = false;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasGeneradas = BigDecimal.ZERO;

  private Long totalReproducciones = 0L;

  private Long reproduccionesEsteMes = 0L;

  // Metadata técnica
  private Integer bitrate; // kbps
  private String codec; // mp3, flac, aac
  private Long tamanoBytes;

  /*
   * @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
   * private List<Reproduccion> reproducciones;
   */

  // Audit
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
