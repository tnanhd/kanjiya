package com.tnanhd.infra.data.kanji.remote;

import com.tnanhd.domain.kanji.Kanji;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KanjiApiGetResponseMapper {

  KanjiApiGetResponseMapper INSTANCE = Mappers.getMapper(KanjiApiGetResponseMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(
      target = "meaning",
      expression = "java(String.join(\", \", kanjiApiGetResponse.meanings()))")
  @Mapping(
      target = "onyomi",
      expression = "java(String.join(\", \", kanjiApiGetResponse.onReadings()))")
  @Mapping(
      target = "kunyomi",
      expression = "java(String.join(\", \", kanjiApiGetResponse.kunReadings()))")
  @Mapping(
      target = "jlptLevel",
      expression =
          "java(JlptLevel.fromInt(kanjiApiGetResponse.jlpt().intValue()))") // TODO: extract
                                                                            // function, check null
  Kanji mapKanjiApiResponseToDomainKanji(KanjiApiGetResponse kanjiApiGetResponse);
}
