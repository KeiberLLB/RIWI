package com.Meta_Keiber.SpringBoot.api.dto.response;

import java.util.List;

import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.SurveyBasicRS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRS extends SurveyBasicRS {
  private List<QuestionRS> question;
  
}
