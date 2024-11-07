package com.Meta_Keiber.SpringBoot.api.dto.response.basic_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionBasicRS {
  private int option_id;
  private String text;
  private boolean active;
}
