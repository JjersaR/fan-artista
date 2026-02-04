package com.rsj.sg.rep.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
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
@Table(name = "reproducciones", indexes = {
    @Index(name = "idx_reproduccion_usuario_cancion", columnList = "usuario_id,cancion_id, fecha_reproduccion")
})
@EntityListeners(AuditingEntityListener.class)
public class Reproduccion {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private UUID usuarioId;

  @Column(nullable = false)
  private UUID cancionId;

  @Column(nullable = false)
  private UUID artistaId;

  @Column(nullable = false)
  private LocalDateTime fechaReproduccion; // cuándo ocurrió el evento

  @Column(nullable = false)
  private Integer duracionEscuchadaSegundos; // Cuántos segundos escuchó realmente

  private boolean reproduccionCompleta; // Si se escucharon + de 30 segundos

  private Integer segundosAnuncio = 0; // Segundos de anuncios mostrados en esta reproducción

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EFuenteReproduccion fuente; // APP_IOS, APP_ANDROID, WEB, API

  private String dispositivo;
  private String ipAddress;
  private String pais;

  @Column(precision = 10, scale = 4)
  private BigDecimal gananciaGenerada = BigDecimal.ZERO;

  private boolean conteoValido = true; // Para evitar fraudes

  // Campos para cálculos de regalías
  @Enumerated(EnumType.STRING)
  private ETipoStream tipoStream; // AD_SUPPORTED, PREMIUM, TRIAL

  @Column(precision = 10, scale = 4)
  private BigDecimal tarifaPorStream = BigDecimal.ZERO;

  @Column(nullable = false)
  private boolean procesadoParaPagos = false;

  private LocalDateTime fechaProcesamientoPago;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn; // cuándo ocurrió el evento
}
