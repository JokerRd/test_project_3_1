package ru.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestMapperDto {

    private int id;
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String role;
    private String description;
    private String image;
    private String image2;
    private String image3;
    private String ignore;
}
