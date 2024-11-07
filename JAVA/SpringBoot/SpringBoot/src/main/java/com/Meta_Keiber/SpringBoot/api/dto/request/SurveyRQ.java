package com.Meta_Keiber.SpringBoot.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRQ {

  @Size(min = 0, max = 255, message ="Title exceeds the number of characters allowed")
  @NotBlank(message = "Survey title is required")
  private String title;
  @NotBlank(message = "Survey description is required")
  private String description;
  private boolean active;
  @NotNull(message = "Creator id is required")
  private int creator_id;
}
