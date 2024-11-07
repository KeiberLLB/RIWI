package com.Meta_Keiber.SpringBoot.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Meta_Keiber.SpringBoot.api.dto.request.UserRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.UserBasicRS;
import com.Meta_Keiber.SpringBoot.infraestructure.abstract_services.IUserService;
import com.Meta_Keiber.SpringBoot.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
  @Autowired
  private IUserService userService;

  @Operation(summary = "Get All Users", description = "TEST")
  @GetMapping(path = "/get")
  public ResponseEntity<Page<UserBasicRS>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {

    if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }

    return ResponseEntity.ok(this.userService.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<UserBasicRS> get(@PathVariable int id) {
    return ResponseEntity.ok(this.userService.get(id));
  }

  @Operation(summary = "Create User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<UserBasicRS> create(@Validated @RequestBody UserRQ request) {
    return ResponseEntity.ok(this.userService.create(request));
  }

  @Operation(summary = "Update User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PutMapping(path = "/{id}")
  public ResponseEntity<UserBasicRS> update(
      @Validated @RequestBody UserRQ request,
      @PathVariable int id) {
    return ResponseEntity.ok(this.userService.update(request, id));
  }

  @Operation(summary = "Delete User", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();

  }
}