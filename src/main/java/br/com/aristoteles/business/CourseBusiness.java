package br.com.aristoteles.business;

import br.com.aristoteles.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {
  // CourseService is a dependency
  private CourseService service;

  // Constructor
  public CourseBusiness(CourseService service) {
    this.service = service;
  }

  // This method list all courses by student
  public List<String> retrieveCoursesRelatedToSpring(String student) {
    var filteredCourses = new ArrayList<String>();
    if (student == null) return filteredCourses;

    var allCourses = service.retrieveCourses(student);

    for (String course : allCourses) {
      if(course.contains("Spring")) {
        filteredCourses.add(course);
      }
    }

    return filteredCourses;
  }
}
