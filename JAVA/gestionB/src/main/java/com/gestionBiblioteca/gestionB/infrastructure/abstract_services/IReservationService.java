package com.gestionBiblioteca.gestionB.infrastructure.abstract_services;

import com.gestionBiblioteca.gestionB.api.dto.request.ReservationRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.RelationsDTO.RelationsReservationResponse;

public interface IReservationService extends CRUD<ReservationRQ, RelationsReservationResponse, Long> {
  
}
