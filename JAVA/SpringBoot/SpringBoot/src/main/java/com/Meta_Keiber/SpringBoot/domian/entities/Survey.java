package com.Meta_Keiber.SpringBoot.domian.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "survey")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int survey_id;
  @Column(length = 255, nullable = false)
  private String title;
  @Lob
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  @Builder.Default
  private LocalDateTime creationDate = LocalDateTime.now();
  @Column(nullable = false)
  private boolean active;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "creator_id", referencedColumnName = "user_id")
  private Users creator;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "survey", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  private List<Question> question;
}
