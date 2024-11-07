package com.Meta_Keiber.SpringBoot.infraestructure.abstract_services;

import com.Meta_Keiber.SpringBoot.api.dto.request.OptionQuestionRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.OptionQuestionBasicRS;

public interface IOptionQuestion extends CRUDService<OptionQuestionRQ, OptionQuestionBasicRS, Integer> {
  public final String FIELD_BY_SORT = "text";

}
