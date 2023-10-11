package br.com.aristoteles.business;

import br.com.aristoteles.service.CourseService;
import br.com.aristoteles.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseBusinessStubTest {
  @Test
  void testCoursesRelatedToSpring_When_UsingAsStub() {
    // Given
    CourseService courseService   = new CourseServiceStub();
    CourseBusiness courseBusiness = new CourseBusiness(courseService);
    // When
    var filteredCourses =
      courseBusiness.retrieveCoursesRelatedToSpring("Aristóteles");

    // Then
    assertEquals(2, filteredCourses.size());
  }

  @Test
  void testCoursesRelatedToSpring_When_UsingInvalidParam() {
    CourseService courseService   = new CourseServiceStub();
    CourseBusiness courseBusiness = new CourseBusiness(courseService);

    var filteredCourses =
      courseBusiness.retrieveCoursesRelatedToSpring(null);

    assertEquals(0, filteredCourses.size());
  }
}
