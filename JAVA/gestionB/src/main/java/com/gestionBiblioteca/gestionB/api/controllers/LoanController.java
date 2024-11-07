package com.gestionBiblioteca.gestionB.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import com.gestionBiblioteca.gestionB.api.dto.request.LoanRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.LoanResponse;
import com.gestionBiblioteca.gestionB.infrastructure.abstract_services.ILoanService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "loan")
@AllArgsConstructor
public class LoanController {

  @Autowired
  private final ILoanService loanService;

  @Operation(summary = "Create Loan", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<LoanResponse> create(
      @Validated @RequestBody LoanRQ loanRQ) {
    return ResponseEntity.ok(loanService.create(loanRQ));
  }

  @Operation(summary = "Get All Loan", description = "TEST")
  @GetMapping
  public ResponseEntity<Page<LoanResponse>> getAll(
      @Validated @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestHeader(required = false) SortType sortType) {
    System.out.println(sortType);
    if (Objects.isNull(sortType))
      sortType = SortType.NONE;
    return ResponseEntity.ok(loanService.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get Loan", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/{id}")
  public ResponseEntity<LoanResponse> getById(
      @Validated @PathVariable Long id) {
    return ResponseEntity.ok(this.loanService.get(id));
  }

  @Operation(summary = "Update Loan", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping(path = "/{id}")
  public ResponseEntity<LoanResponse> update(
      @Validated @PathVariable Long id,
      @RequestBody LoanRQ loanRQ) {
    return ResponseEntity.ok(this.loanService.update(loanRQ, id));
  }

  @Operation(summary = "Delete Loan", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<LoanResponse> delete(
      @Validated @PathVariable Long id) {
    this.loanService.delete(id);
    return ResponseEntity.noContent().build();
  }
}