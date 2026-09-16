package com.tnanhd.infrastructure.data.kanji.persistence;

import com.tnanhd.domain.kanji.JlptLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kanji")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KanjiEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "kanji", nullable = false)
  private String kanji;

  @Column(name = "meaning", nullable = false)
  private String meaning;

  @Column(name = "onyomi")
  private String onyomi;

  @Column(name = "kunyomi")
  private String kunyomi;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "jlpt_level", nullable = false)
  private JlptLevel jlptLevel;
}
