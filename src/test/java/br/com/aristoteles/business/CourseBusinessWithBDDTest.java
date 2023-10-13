package br.com.aristoteles.business;

import br.com.aristoteles.service.CourseService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CourseBusinessWithBDDTest {
  @Test
  void testCoursesRelatedToSpring_When_UsingAsMock() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);
    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");

    given(mockCourseService.retrieveCourses("Aristóteles"))
      .willReturn(courses);

    var filteredCourses =
      courseBusiness.retrieveCoursesRelatedToSpring("Aristóteles");

    assertThat(filteredCourses.size(), is(2));
  }
}
