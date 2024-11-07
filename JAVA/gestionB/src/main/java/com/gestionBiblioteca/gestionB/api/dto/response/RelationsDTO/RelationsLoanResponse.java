package com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO;

import java.time.LocalDateTime;

import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.utils.enums.StatusLoan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsLoanResponse {
  private Long id;
  private LocalDateTime loan_date;
  private LocalDateTime return_date;
  private StatusLoan status;

  /*----Relaciones ----*/
  private UserResponse user;
  private BookResponse book;
}
