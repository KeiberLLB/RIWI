package com.gestionBiblioteca.gestionB.api.controllers;

import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;
import com.gestionBiblioteca.gestionB.infrastructure.abstract_services.IReservationService;
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
@RequestMapping(path = "reservation")
@AllArgsConstructor
public class ReservationController {

  @Autowired
  private IReservationService reservationService;

  @Operation(summary = "Create Reservation", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<RelationsReservationResponse> create(
      @Validated @RequestBody ReservationRQ reservationRQ) {
    return ResponseEntity.ok(reservationService.create(reservationRQ));
  }

  @Operation(summary = "Get All Reservation", description = "TEST")
  @GetMapping
  public ResponseEntity<Page<RelationsReservationResponse>> getAll(
      @Validated @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestHeader(required = false) SortType sortType) {
    if (Objects.isNull(sortType))
      sortType = SortType.NONE;
    return ResponseEntity.ok(reservationService.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get Reservation", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/{id}")
  public ResponseEntity<RelationsReservationResponse> getById(
      @Validated @PathVariable Long id) {
    return ResponseEntity.ok(this.reservationService.get(id));
  }

  @Operation(summary = "Update Reservation", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<RelationsReservationResponse> update(
      @Validated @PathVariable Long id,
      @RequestBody ReservationRQ reservationRQ) {
    return ResponseEntity.ok(reservationService.update(reservationRQ, id));
  }

  @Operation(summary = "Delete Reservation", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping("/{id}")
  public ResponseEntity<RelationsReservationResponse> delete(
      @Validated @PathVariable Long id) {
    this.reservationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}