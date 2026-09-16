package com.tnanhd.features.common;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public final class UriUtils {
  private UriUtils() {}

  public static URI buildResourceUri(String resourcePath, Long id) {
    return buildResourceUri(resourcePath, String.valueOf(id));
  }

  public static URI buildResourceUri(String resourcePath, String id) {
    return ServletUriComponentsBuilder.fromCurrentContextPath()
        .path(resourcePath)
        .pathSegment(id)
        .build()
        .toUri();
  }
}
