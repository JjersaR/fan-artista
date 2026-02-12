package com.rsj.sg.cancion.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rsj.sg.cancion.controller.dto.StoredFile;
import com.rsj.sg.cancion.controller.dto.utils.EAudioCodec;

public interface IStorageService {
  StoredFile upload(String artistaId,
      String cancionId,
      int version,
      EAudioCodec codec,
      int bitrate,
      MultipartFile file);

  List<StoredFile> listByArtista(String bucket, String artistaId);

  List<StoredFile> listByCancion(String bucket, String artistaId, String cancionId);

  InputStream download(String bucket, String objectName);

  void delete(String bucket, String objectName);
}
