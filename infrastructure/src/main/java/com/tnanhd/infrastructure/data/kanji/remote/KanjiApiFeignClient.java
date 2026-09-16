package com.tnanhd.infrastructure.data.kanji.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "kanji-api-client", url = "https://kanjiapi.dev", dismiss404 = true)
public interface KanjiApiFeignClient {

  @GetMapping("/v1/kanji/{kanji}")
  Optional<KanjiApiGetResponse> fetchKanjiByCharacter(@PathVariable String kanji);
}
