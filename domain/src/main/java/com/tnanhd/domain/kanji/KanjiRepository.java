package com.tnanhd.domain.kanji;

import com.tnanhd.domain.common.customtypes.CustomPage;
import com.tnanhd.domain.common.customtypes.CustomPageable;

import java.util.Optional;

public interface KanjiRepository {

  Optional<Kanji> findByKanji(String kanji);

  Kanji save(Kanji kanji);

  Optional<Kanji> findById(Long id);

  CustomPage<Kanji> findPagingByJlptLevel(JlptLevel jlptLevel, CustomPageable customPageable);
}
