package com.tnanhd.features.kanji.find;

import com.tnanhd.application.kanji.usecases.GetKanjiByCharacterUseCase;
import com.tnanhd.application.kanji.usecases.GetPagingKanjiByJlptLevelUseCase;
import com.tnanhd.domain.common.customtypes.CustomPageable;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.features.common.CustomPageableMapper;
import com.tnanhd.features.common.PagingResponse;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindKanjiHandler {

  private final GetKanjiByCharacterUseCase getKanjiByCharacterUseCase;
  private final GetPagingKanjiByJlptLevelUseCase getPagingKanjiByJlptLevelUseCase;

  @Nonnull
  public PagingResponse<Kanji> handle(FindKanjiQuery query) {
    if (StringUtils.isNotBlank(query.kanji())) {
      return getKanjiByCharacterUseCase
          .findKanjiByCharacter(query.kanji())
          .map(PagingResponse::single)
          .orElseGet(PagingResponse::empty);
    }

    CustomPageable customPageable =
        CustomPageableMapper.mapPageableToCustomPageable(query.pageable());
    return PagingResponse.of(
        getPagingKanjiByJlptLevelUseCase.findPagingKanjiByJlptLevel(
            query.jlptLevel(), customPageable));
  }
}
