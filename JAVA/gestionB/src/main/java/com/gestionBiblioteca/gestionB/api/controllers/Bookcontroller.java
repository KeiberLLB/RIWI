package com.gestionBiblioteca.gestionB.api.controllers;

import com.gestionBiblioteca.gestionB.api.dto.request.BookRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsBookResponse;
import com.gestionBiblioteca.gestionB.infrastructure.abstract_services.IBookService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "book")
@AllArgsConstructor
public class Bookcontroller {

  @Autowired
  private IBookService bookSerivice;

  @Operation(summary = "Create Books", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<RelationsBookResponse> create(
      @Validated @RequestBody BookRQ bookRQ) {

    return ResponseEntity.ok(bookSerivice.create(bookRQ));
  }

  @Operation(summary = "Get All Books", description = "TEST")
  @GetMapping
  public ResponseEntity<Page<RelationsBookResponse>> getAll(
      @Validated @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestHeader(required = false) SortType sortType) {
    if (Objects.isNull(sortType))
      sortType = SortType.NONE;

    return ResponseEntity.ok(bookSerivice.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get Book", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/{id}")
  public ResponseEntity<RelationsBookResponse> getById(
      @Validated @PathVariable Long id) {

    return ResponseEntity.ok(this.bookSerivice.get(id));
  }

  @Operation(summary = "Update Book", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping(path = "/{id}")
  public ResponseEntity<RelationsBookResponse> update(
      @PathVariable Long id,
      @Validated @RequestBody BookRQ bookRQ) {

    return ResponseEntity.ok(this.bookSerivice.update(bookRQ, id));
  }

  @Operation(summary = "Delete Book", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<RelationsBookResponse> delete(
      @Validated @PathVariable Long id) {
    this.bookSerivice.delete(id);
    return ResponseEntity.noContent().build();
  }

}