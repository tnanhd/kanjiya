package com.tnanhd.features.kanji.find;

import com.tnanhd.domain.kanji.JlptLevel;
import lombok.Builder;
import org.springframework.data.domain.Pageable;

@Builder
public record FindKanjiQuery(String kanji, JlptLevel jlptLevel, Pageable pageable) {}
