package br.com.aristoteles.mockito;


import br.com.aristoteles.business.CourseBusiness;
import br.com.aristoteles.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseBusinessMockitoInjectMocksTest {
  @Mock
  private CourseService mockCourseService;
  //    CourseService mockCourseService = mock(CourseService.class);

  @InjectMocks
  private CourseBusiness courseBusiness;
  //    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);

  @Test
  void testCoursesRelatedToSpring_When_UsingAsMock() {
    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");
    when(mockCourseService.retrieveCourses("Aristóteles"))
      .thenReturn(courses);

    var filteredCourses =
      courseBusiness.retrieveCoursesRelatedToSpring("Aristóteles");

    assertEquals(2, filteredCourses.size());
  }
}
