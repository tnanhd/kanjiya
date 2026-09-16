package com.tnanhd.infra.data.kanji.local;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KanjiJpaRepository extends JpaRepository<KanjiEntity, Long> {
  Optional<KanjiEntity> findByKanji(String kanji);
}
