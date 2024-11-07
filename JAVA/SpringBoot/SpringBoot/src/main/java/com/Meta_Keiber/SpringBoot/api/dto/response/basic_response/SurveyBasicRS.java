package com.Meta_Keiber.SpringBoot.api.dto.response.basic_response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyBasicRS {
  private int survey_id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private boolean active;
  
}
