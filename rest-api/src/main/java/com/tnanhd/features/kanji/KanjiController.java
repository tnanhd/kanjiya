package com.tnanhd.features.kanji;

import com.tnanhd.domain.kanji.JlptLevel;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.features.common.ApiResources;
import com.tnanhd.features.common.PagingResponse;
import com.tnanhd.features.kanji.find.FindKanjiHandler;
import com.tnanhd.features.kanji.find.FindKanjiQuery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiResources.KANJI)
@RequiredArgsConstructor
public class KanjiController {

  private final FindKanjiHandler findKanjiHandler;

  @GetMapping
  public PagingResponse<Kanji> findKanji(
      @RequestParam(required = false) String kanji,
      @RequestParam(required = false, defaultValue = "N5") String jlpt,
      @PageableDefault(size = 100, sort = "id") Pageable pageable) {
    var query =
        FindKanjiQuery.builder()
            .kanji(kanji)
            .jlptLevel(JlptLevel.fromString(jlpt))
            .pageable(pageable)
            .build();
    return findKanjiHandler
        .handle(query)
        .withExtra("jlptLevel", StringUtils.isNotBlank(kanji) ? null : jlpt)
        .withExtra("kanji", kanji);
  }
}
