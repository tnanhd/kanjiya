package com.tnanhd.application.kanji;

import com.tnanhd.application.common.ApplicationService;
import com.tnanhd.domain.kanji.Kanji;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@ApplicationService
@RequiredArgsConstructor
public class GetKanjiByCharacterService implements GetKanjiByCharacterUseCase {

  private final KanjiRepository kanjiRepository;
  private final KanjiProvider kanjiProvider;

  @Override
  public Optional<Kanji> execute(String kanji) {
    return kanjiRepository
        .getByKanji(kanji)
        .or(() -> kanjiProvider.fetchByKanji(kanji).map(kanjiRepository::save));
  }
}
