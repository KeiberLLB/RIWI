package com.gestionBiblioteca.gestionB.infrastructure.abstract_services;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsBookResponse;

public interface IBookService extends CRUD<BookRQ, RelationsBookResponse, Long>{
  public final String FIELD_BY_SORT = "title";
}
