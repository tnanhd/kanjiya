package com.tnanhd.infra.data.kanji;

import com.tnanhd.infra.data.kanji.remote.KanjiApiFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class KanjiProviderImpl {

  private final KanjiApiFeignClient kanjiApiFeignClient;
}
