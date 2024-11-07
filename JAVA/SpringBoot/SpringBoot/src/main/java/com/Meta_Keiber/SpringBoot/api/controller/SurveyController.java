package com.Meta_Keiber.SpringBoot.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Meta_Keiber.SpringBoot.api.dto.request.SurveyRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.SurveyBasicRS;
import com.Meta_Keiber.SpringBoot.infraestructure.abstract_services.ISurveyService;
import com.Meta_Keiber.SpringBoot.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/survey")
@AllArgsConstructor
public class SurveyController {
  @Autowired
  private ISurveyService surveyService;

  @Operation(summary = "Create Survey", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @PostMapping
  public ResponseEntity<SurveyBasicRS> create(@Validated @RequestBody SurveyRQ request) {
    
    return ResponseEntity.ok(this.surveyService.create(request));
  }

  @Operation(summary = "Get All Survey", description = "TEST")
  @GetMapping(path = "/get")
  public ResponseEntity<Page<SurveyBasicRS>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {

    if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }

    return ResponseEntity.ok(this.surveyService.getAll(page - 1, size, sortType));
  }

  @Operation(summary = "Get Survey", description = "TEST")
  @ApiResponse(responseCode = "400", description = "When the id is not valid", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
  @GetMapping(path = "/get/{id}")
  public ResponseEntity<SurveyBasicRS> get(@PathVariable int id) {
    return ResponseEntity.ok(this.surveyService.get(id));
  }

}
