package com.cody.advisortracker.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.cody.advisortracker.model.Advisor;

public interface AdvisorsRepository extends ListCrudRepository<Advisor, Integer> {

}
