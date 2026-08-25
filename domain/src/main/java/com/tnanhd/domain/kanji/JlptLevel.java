package com.tnanhd.domain.kanji;

import jakarta.annotation.Nonnull;

public enum JlptLevel {
  N1,
  N2,
  N3,
  N4,
  N5,
  ;

  private static final String INVALID_LEVEL_MSG = "Invalid JLPT level: ";

  public static JlptLevel fromInt(int level) {
    return switch (level) {
      case 1 -> N1;
      case 2 -> N2;
      case 3 -> N3;
      case 4 -> N4;
      case 5 -> N5;
      default -> {
        throw new IllegalArgumentException(INVALID_LEVEL_MSG + level);
      }
    };
  }

  public static JlptLevel fromString(@Nonnull String level) {
    try {
      return JlptLevel.valueOf(level.toUpperCase());
    } catch (Exception _) {
      throw new IllegalArgumentException(INVALID_LEVEL_MSG + level);
    }
  }
}
