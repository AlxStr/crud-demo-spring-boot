package com.crud.demo.dto;

import java.util.UUID;

public class StudentOutputDto {
    public final UUID id;
    public final String firstName;
    public final String lastName;
    public final String middleName;

    public StudentOutputDto(UUID id, String firstName, String lastName, String middleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
