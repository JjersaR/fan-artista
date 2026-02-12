package com.rsj.sg.cancion.controller.dto;

import org.springframework.stereotype.Component;

import com.rsj.sg.cancion.controller.dto.utils.EAudioCodec;

@Component
public class AudioObjectNameBuilder {

  private AudioObjectNameBuilder() {
  }

  public String build(
      String artistaId,
      String cancionId,
      int version,
      EAudioCodec codec,
      int bitrate,
      String extension) {

    validate(version, bitrate, extension);

    return String.format(
        "artistas/%s/canciones/%s/v%d/%s_%d.%s",
        artistaId,
        cancionId,
        version,
        codec.getValue(),
        bitrate,
        extension.toLowerCase());
  }

  private void validate(
      int version,
      int bitrate,
      String extension) {

    if (version <= 0) {
      throw new IllegalArgumentException("La versión debe ser mayor a 0");
    }

    if (bitrate <= 0) {
      throw new IllegalArgumentException("Bitrate inválido");
    }

    if (extension == null || extension.isBlank()) {
      throw new IllegalArgumentException("Extensión requerida");
    }
  }
}
