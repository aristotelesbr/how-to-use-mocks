package br.com.aristoteles.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
  @Test
  void testMockingList_When_SizeIsCalled_ShouldReturn10() {
    List list = mock(List.class);
    when(list.size()).thenReturn(10);

    assertEquals(10, list.size());
  }

  @Test
  void testMockingList_When_SizeIsCalled_ShouldMultipleValues() {
    List list = mock(List.class);
    when(list.size())
      .thenReturn(10)
      .thenReturn(20)
      .thenReturn(30);

    assertEquals(10, list.size());
    assertEquals(20, list.size());
    assertEquals(30, list.size());
  }

  @Test
  void testMockingList_When_GetIsCalled_ShouldReturnFooValue() {
    List list = mock(List.class);
    when(list.get(0)).thenReturn("Foo");

    assertEquals("Foo", list.get(0));
    assertNull(list.get(1));
  }

  @Test
  void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnFooValue() {
    List list = mock(List.class);
    // If you  are using argument matchers, all arguments
    // have to be provided by matchers.
    when(list.get(anyInt())).thenReturn("Foo");

    assertEquals("Foo", list.get(anyInt()));
  }

  @Test
  void testMockingList_When_ThrowsAnException() {
    var list = mock(List.class);

    when(list.get(anyInt())).thenThrow(new RuntimeException("BOOM!"));

    assertThrows(RuntimeException.class,
      ()-> list.get(anyInt()),
      () -> "Should have throw an");
  }
}
