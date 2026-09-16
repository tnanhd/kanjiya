package com.tnanhd.application.kanji.service;

import com.tnanhd.application.common.ApplicationService;
import com.tnanhd.application.kanji.usecases.GetKanjiByCharacterUseCase;
import com.tnanhd.application.kanji.usecases.GetPagingKanjiByJlptLevelUseCase;
import com.tnanhd.domain.common.customtypes.CustomPage;
import com.tnanhd.domain.common.customtypes.CustomPageable;
import com.tnanhd.domain.kanji.JlptLevel;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.application.kanji.ports.KanjiProvider;
import com.tnanhd.domain.kanji.KanjiRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@ApplicationService
@RequiredArgsConstructor
public class KanjiService implements GetKanjiByCharacterUseCase, GetPagingKanjiByJlptLevelUseCase {

  private final KanjiRepository kanjiRepository;
  private final KanjiProvider kanjiProvider;

  @Override
  public Optional<Kanji> findKanjiByCharacter(String kanji) {
    return kanjiRepository
        .findByKanji(kanji)
        .or(() -> kanjiProvider.fetchByKanji(kanji).map((kanjiRepository::save)));
  }

  @Override
  public CustomPage<Kanji> findPagingKanjiByJlptLevel(
      JlptLevel jlptLevel, CustomPageable customPageable) {
    return kanjiRepository.findPagingByJlptLevel(jlptLevel, customPageable);
  }
}
