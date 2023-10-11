package br.com.aristoteles.business;

import br.com.aristoteles.service.CourseService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseBusinessMockTest {
  @Test
  void testCoursesRelatedToSpring_When_UsingAsMock() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);

    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");
    when(mockCourseService.retrieveCourses("Aristóteles"))
      .thenReturn(courses);

    var filteredCourses =
      courseBusiness.retrieveCoursesRelatedToSpring("Aristóteles");

    assertEquals(2, filteredCourses.size());
  }
}
