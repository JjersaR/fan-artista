package com.rsj.sg.cancion.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsj.sg.cancion.controller.dto.AudioObjectNameBuilder;
import com.rsj.sg.cancion.controller.dto.StoredFile;
import com.rsj.sg.cancion.controller.dto.utils.EAudioCodec;
import com.rsj.sg.cancion.service.IStorageService;
import com.rsj.sg.error.exceptions.DeleteException;
import com.rsj.sg.error.exceptions.DownloadException;
import com.rsj.sg.error.exceptions.ListException;
import com.rsj.sg.error.exceptions.UploadException;

import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.Result;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioStorageServiceImpl implements IStorageService {

  private final MinioClient client;
  private final AudioObjectNameBuilder builder;

  @Override
  public StoredFile upload(String artistaId, String cancionId, int version, EAudioCodec codec, int bitrate,
      MultipartFile file) {
    try {
      // 1. obtener la extension del archivo
      String extension = FilenameUtils.getExtension(file.getOriginalFilename());

      // 2. Construir path
      String objectName = builder.build(artistaId, cancionId, version, codec, bitrate, extension);

      // 3. guardarlo en Minio
      client.putObject(PutObjectArgs.builder().bucket("audio").object(objectName)
          .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build());

      return new StoredFile(
          "audio",
          objectName,
          file.getSize(),
          file.getContentType());
    } catch (Exception e) {
      throw new UploadException("Error al subir el archivo");
    }
  }

  private List<StoredFile> list(String bucket, String prefix) {
    try {
      var files = new ArrayList<StoredFile>();
      var results = client.listObjects(ListObjectsArgs.builder().bucket(bucket).prefix(prefix).recursive(true).build());

      for (Result<Item> result : results) {
        var item = result.get();
        files.add(new StoredFile(bucket, item.objectName(), item.size(), null));
      }

      return files;
    } catch (Exception e) {
      throw new ListException("Error listando archivos");
    }

  }

  @Override
  public List<StoredFile> listByArtista(String bucket, String artistaId) {
    return list(bucket, "artistas/" + artistaId + "/");
  }

  @Override
  public List<StoredFile> listByCancion(String bucket, String artistaId, String cancionId) {
    return list(bucket, "artistas/" + artistaId + "/canciones/" + cancionId + "/");
  }

  @Override
  public InputStream download(String bucket, String objectName) {
    try {
      return client.getObject(GetObjectArgs.builder().bucket(bucket).object(objectName).build());
    } catch (Exception e) {
      throw new DownloadException("Error descargando archivo");
    }
  }

  @Override
  public void delete(String bucket, String objectName) {
    try {
      client.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectName).build());
    } catch (Exception e) {
      throw new DeleteException("Error borrando archivo");
    }
  }
}
