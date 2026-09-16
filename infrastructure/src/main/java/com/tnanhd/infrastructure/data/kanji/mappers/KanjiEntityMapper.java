package com.tnanhd.infrastructure.data.kanji.mappers;

import com.tnanhd.domain.kanji.Kanji;
import com.tnanhd.infrastructure.data.kanji.persistence.KanjiEntity;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

@Mapper
public interface KanjiEntityMapper {

  String LIST_DELIMITER = ",";

  KanjiEntityMapper INSTANCE = Mappers.getMapper(KanjiEntityMapper.class);

  @Mapping(target = "meanings", source = "meaning")
  @Mapping(target = "onyomis", source = "onyomi")
  @Mapping(target = "kunyomis", source = "kunyomi")
  Kanji mapKanjiEntityToDomainKanji(KanjiEntity kanjiEntity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "meaning", source = "meanings")
  @Mapping(target = "onyomi", source = "onyomis")
  @Mapping(target = "kunyomi", source = "kunyomis")
  KanjiEntity mapDomainKanjiToKanjiEntity(Kanji kanji);

  default List<String> stringToList(String value) {
    if (StringUtils.isBlank(value)) {
      return List.of();
    }
    return Arrays.stream(value.split(LIST_DELIMITER))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .toList();
  }

  default String listToString(List<String> values) {
    if (ObjectUtils.isEmpty(values)) {
      return null;
    }
    return String.join(LIST_DELIMITER, values);
  }
}
