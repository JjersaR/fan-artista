package com.rsj.sg.autor.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rsj.sg.album.entity.Album;
import com.rsj.sg.cancion.entity.Cancion;
import com.rsj.sg.usu.entity.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "artistas", uniqueConstraints = {
    @UniqueConstraint(columnNames = "usuario_id")
})
@EntityListeners(AuditingEntityListener.class)
public class Artista {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne(optional = false)
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;

  @Column(nullable = false)
  private String nombreArtistico;

  private String biografia;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EEstadoVerificacion estadoVerificacion; // PENDIENTE, VERIFICADO, RECHAZADO

  private String website;
  private String instagramUrl;
  private String youtubeUrl;
  private String spotifyUrl;

  @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
  private List<Album> albumes;

  @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
  private List<Cancion> canciones;
  /*
   *
   * @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
   * private List<Merch> productosMerch;
   *
   * @OneToMany(mappedBy = "artista")
   * private List<ContratoArtista> contratos;
   *
   * @OneToOne(mappedBy = "artista", cascade = CascadeType.ALL)
   * private CuentaBancaria cuentaBancaria;
   */

  @Column(nullable = false, precision = 5, scale = 2)
  private BigDecimal porcentajeRegalias = new BigDecimal("90.00"); // 70% por defecto

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasTotales = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasDisponibles = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasRetiradas = BigDecimal.ZERO;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
