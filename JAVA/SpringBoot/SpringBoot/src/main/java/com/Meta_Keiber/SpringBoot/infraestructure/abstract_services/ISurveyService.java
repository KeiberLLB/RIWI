package com.Meta_Keiber.SpringBoot.infraestructure.abstract_services;

import com.Meta_Keiber.SpringBoot.api.dto.request.SurveyRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.SurveyBasicRS;

public interface ISurveyService extends CRUDService<SurveyRQ, SurveyBasicRS, Integer> {
  public final String FIELD_BY_SORT = "title";
}
