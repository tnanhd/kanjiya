package com.tnanhd.domain.common.customtypes;

import java.util.List;

public interface CustomPage<T> {
  List<T> getContent();

  int getPageNumber();

  int getPageSize();

  long getTotalElements();

  int getTotalPages();
}
