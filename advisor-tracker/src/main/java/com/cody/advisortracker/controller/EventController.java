package com.cody.advisortracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cody.advisortracker.model.Event;
import com.cody.advisortracker.repository.EventsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/calendar")
@CrossOrigin
public class EventController {

  private final EventsRepository repository;

  public EventController(EventsRepository repository) {
    this.repository = repository;
  }

  // only admin can access this endpoint
  @GetMapping("/{date}")
  public List<Event> getMonthEvents(@PathVariable LocalDate date) {
    return repository.findAllByDate(date.getMonthValue(), date.getYear());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void createEvent(@Valid @RequestBody Event event) {
    repository.save(event);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public void updateEvent(@RequestBody Event event, @PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
    }
    repository.save(event);
  }

  @GetMapping("/{advisorId}")
  public List<Event> findByAdvisor(@PathVariable Integer advisorId) {
    return repository.findAllByAdvisorId(advisorId);
  }
}
