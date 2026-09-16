package com.tnanhd.application.kanji.ports;

import com.tnanhd.domain.kanji.Kanji;

import java.util.Optional;

public interface KanjiProvider {

  Optional<Kanji> fetchByKanji(String kanji);
}
