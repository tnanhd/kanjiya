package com.tnanhd.infra.data.kanji.local;

import com.tnanhd.domain.kanji.Kanji;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KanjiEntityMapper {

  KanjiEntityMapper INSTANCE = Mappers.getMapper(KanjiEntityMapper.class);

  Kanji mapKanjiEntityToDomainKanji(KanjiEntity kanjiEntity);

  KanjiEntity mapDomainKanjiToKanjiEntity(Kanji kanji);
}
