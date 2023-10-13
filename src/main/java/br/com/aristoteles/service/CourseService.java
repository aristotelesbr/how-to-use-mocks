package br.com.aristoteles.service;

import java.util.List;

public interface CourseService {
  public List<String> retrieveCourses(String student);

  public void DeleteCourse(String course);
}
