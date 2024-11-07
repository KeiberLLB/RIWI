package com.gestionBiblioteca.gestionB.api.controllers;

import com.gestionBiblioteca.gestionB.api.dto.request.UserRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.infrastructure.abstract_services.IUserService;
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
@RequestMapping(path = "user")
@AllArgsConstructor
public class UserController {

  @Autowired
  private final IUserService userService;

  @Operation(summary = "Create User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<UserResponse> create(
      @Validated @RequestBody UserRQ userRQ) {
    return ResponseEntity.ok(this.userService.create(userRQ));
  }

  @Operation(summary = "Get All Users", description = "TEST")
  @GetMapping
  public ResponseEntity<Page<UserResponse>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestHeader(required = false) SortType sortType) {
    if (Objects.isNull(sortType))
      sortType = SortType.NONE;
    return ResponseEntity.ok(this.userService.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/{id}")
  public ResponseEntity<UserResponse> getById(
      @Validated @PathVariable Long id) {
    return ResponseEntity.ok(this.userService.get(id));
  }

  @Operation(summary = "Update User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping(path = "/{id}")
  public ResponseEntity<UserResponse> update(
      @Validated @PathVariable Long id,
      @RequestBody UserRQ userRQ) {
    return ResponseEntity.ok(this.userService.update(userRQ, id));
  }

  @Operation(summary = "Delete User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<UserResponse> delete(
      @PathVariable Long id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}