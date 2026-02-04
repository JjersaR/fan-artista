package com.rsj.sg.anun.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "anuncios", indexes = {
    @Index(name = "idx_anuncio_estado_fechas", columnList = "estado,fechaInicio,fechaFin"),
    @Index(name = "idx_anuncio_tipo", columnList = "tipo")
})
@EntityListeners(AuditingEntityListener.class)
public class Anuncio {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String titulo;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoAnuncio tipo; // AUDIO, VIDEO, BANNER, INTERSTITIAL

  @Column(nullable = false)
  private String archivoMediaUrl;

  private Integer duracionSegundos; // para audio y video

  @Column(nullable = false)
  private String urlDestino;

  // @ManyToOne
  // @JoinColumn(name = "advertiser_id")
  // private Advertiser advertiser;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoPago tipoPago; // CPM, CPC, CPA

  @Column(precision = 10, scale = 4)
  private BigDecimal precioUnitario;

  @Column(nullable = false)
  private LocalDateTime fechaInicio;

  private LocalDateTime fechaFin;

  private Long impresionesMaximas;

  private Long impresionesActuales = 0L;

  private Long clicksActuales = 0L;

  @ElementCollection
  @CollectionTable(name = "anuncio_paises", joinColumns = @JoinColumn(name = "anuncio_id"))
  @Column(name = "pais")
  private Set<String> paisesObjetivo = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "anuncio_generos", joinColumns = @JoinColumn(name = "anuncio_id"))
  @Column(name = "genero")
  private Set<String> generosObjetivo = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EEstadoAnuncio estado;

  // @OneToMany(mappedBy = "anuncio")
  // private List<ImpresionAnuncio> impresiones;

  // Audit
  @CreatedDate
  private LocalDateTime creadoEn;
}
