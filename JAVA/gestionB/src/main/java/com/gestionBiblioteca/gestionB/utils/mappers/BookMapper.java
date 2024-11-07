package com.gestionBiblioteca.gestionB.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsBookResponse;
import com.gestionBiblioteca.gestionB.domain.entities.BookEntity;

@Mapper(componentModel = "spring", uses = { ReservationMapper.class, LoanMapper.class })
public interface BookMapper {

  @Mapping(target = "id", ignore = true)
  BookEntity bookToBookEntity(BookRQ book);
  RelationsBookResponse toRelationsBookResponse(BookEntity bookEntity);
  void updateBook(BookRQ bookRequest, @MappingTarget BookEntity bookEntity);
}
