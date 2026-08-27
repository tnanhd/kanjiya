package com.tnanhd.infra.data.kanji;

import com.tnanhd.application.kanji.KanjiRepository;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.infra.data.kanji.local.KanjiEntityMapper;
import com.tnanhd.infra.data.kanji.local.KanjiJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class KanjiRepositoryImpl implements KanjiRepository {

  private final KanjiJpaRepository kanjiJpaRepository;

  @Override
  public Optional<Kanji> getByKanji(String kanji) {
    return kanjiJpaRepository
        .findByKanji(kanji)
        .map(KanjiEntityMapper.INSTANCE::mapKanjiEntityToDomainKanji);
  }

  @Override
  public Kanji save(Kanji kanji) {
    var entity = KanjiEntityMapper.INSTANCE.mapDomainKanjiToKanjiEntity(kanji);
    var saved = kanjiJpaRepository.save(entity);
    return KanjiEntityMapper.INSTANCE.mapKanjiEntityToDomainKanji(saved);
  }

  @Override
  public Optional<Kanji> getById(Long id) {
    return kanjiJpaRepository
        .findById(id)
        .map(KanjiEntityMapper.INSTANCE::mapKanjiEntityToDomainKanji);
  }
}
