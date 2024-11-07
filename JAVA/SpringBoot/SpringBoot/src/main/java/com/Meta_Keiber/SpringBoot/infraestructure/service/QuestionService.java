package com.Meta_Keiber.SpringBoot.infraestructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Meta_Keiber.SpringBoot.api.dto.request.OptionQuestionRQ;
import com.Meta_Keiber.SpringBoot.api.dto.request.QuestionRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.QuestionRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.OptionQuestionBasicRS;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.QuestionBasicRS;
import com.Meta_Keiber.SpringBoot.api.exections.BadRequestException;
import com.Meta_Keiber.SpringBoot.domian.entities.OptionQuestion;
import com.Meta_Keiber.SpringBoot.domian.entities.Question;
import com.Meta_Keiber.SpringBoot.domian.entities.Survey;
import com.Meta_Keiber.SpringBoot.domian.repository.OptionQuestionRepository;
import com.Meta_Keiber.SpringBoot.domian.repository.QuestionRepository;
import com.Meta_Keiber.SpringBoot.domian.repository.SurveyRepository;
import com.Meta_Keiber.SpringBoot.infraestructure.abstract_services.IQuestionService;
import com.Meta_Keiber.SpringBoot.utils.enums.SortType;
import com.Meta_Keiber.SpringBoot.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class QuestionService implements IQuestionService {

  @Autowired
  private QuestionRepository questionRepository;
  @Autowired
  private OptionQuestionRepository optionQuestionRespository;
  @Autowired
  private SurveyRepository surveyRepository;

  @Override
  public QuestionRS create(QuestionRQ request) {

    List<OptionQuestionRQ> optionQRQ = request.getOptionQuestion();
    Question entityQuestion = this.requestToEntity(request);
    entityQuestion = this.questionRepository.save(entityQuestion);

    for (OptionQuestionRQ optionRQ : optionQRQ) {
      OptionQuestion entity = OptionQuestion.builder()
          .text(optionRQ.getText())
          .active(optionRQ.getActive())
          .question(
              entityQuestion)
          .build();
      this.optionQuestionRespository.save(entity);
    }
    QuestionRS obj = this.entityToResponse(this.find(entityQuestion.getQuestion_id()));
    System.out.println(entityQuestion);
    return obj;
  }

  private QuestionRS entityToResponse(Question save) {
    List<OptionQuestionBasicRS> questionBasicRS = this.entityToQuestionBasicRS(save.getOptionCuestion());

    return QuestionRS.builder()
        .question_id(save.getQuestion_id())
        .text(save.getText())
        .type(save.getType())
        .active(save.isActive())
        .optionQuestion(questionBasicRS)
        .build();
  }

  private List<OptionQuestionBasicRS> entityToQuestionBasicRS(List<OptionQuestion> optionCuestion) {
    List<OptionQuestionBasicRS> optionQuestionBasicRS = new ArrayList<>();
    for (OptionQuestion obj : optionCuestion) {
      optionQuestionBasicRS.add(OptionQuestionBasicRS.builder()
          .option_id(obj.getOption_id())
          .text(obj.getText())
          .active(obj.isActive())
          .build());
    }
    return optionQuestionBasicRS;
  }

  private Question requestToEntity(QuestionRQ request) {

    Survey obj = this.surveyRepository.findById(request.getSurvey_id())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Survey")));
    List<OptionQuestion> list = new ArrayList<>();
    return Question.builder()
        .text(request.getText())
        .type(request.getType())
        .active(request.isActive())
        .survey(obj)
        .optionCuestion(list)
        .build();
  }

  @Override
  public QuestionBasicRS get(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public QuestionBasicRS update(QuestionRQ request, Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Integer id) {
    this.questionRepository.delete(this.find(id));
  }

  @Override
  public Page<QuestionBasicRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.questionRepository.findAll(pagination)
        .map(this::entityToResponse);
  }

  private Question find(Integer id) {
    return this.questionRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Question")));
  }

}
