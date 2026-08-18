package com.tnanhd.kanjilibrary.features.kanjilibrary.add;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AddKanjiCommand(@NotBlank(message = "character is required") String character) {}
