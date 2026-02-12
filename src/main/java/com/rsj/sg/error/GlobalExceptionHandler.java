package com.rsj.sg.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rsj.sg.error.exceptions.DeleteException;
import com.rsj.sg.error.exceptions.DownloadException;
import com.rsj.sg.error.exceptions.ListException;
import com.rsj.sg.error.exceptions.UploadException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Error al subir archivo
  @ExceptionHandler(UploadException.class)
  public ResponseEntity<ErrorResponse> handleUploadException(UploadException e, HttpServletRequest request) {
    var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "UploadException", e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  // Error al listar archivos
  @ExceptionHandler(ListException.class)
  public ResponseEntity<ErrorResponse> handleListExcepcion(ListException e, HttpServletRequest request) {
    var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "ListException", e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  // Error al descargar archivo
  @ExceptionHandler(DownloadException.class)
  public ResponseEntity<ErrorResponse> handleDownloadException(DownloadException e, HttpServletRequest request) {
    var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "DownloadException", e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  // Error al borrar archivo
  @ExceptionHandler(DeleteException.class)
  public ResponseEntity<ErrorResponse> handleDeleteException(DeleteException e, HttpServletRequest request) {
    var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "DeleteException", e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
