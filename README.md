# How to use Mocks

## Description

This is a simple example of how to use mocks in Java with:

* [Mockito](https://site.mockito.org/)
* [JUnit 5](https://junit.org/junit5/)
* [Hamcrest](http://hamcrest.org/JavaHamcrest/)
* [Maven](https://maven.apache.org/)

## How to run

```bash
mvn clean test
```

## Example

### How to mock an exception

To mock an exception we can use the method `thenThrow` from `Mockito` and pass the exception that we want to throw.

```java
// src/test/java/br/com/aristoteles/business/ListTest.java

public class ListTest {
  @Test
  void testMockingList_When_ThrowsAnException() {
    var list = mock(List.class);

    when(list.get(anyInt())).thenThrow(new RuntimeException("BOOM!"));

    assertThrows(RuntimeException.class,
      () -> list.get(anyInt()),
      () -> "Should have throw an exception!");
  }
}
```

### How to mock a list

In this example we have a class that uses a service to retrieve a list of courses and then filter them by the word "Spring".

```java
// src/test/java/br/com/aristoteles/business/CourseBusinessMockTest.java

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
```

Make with ❤️ by [Aristóteles Coutinho](https://www.linkedin.com/in/aristotelescoutinho/)