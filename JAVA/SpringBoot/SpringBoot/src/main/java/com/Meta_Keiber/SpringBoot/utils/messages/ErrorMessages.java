package com.Meta_Keiber.SpringBoot.utils.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {

    private final String mensaje = "hola";

    public static String idNotFound(String entity) {
        // return "No hay registros en la entidad "+entity+ " con el id suministrado";
        final String message = "There are no records in the entity %s with the supplied id";
        return String.format(message, entity);
    }
}
