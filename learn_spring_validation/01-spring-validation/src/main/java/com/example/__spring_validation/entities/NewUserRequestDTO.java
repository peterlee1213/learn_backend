package com.example.__spring_validation.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequestDTO {
    // 必须符合email格式
    @Email(message = "not a valid email")
    // 非null且包含至少一个有意义的字符
    @NotBlank(message = "email can not be blank")
    // 规定字符串长度
    @Length(min = 6, max = 50, message = "长度在6到50之间")
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
