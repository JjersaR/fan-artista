package com.rsj.sg.impanun.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rsj.sg.anun.entity.ETipoPago;

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
@Table(name = "impresiones_anuncio", indexes = {
    @Index(name = "idx_imp_anuncio_fecha", columnList = "anuncioId,fechaImpresion"),
    @Index(name = "idx_imp_usuario_fecha", columnList = "usuarioId,fechaImpresion"),
    @Index(name = "idx_imp_evento", columnList = "tipoEvento"),
    @Index(name = "idx_imp_ip", columnList = "ipAddress") })
@EntityListeners(AuditingEntityListener.class)
public class ImpresionAnuncio {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private UUID anuncioId;

  private UUID usuarioId;

  private UUID reproduccionId;

  @Column(nullable = false)
  private LocalDateTime fechaImpresion;

  private ETipoEventoAnuncio tipoEvento; // IMPRESION, CLICK, COMPLETADO

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoPago tipoPago;

  @Column(precision = 10, scale = 4)
  private BigDecimal gananciaGenerada = BigDecimal.ZERO;

  private String ipAddress;
  private String userAgent;
  private String pais;

  // Audit
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;
}
