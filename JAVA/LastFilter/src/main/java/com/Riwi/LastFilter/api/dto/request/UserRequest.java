package com.Riwi.LastFilter.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @Size(max = 150)
    @NotNull(message = "The name cannot be empty")
    private String name;
    @Size(max = 150)
    @NotNull(message = "The email cannot be empty")
    private String email;
    @Size(max = 150)
    @NotNull(message = "The password cannot be empty")
    private String password;
    private Boolean isActive;
}
