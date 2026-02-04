package com.rsj.sg.regalia.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "regalias", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "artistaId", "anio", "mes" })
}, indexes = {
    @Index(name = "idx_reporte_estado", columnList = "estado"),
    @Index(name = "idx_reporte_periodo", columnList = "anio,mes")
})
@EntityListeners(AuditingEntityListener.class)
public class Regalia {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private UUID artistaId;

  @Column(nullable = false)
  private Integer mes; // se deriva del periodo

  @Column(nullable = false)
  private Integer anio; // se deriva del periodo

  @Column(nullable = false)
  private LocalDateTime fechaGeneracion;

  @Column(nullable = false)
  private LocalDate periodoInicio;

  @Column(nullable = false)
  private LocalDate periodoFin;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EEstadoReporte estado = EEstadoReporte.PENDIENTE;

  // Totales
  @Column(precision = 19, scale = 4)
  private BigDecimal totalGanancias = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasStreams = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasAnuncios = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal gananciasMerch = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal comisionPlataforma = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal netoPagable = BigDecimal.ZERO;

  // Estadísticas
  private Long totalStreams = 0L;
  private Long totalStreamsPremium = 0L;
  private Long totalStreamsAds = 0L;
  private Long totalImpresionesAnuncios = 0L;
  private Integer totalVentasMerch = 0;

  @Column(columnDefinition = "jsonb")
  private String detallePorCancion; // JSON con breakdown

  private LocalDateTime fechaPago; // referencia a pago

  private UUID pagoId;

  @Column(nullable = false)
  private String archivoReporteUrl; // PDF del reporte

  // Audit
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
