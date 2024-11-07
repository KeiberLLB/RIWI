package com.Meta_Keiber.SpringBoot.infraestructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Meta_Keiber.SpringBoot.api.dto.request.SurveyRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.QuestionRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.SurveyRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.OptionQuestionBasicRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.SurveyBasicRS;
import com.Meta_Keiber.SpringBoot.api.exections.BadRequestException;
import com.Meta_Keiber.SpringBoot.domian.entities.OptionQuestion;
import com.Meta_Keiber.SpringBoot.domian.entities.Question;
import com.Meta_Keiber.SpringBoot.domian.entities.Survey;
import com.Meta_Keiber.SpringBoot.domian.entities.Users;
import com.Meta_Keiber.SpringBoot.domian.repository.SurveyRepository;
import com.Meta_Keiber.SpringBoot.domian.repository.UserRepository;
import com.Meta_Keiber.SpringBoot.infraestructure.abstract_services.ISurveyService;
import com.Meta_Keiber.SpringBoot.utils.enums.SortType;
import com.Meta_Keiber.SpringBoot.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SurveyService implements ISurveyService {
  @Autowired
  private SurveyRepository surveyRepository;
  @Autowired
  private UserRepository userRepository;

  @Override
  public SurveyBasicRS create(SurveyRQ request) {
    Survey newSurvey = this.requestToEntity(request);
    return this.entityToResponse(this.surveyRepository.save(newSurvey));
  }

  @Override
  public SurveyRS get(Integer id) {
    return this.entityToResponse(this.find(id));
  }

  @Override
  public SurveyBasicRS update(SurveyRQ request, Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<SurveyBasicRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.surveyRepository.findAll(pagination)
        .map(this::entityToResponse);
  }

  private SurveyRS entityToResponse(Survey entity) {

    List<QuestionRS> questionRS = this.entityToQuestionRS(entity.getQuestion());

    return SurveyRS.builder()
        .survey_id(entity.getSurvey_id())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .creationDate(entity.getCreationDate())
        .active(entity.isActive())
        .question(
            questionRS)
        .build();
  }

  private List<QuestionRS> entityToQuestionRS(List<Question> question) {
    List<QuestionRS> questionRS = new ArrayList<>();
    for (Question entity : question) {
      List<OptionQuestionBasicRS> optionQuestionBasicRS = this
          .entityToOptionQuestionBasicRS(entity.getOptionCuestion());
      questionRS.add(QuestionRS.builder()
          .question_id(entity.getQuestion_id())
          .text(entity.getText())
          .type(entity.getType())
          .active(entity.isActive())
          .optionQuestion(
              optionQuestionBasicRS)
          .build());

    }

    return questionRS;

  }

  private List<OptionQuestionBasicRS> entityToOptionQuestionBasicRS(List<OptionQuestion> optQuestions) {
    List<OptionQuestionBasicRS> optionQuestionBasicRS = new ArrayList<>();
    for (OptionQuestion optionQuestionBasicRS2 : optQuestions) {
      optionQuestionBasicRS.add(OptionQuestionBasicRS.builder()
          .option_id(optionQuestionBasicRS2.getOption_id())
          .text(optionQuestionBasicRS2.getText())
          .active(optionQuestionBasicRS2.isActive())
          .build());

    }
    return null;
  }

  private Survey requestToEntity(SurveyRQ request) {
    Users creator = this.userRepository.findById(request.getCreator_id())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("User")));
    List<Question> question = new ArrayList<>();

    return Survey.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .active(request.isActive())
        .question(question)
        .creator(creator)
        .build();
  }

  private Survey find(Integer id) {
    return this.surveyRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Survey")));
  }

}
