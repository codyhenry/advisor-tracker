package com.cody.advisortracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  // retrieve login information
  @GetMapping("/test")
  public String home() {
    return "Hello World";
  }

}
