package com.rsj.sg.cancion.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoredFile {
  private String bucket;
  private String objectName;
  private long size;
  private String contentType;
}
