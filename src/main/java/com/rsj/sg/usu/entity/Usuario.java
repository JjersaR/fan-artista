package com.rsj.sg.usu.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  private String tempPassword;

  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(name = "is_enabled")
  private boolean isEnabled;

  @Column(name = "account_no_expired")
  private boolean accountNoExpired;

  @Column(name = "account_no_locked")
  private boolean accountNoLocked;

  @Column(name = "credential_no_expired")
  private boolean credentialNoExpired;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_usuario", nullable = false)
  private ETipoUsuario tipoUsuario = ETipoUsuario.LISTENER; // LISTENER, ARTISTA, ADMIN

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_suscripcion")
  private ETipoSuscripcion tipoSuscripcion = ETipoSuscripcion.FREE;

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

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public boolean isAccountNoExpired() {
    return accountNoExpired;
  }

  public void setAccountNoExpired(boolean accountNoExpired) {
    this.accountNoExpired = accountNoExpired;
  }

  public boolean isAccountNoLocked() {
    return accountNoLocked;
  }

  public void setAccountNoLocked(boolean accountNoLocked) {
    this.accountNoLocked = accountNoLocked;
  }

  public boolean isCredentialNoExpired() {
    return credentialNoExpired;
  }

  public void setCredentialNoExpired(boolean credentialNoExpired) {
    this.credentialNoExpired = credentialNoExpired;
  }
}
