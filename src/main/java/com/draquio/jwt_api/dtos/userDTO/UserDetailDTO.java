package com.draquio.jwt_api.dtos.userDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {
    public Long id;
    public String username;
    public String email;
}
