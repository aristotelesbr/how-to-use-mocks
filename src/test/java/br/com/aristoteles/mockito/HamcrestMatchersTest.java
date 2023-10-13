package br.com.aristoteles.mockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
  @Test
  void testHamcrestListMatchers() {
    List<Integer> scores = Arrays.asList(99, 100, 101, 105);

    assertThat(scores, hasSize(4));
    assertThat(scores, hasItems(100,105));
    assertThat(scores, everyItem(greaterThan(10)));
    assertThat(scores, everyItem(lessThan(120)));
  }

  @Test
  void testHamcrestEmptyStringMatchers() {
    assertThat("", is(emptyString()));
    assertThat(null, is(emptyOrNullString()));
  }

  @Test
  void testHamcrestArray() {
    Integer[] myArray = {1, 2, 3};

    assertThat(myArray, arrayWithSize(3));
    assertThat(myArray, arrayContaining(1,2,3));
    assertThat(myArray, arrayContainingInAnyOrder(3,1,2));
  }

}
