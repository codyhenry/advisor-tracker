package com.cody.advisortracker.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cody.advisortracker.model.Advisor;
import com.cody.advisortracker.model.AdvisorTags;
import com.cody.advisortracker.repository.AdvisorsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/advisor")
@CrossOrigin
public class AdvisorController {
  private final AdvisorsRepository repository;

  public AdvisorController(AdvisorsRepository repository) {
    this.repository = repository;
  }

  // Only admin can access this endpoint
  // @GetMapping("/admin/{id}")
  // public Optional<Advisor> getAllAdvisors(@PathVariable Integer id) {
  // if(!)
  // return repository.findAll();
  // }
  // Only admin can access this endpoint
  // @ResponseStatus(HttpStatus.CREATED)
  // @PostMapping("")
  // public void createAdvisor(@Valid @RequestBody Advisor advisor) {
  // repository.save(advisor);
  // }
  // Only admin can access this endpoint
  // @GetMapping("/{tag}")
  // public List<Advisor> findByTag(@PathVariable AdvisorTags tag) {
  // // query the join table first
  // return repository.findAllByTag(tag);
  // }
  // Only admin can access this endpoint
  // @ResponseStatus(HttpStatus.OK)
  // @DeleteMapping("/{id}")
  // public void deleteAdvisor(@PathVariable Integer id) {
  // repository.deleteById(id);
  // }
  // Only admin can access this endpoint
  // @GetMapping("")
  // public List<Advisor> getAllAdvisors() {
  // return repository.findAll();
  // }

  @GetMapping("/{id}")
  public Optional<Advisor> findById(@PathVariable Integer id) {
    return repository.findById(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public void updateAdvisor(@RequestBody Advisor advisor, @PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Advisor not found");
    }
    repository.save(advisor);
  }

}
