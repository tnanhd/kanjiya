package com.tnanhd.infrastructure.data.kanji.persistence;

import com.tnanhd.domain.kanji.JlptLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KanjiJpaRepository extends JpaRepository<KanjiEntity, Long> {
  Optional<KanjiEntity> findByKanji(String kanji);

  Page<KanjiEntity> findByJlptLevel(JlptLevel jlptLevel, Pageable pageable);
}
