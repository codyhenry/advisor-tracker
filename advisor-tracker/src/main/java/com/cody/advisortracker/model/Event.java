package com.cody.advisortracker.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

//in front end, add advisor first and last name to event
public record Event(
    @Id Integer id,
    @NotBlank LocalDate date,
    LocalDateTime time,
    Integer advisorId,
    String notes,
    @NotBlank EventType eventType,
    EventStatus eventStatus) {
}
