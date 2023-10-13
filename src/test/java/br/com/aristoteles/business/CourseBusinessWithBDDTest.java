package br.com.aristoteles.business;

import br.com.aristoteles.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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

  @DisplayName("Delete courses not related to spring using mockito should call Delete")
  @Test
  void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CalMethod_DeleteCoursesNotRelatedToSpring() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);
    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");

    given(mockCourseService.retrieveCourses("Aristóteles"))
      .willReturn(courses);

    courseBusiness.DeleteCoursesNotRelatedToSpring("Aristóteles");

    verify(mockCourseService).deleteCourse("API");
    verify(mockCourseService, never()).deleteCourse("Spring Boot");
    verify(mockCourseService, times(1)).deleteCourse("API");
    /*
     Alternative to times(1):
     verify(mockCourseService, atLeastOnce()).deleteCourse("API");
     verify(mockCourseService, atLeast(1)).deleteCourse("API");
    */
  }

  @DisplayName("Delete courses not related to spring using mockito should call Delete V2")
  @Test
  void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CalMethod_DeleteCoursesNotRelatedToSpring_V2() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);
    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");

    given(mockCourseService.retrieveCourses("Aristóteles"))
      .willReturn(courses);

    courseBusiness.DeleteCoursesNotRelatedToSpring("Aristóteles");

    then(mockCourseService).should().deleteCourse("API");
    then(mockCourseService).should(never()).deleteCourse("Spring Boot");
    then(mockCourseService).should(times(1)).deleteCourse("API");
  }

  @Test
  void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CalMethod_DeleteCoursesNotRelatedToSpring_V1() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);
    List<String> courses =
      Arrays.asList("Spring Boot", "API");

    given(mockCourseService.retrieveCourses("Aristóteles"))
      .willReturn(courses);

    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    courseBusiness.DeleteCoursesNotRelatedToSpring("Aristóteles");

    then(mockCourseService).should().deleteCourse(argumentCaptor.capture());
    assertThat(argumentCaptor.getValue(), is("API"));
  }

  @Test
  void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CalMethod_DeleteCoursesNotRelatedToSpring_V2() {
    CourseService mockCourseService = mock(CourseService.class);
    CourseBusiness courseBusiness   = new CourseBusiness(mockCourseService);
    List<String> courses =
      Arrays.asList("Spring", "Spring Boot", "API", "Microservices");

    given(mockCourseService.retrieveCourses("Aristóteles"))
      .willReturn(courses);

    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    courseBusiness.DeleteCoursesNotRelatedToSpring("Aristóteles");

    then(mockCourseService).should(times(2)).deleteCourse(argumentCaptor.capture());
    assertThat(argumentCaptor.getAllValues().size(), is(2));
  }
}
