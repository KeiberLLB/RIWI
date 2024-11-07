package com.Meta_Keiber.SpringBoot.infraestructure.abstract_services;

import com.Meta_Keiber.SpringBoot.api.dto.request.QuestionRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.QuestionBasicRS;

public interface IQuestionService extends CRUDService<QuestionRQ, QuestionBasicRS, Integer> {
  public final String FIELD_BY_SORT = "type";

}
