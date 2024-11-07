package com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO;

import java.time.LocalDateTime;

import com.gestionBiblioteca.gestionB.api.dto.response.BookResponse;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.utils.enums.StatusReservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsReservationResponse {
  private Long id;
  private LocalDateTime reservation_date;
  private StatusReservation status;

  /*----Relaciones ----*/

  private UserResponse user;
  private BookResponse book;
}
