package com.tnanhd.application.kanji;

import com.tnanhd.domain.kanji.Kanji;

import java.util.Optional;

/**
 * Use cases serve as the port out. Infra will implement and inject to services (apply Dependency Inversion).
 */
public interface KanjiRepository {
  Optional<Kanji> findByCharacter(String kanji);

  Kanji save(Kanji kanji);

  Optional<Kanji> findById(Long id);
}
