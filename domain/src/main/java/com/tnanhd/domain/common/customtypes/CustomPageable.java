package com.tnanhd.domain.common.customtypes;

public interface CustomPageable {
  int getPageNumber();

  int getPageSize();

  long getOffset();
}
