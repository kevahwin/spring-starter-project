package com.practice.project_enrolment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String index(){
    return "Hello World from Project Enrollment API";

  }

}
