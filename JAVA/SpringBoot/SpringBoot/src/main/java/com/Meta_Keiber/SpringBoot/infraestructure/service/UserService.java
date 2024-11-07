package com.Meta_Keiber.SpringBoot.infraestructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Meta_Keiber.SpringBoot.api.dto.request.UserRQ;
import com.Meta_Keiber.SpringBoot.api.dto.response.basic_response.UserBasicRS;
import com.Meta_Keiber.SpringBoot.api.exections.BadRequestException;
import com.Meta_Keiber.SpringBoot.domian.entities.Survey;
import com.Meta_Keiber.SpringBoot.domian.entities.Users;
import com.Meta_Keiber.SpringBoot.domian.repository.UserRepository;
import com.Meta_Keiber.SpringBoot.infraestructure.abstract_services.IUserService;
import com.Meta_Keiber.SpringBoot.utils.enums.SortType;
import com.Meta_Keiber.SpringBoot.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserBasicRS create(UserRQ request) {
    Users newuser = this.requestToEntity(request);
    return this.entityToResponse(this.userRepository.save(newuser));
  }

  @Override
  public UserBasicRS get(Integer id) {
    return this.entityToResponse(this.find(id));
  }

  @Override
  public UserBasicRS update(UserRQ request, Integer id) {
    Users user = this.find(id);
    Users userUpdate = this.requestToEntity(request);
    userUpdate.setUser_id(user.getUser_id());
    return this.entityToResponse(this.userRepository.save(userUpdate));
  }

  @Override
  public void delete(Integer id) {
    this.userRepository.delete(this.find(id));
  }

  @Override
  public Page<UserBasicRS> getAll(int page, int size, SortType sortType) {
    if (page < 0)
      page = 0;
    PageRequest pagination = null;
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return this.userRepository.findAll(pagination)
        .map(this::entityToResponse);
  }

  private UserBasicRS entityToResponse(Users entity) {
    return UserBasicRS.builder()
        .user_id(entity.getUser_id())
        .name(entity.getName())
        .email(entity.getEmail())
        .active(entity.isActive())
        .build();
  }

  private Users requestToEntity(UserRQ request) {
    List<Survey> survey = new ArrayList<>();

    return Users.builder()
        .name(request.getName())
        .email(request.getEmail())
        .password(request.getPassword())
        .active(request.isActive())
        .survey(survey)
        .build();
  }

  private Users find(Integer id) {
    return this.userRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("User")));
  }

}
