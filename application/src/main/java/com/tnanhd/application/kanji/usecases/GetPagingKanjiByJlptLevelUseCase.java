package com.tnanhd.application.kanji.usecases;

import com.tnanhd.domain.common.customtypes.CustomPage;
import com.tnanhd.domain.common.customtypes.CustomPageable;
import com.tnanhd.domain.kanji.JlptLevel;
import com.tnanhd.domain.kanji.Kanji;

public interface GetPagingKanjiByJlptLevelUseCase {

  CustomPage<Kanji> findPagingKanjiByJlptLevel(JlptLevel jlptLevel, CustomPageable customPageable);
}
