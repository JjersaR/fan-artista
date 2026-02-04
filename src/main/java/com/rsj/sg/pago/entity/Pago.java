package com.rsj.sg.pago.entity;

import java.math.BigDecimal;
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
@Table(name = "pagos", indexes = {
    @Index(name = "idx_pago_estado_fecha", columnList = "estado,fechaTransaccion"),
    @Index(name = "idx_pago_tipo_fecha", columnList = "tipo,fechaTransaccion")
})
@EntityListeners(AuditingEntityListener.class)
public class Pago {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String idempotencyKey;

  @Column(nullable = false)
  private String referenciaExterna; // ID de Stripe/PayPal

  @Column(nullable = false)
  private UUID usuarioId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoTransaccion tipo; // SUSCRIPCION, COMPRA_MERCH, RETIRO_ARTISTA, PAGO_REGLALIAS

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EDireccionPago direccion; // IN, OUT

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EEstadoTransaccion estado = EEstadoTransaccion.PENDIENTE;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EMetodoPago metodo; // STRIPE, PAYPAL, TRANSFERENCIA

  @Column(precision = 19, scale = 4, nullable = false)
  private BigDecimal monto;

  private String moneda = "MXN";

  @Column(nullable = false)
  private LocalDateTime fechaTransaccion; // momento

  private LocalDateTime fechaCompletado; // estado final

  private String descripcion;

  @Column(columnDefinition = "jsonb")
  private String metadata; // JSON con detalles adicionales

  // Para retiros de artistas
  @Column(nullable = false)
  private UUID artistaId;

  private UUID pedidoId;

  // Para tracking de comisiones
  @Column(precision = 19, scale = 4)
  private BigDecimal comisionPlataforma = BigDecimal.ZERO;

  @Column(precision = 19, scale = 4)
  private BigDecimal montoNetoArtista = BigDecimal.ZERO;

  @CreatedDate
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
