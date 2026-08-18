package com.tnanhd.kanjilibrary.features.kanjilibrary.add;

import com.tnanhd.kanjilibrary.features.shared.ResourceConstant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ResourceConstant.KANJI_LIBRARY)
@RequiredArgsConstructor
@Validated
public class AddKanjiController {

  @PostMapping
  public ResponseEntity<Void> addKanji(@Valid @RequestBody AddKanjiCommand addKanjiCommand) {
    return ResponseEntity.ok().build();
  }
}
