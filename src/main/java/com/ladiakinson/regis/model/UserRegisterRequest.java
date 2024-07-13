package com.ladiakinson.regis.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegisUser {
    String userName;
    String email;
    String password;
}
