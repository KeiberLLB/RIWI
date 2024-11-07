package com.Riwi.LastFilter.api.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse implements Serializable {

    private String status;
    private Integer code;
    @Builder.Default
    private String message = "Listing errors";

}