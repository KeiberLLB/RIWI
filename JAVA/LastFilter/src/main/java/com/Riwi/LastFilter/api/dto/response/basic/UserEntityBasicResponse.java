package com.Riwi.LastFilter.api.dto.response.basic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityBasicResponse {
    private Long id;
    private String email;
    private String name;
}
