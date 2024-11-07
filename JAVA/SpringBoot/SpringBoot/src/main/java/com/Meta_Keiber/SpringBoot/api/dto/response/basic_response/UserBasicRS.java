package com.Meta_Keiber.SpringBoot.api.dto.response.basic_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicRS {
  private int user_id;
  private String name;
  private String email;
  private boolean active;
}
