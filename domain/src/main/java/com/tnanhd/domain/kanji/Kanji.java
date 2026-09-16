package com.tnanhd.domain.kanji;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Kanji {
  private Long id;
  private String kanji;
  private List<String> meanings;
  private List<String> onyomis;
  private List<String> kunyomis;
  private JlptLevel jlptLevel;
  private String unicode;
}
