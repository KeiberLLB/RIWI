package com.Meta_Keiber.SpringBoot.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRQ {
  @Size(min = 0, max = 100, message ="Name exceeds the number of characters allowed")
  @NotBlank(message = "The name is required.")
  private String name;
  @Size(min = 0, max = 100, message ="Email exceeds the number of characters allowed")
  @NotBlank(message = "Email is required")
  @Email
  private String email;
  @Size(min = 0, max = 255, message ="Password exceeds the number of characters allowed")
  @NotBlank(message = "Password is required")
  private String password;
  private boolean active;
}
