package com.tnanhd.features.common;

import com.tnanhd.domain.common.customtypes.CustomPage;
import jakarta.annotation.Nonnull;
import lombok.Builder;

import java.util.*;

@Builder
public record PagingResponse<T>(
    Collection<T> content, PageInfo pageInfo, Map<String, Object> extras) {

  @Builder
  public record PageInfo(
      Integer pageNumber, Integer pageSize, Long totalElements, Integer totalPages) {
    public static PageInfo empty() {
      return PageInfo.builder().totalElements(0L).build();
    }

    public static PageInfo single() {
      return PageInfo.builder().totalElements(1L).totalPages(1).pageNumber(0).pageSize(1).build();
    }
  }

  public static <T> PagingResponse<T> empty() {
    return new PagingResponse<>(Collections.emptyList(), PageInfo.empty(), null);
  }

  public static <T> PagingResponse<T> of(CustomPage<T> page) {
    return new PagingResponse<>(
        page.getContent(),
        PageInfo.builder()
            .pageNumber(page.getPageNumber())
            .pageSize(page.getPageSize())
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .build(),
        null);
  }

  public static <T> PagingResponse<T> single(T content) {
    return new PagingResponse<>(List.of(content), PageInfo.single(), null);
  }

  public PagingResponse<T> withExtra(@Nonnull String key, Object value) {
    Map<String, Object> extrasMap = new HashMap<>();
    if (extras == null) {
      extrasMap.put(key, value);
      return new PagingResponse<>(content, pageInfo, extrasMap);
    }

    extrasMap = new HashMap<>(extras);
    extrasMap.put(key, value);
    return new PagingResponse<>(content, pageInfo, extrasMap);
  }
}
