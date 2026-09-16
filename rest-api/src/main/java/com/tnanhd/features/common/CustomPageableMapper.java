package com.tnanhd.features.common;

import com.tnanhd.domain.common.customtypes.CustomPageable;
import org.springframework.data.domain.Pageable;

public final class CustomPageableMapper {
  private CustomPageableMapper() {}

  public static CustomPageable mapPageableToCustomPageable(Pageable pageable) {
    return new CustomPageable() {
      @Override
      public int getPageNumber() {
        return pageable.getPageNumber();
      }

      @Override
      public int getPageSize() {
        return pageable.getPageSize();
      }

      @Override
      public long getOffset() {
        return pageable.getOffset();
      }
    };
  }
}
