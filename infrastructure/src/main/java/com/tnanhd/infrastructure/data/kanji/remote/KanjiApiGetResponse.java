package com.tnanhd.infrastructure.data.kanji.remote;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record KanjiApiGetResponse(
    Long jlpt,
    String kanji,
    List<String> meanings,
    @JsonProperty("on_readings") List<String> onReadings,
    @JsonProperty("kun_readings") List<String> kunReadings,
    @JsonProperty("stroke_count") Long strokeCount,
    String unicode) {}
