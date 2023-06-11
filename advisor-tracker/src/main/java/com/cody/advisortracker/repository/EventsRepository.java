package com.cody.advisortracker.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.cody.advisortracker.model.Event;

public interface EventsRepository extends ListCrudRepository<Event, Integer> {
  // pass in todays date, get all events for the month
  @Query("""
      SELECT * from events
      WHERE date between :year-:month-01 and :year-:month-31
      """)
  List<Event> findAllByDate(@Param("month") Integer month, @Param("year") Integer year);

  @Query("""
      SELECT * from events
      WHERE advisor_id = advisorId"
      """)
  List<Event> findAllByAdvisorId(@Param("advisorId") Integer advisorId);
}
