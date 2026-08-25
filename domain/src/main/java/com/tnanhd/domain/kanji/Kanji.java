package com.tnanhd.domain.kanji;

import java.util.List;

public record Kanji(
    Long id,
    String kanji,
    List<String> meanings,
    List<String> onyomis,
    List<String> kunyomis,
    JlptLevel level) {}
