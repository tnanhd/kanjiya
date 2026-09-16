package com.tnanhd.infrastructure.data.kanji.persistence;

import com.tnanhd.domain.common.customtypes.CustomPage;
import com.tnanhd.domain.common.customtypes.CustomPageable;
import com.tnanhd.domain.kanji.JlptLevel;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.domain.kanji.KanjiRepository;
import com.tnanhd.infrastructure.common.mappers.PaginationMapper;
import com.tnanhd.infrastructure.data.kanji.mappers.KanjiEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class KanjiRepositoryImpl implements KanjiRepository {

  private final KanjiJpaRepository kanjiJpaRepository;

  @Override
  public Optional<Kanji> findByKanji(String kanji) {
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
  public Optional<Kanji> findById(Long id) {
    return kanjiJpaRepository
        .findById(id)
        .map(KanjiEntityMapper.INSTANCE::mapKanjiEntityToDomainKanji);
  }

  @Override
  public CustomPage<Kanji> findPagingByJlptLevel(
      JlptLevel jlptLevel, CustomPageable customPageable) {
    Pageable pageable = PaginationMapper.mapCustomPageableToPageable(customPageable);
    Page<KanjiEntity> result = kanjiJpaRepository.findByJlptLevel(jlptLevel, pageable);
    List<Kanji> resultContent =
        result.getContent().stream()
            .map(KanjiEntityMapper.INSTANCE::mapKanjiEntityToDomainKanji)
            .toList();
    return PaginationMapper.mapPageToCustomPage(
        new PageImpl<>(resultContent, pageable, result.getTotalElements()));
  }
}
