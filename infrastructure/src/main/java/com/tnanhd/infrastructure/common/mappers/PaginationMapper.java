package com.tnanhd.infrastructure.common.mappers;

import com.tnanhd.domain.common.customtypes.CustomPage;
import com.tnanhd.domain.common.customtypes.CustomPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public final class PaginationMapper {

  private PaginationMapper() {}

  public static Pageable mapCustomPageableToPageable(CustomPageable customPageable) {
    return PageRequest.of(customPageable.getPageNumber(), customPageable.getPageSize());
  }

  public static <T> CustomPage<T> mapPageToCustomPage(Page<T> page) {
    return new CustomPage<T>() {
      @Override
      public List<T> getContent() {
        return page.getContent();
      }

      @Override
      public int getPageNumber() {
        return page.getNumber();
      }

      @Override
      public int getPageSize() {
        return page.getSize();
      }

      @Override
      public long getTotalElements() {
        return page.getTotalElements();
      }

      @Override
      public int getTotalPages() {
        return page.getTotalPages();
      }
    };
  }
}
