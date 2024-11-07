package com.Meta_Keiber.SpringBoot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionRQ {
  @NotBlank(message = "The text in the option question is required")
  private String text;
  private Boolean active;
}
