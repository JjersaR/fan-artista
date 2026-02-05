package com.rsj.sg.usu.entity;

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
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String nombre;

  private String apellido;

  @Column(unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(name = "is_enabled")
  private boolean isEnabled = true;

  @Column(name = "account_no_expired")
  private boolean accountNoExpired = true;

  @Column(name = "account_no_locked")
  private boolean accountNoLocked = true;

  @Column(name = "credential_no_expired")
  private boolean credentialNoExpired = true;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ETipoUsuario tipoUsuario; // LISTENER, ARTISTA, ADMIN

  private String pais;
  private String idioma;

  private LocalDateTime ultimoLogin;

  private String fotoPerfilUrl;

  // Audit fields
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime creadoEn;

  @LastModifiedDate
  private LocalDateTime modificadoEn;
}
