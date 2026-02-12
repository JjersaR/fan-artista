package com.rsj.sg.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
  private int status;
  private String error; // Nombre corto del error
  private String message; // Mensaje principal
  private String path; // Endpoint donde ocurrió
  private String timestamp = LocalDateTime.now().toString();

  public ErrorResponse(HttpStatus status, String error, String message, String path) {
    this.status = status.value();
    this.error = error;
    this.message = message;
    this.path = path;
  }
}
