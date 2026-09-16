package com.tnanhd.application.kanji.usecases;

import com.tnanhd.domain.kanji.Kanji;

import java.util.Optional;

/**
 * Use cases serve as the port in. Controllers pull use cases and use.
 */
public interface GetKanjiByCharacterUseCase {

  Optional<Kanji> findKanjiByCharacter(String kanji);
}
