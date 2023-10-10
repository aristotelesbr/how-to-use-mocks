package br.com.aristoteles.service.stubs;

import br.com.aristoteles.service.CourseService;

import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements CourseService {
  public List<String> retrieveCourses(String student) {
    return Arrays.asList("Spring", "Spring Boot", "API", "Microservices");
  }
}
