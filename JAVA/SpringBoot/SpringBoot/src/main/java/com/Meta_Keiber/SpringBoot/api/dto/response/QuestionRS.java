package com.Meta_Keiber.SpringBoot.api.dto.response;

import java.util.List;

import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.OptionQuestionBasicRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.QuestionBasicRS;

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
public class QuestionRS extends QuestionBasicRS{
  private List<OptionQuestionBasicRS> optionQuestion;
}
