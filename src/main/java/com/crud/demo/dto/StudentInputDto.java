package com.crud.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class StudentInputDto {
    @NotBlank
    public String firstName;

    @NotBlank
    public String lastName;

    @NotBlank
    public String middleName;

    public StudentInputDto(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
