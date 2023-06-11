package com.cody.advisortracker.model;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Advisor(
        @Id Integer id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        String phone,
        @NotBlank @Email String email,
        String marketer,
        Set<AdvisorTags> status) {

}
