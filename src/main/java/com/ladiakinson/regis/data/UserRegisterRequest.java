package com.ladiakinson.regis.data;


import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegisterRequest {
    String userName;
    String email;
    String password;
}
