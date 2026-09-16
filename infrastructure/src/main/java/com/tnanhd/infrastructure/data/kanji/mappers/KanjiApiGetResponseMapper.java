package com.tnanhd.infrastructure.data.kanji.mappers;

import com.tnanhd.domain.kanji.JlptLevel;
import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.infrastructure.data.kanji.remote.KanjiApiGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KanjiApiGetResponseMapper {

  KanjiApiGetResponseMapper INSTANCE = Mappers.getMapper(KanjiApiGetResponseMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "onyomis", source = "onReadings")
  @Mapping(target = "kunyomis", source = "kunReadings")
  @Mapping(target = "jlptLevel", source = "kanjiApiGetResponse", qualifiedByName = "mapJlptLevel")
  Kanji mapKanjiApiResponseToDomainKanji(KanjiApiGetResponse kanjiApiGetResponse);

  @Named("mapJlptLevel")
  default JlptLevel mapJlptLevel(KanjiApiGetResponse kanjiApiGetResponse) {
    if (kanjiApiGetResponse == null || kanjiApiGetResponse.jlpt() == null) {
      return null;
    }
    return JlptLevel.fromInt(kanjiApiGetResponse.jlpt().intValue());
  }
}
