package com.Meta_Keiber.SpringBoot.infraestructure.abstract_services;

import com.Meta_Keiber.SpringBoot.api.dto.request.UserRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.UserBasicRS;

public interface IUserService extends CRUDService<UserRQ, UserBasicRS, Integer> {
  public final String FIELD_BY_SORT = "name";

}
