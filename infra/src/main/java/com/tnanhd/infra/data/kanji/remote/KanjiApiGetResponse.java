package com.tnanhd.infra.data.kanji.remote;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonNaming;

import java.util.List;

public record KanjiApiGetResponse(
    Long jlpt,
    String kanji,
    List<String> meanings,
    @JsonProperty("on_readings") List<String> onReadings,
    @JsonProperty("kun_readings") List<String> kunReadings,
    @JsonProperty("stroke_count") Long strokeCount,
    String unicode) {}
