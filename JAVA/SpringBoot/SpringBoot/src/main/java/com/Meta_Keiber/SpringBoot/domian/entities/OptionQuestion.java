package com.Meta_Keiber.SpringBoot.domian.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "optionquestion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int option_id;
  @Lob
  @Column(nullable = false)
  private String text;
  @Column(nullable = false)
  private boolean active;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne
  @JoinColumn(name = "question_id", referencedColumnName = "question_id")
  private Question question;
}
