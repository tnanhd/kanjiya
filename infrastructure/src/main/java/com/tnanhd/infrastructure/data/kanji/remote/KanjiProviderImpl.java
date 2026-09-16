package com.tnanhd.infrastructure.data.kanji.remote;

import com.tnanhd.application.kanji.ports.KanjiProvider;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.infrastructure.data.kanji.mappers.KanjiApiGetResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class KanjiProviderImpl implements KanjiProvider {

  private final KanjiApiFeignClient kanjiApiFeignClient;

  @Override
  public Optional<Kanji> fetchByKanji(String kanji) {
    return kanjiApiFeignClient
        .fetchKanjiByCharacter(kanji)
        .map(KanjiApiGetResponseMapper.INSTANCE::mapKanjiApiResponseToDomainKanji);
  }
}
