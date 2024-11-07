package com.Meta_Keiber.SpringBoot.api.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRQ {
  @NotBlank(message = "Text question is required")
  private String text;
  @NotBlank(message = "Type question is required")
  private String type;
  private boolean active;
  @NotNull(message = "Survey id is required")
  private int survey_id;
  @NotEmpty(message = "Option Questions are required")
  private List<OptionQuestionRQ> optionQuestion;

}
