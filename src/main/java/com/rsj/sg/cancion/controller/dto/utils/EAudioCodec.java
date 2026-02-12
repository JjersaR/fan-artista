package com.rsj.sg.cancion.controller.dto.utils;

public enum EAudioCodec {
  MP3("mp3"),
  AAC("aac"),
  FLAC("flac"),
  WAV("wav");

  private final String value;

  EAudioCodec(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
