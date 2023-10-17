package br.com.aristoteles.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {
  @Test
  void testSpyV1() {
    List<String> spyArrayList = spy(ArrayList.class);
    spyArrayList.add("foo");


    verify(spyArrayList).add("foo");
    verify(spyArrayList, never()).remove("foo-bar");
    verify(spyArrayList, never()).remove(anyString());
  }

  @Test
  void testSpyV2() {
    List<String> spyArrayList = spy(ArrayList.class);

    assertEquals(0, spyArrayList.size());

    when(spyArrayList.size()).thenReturn(5);

    spyArrayList.add("Foo-Bar");
    assertEquals(5, spyArrayList.size());
  }

  @Test
  void testSpyV3() {
    List<String> spyArrayList = spy(ArrayList.class);

    spyArrayList.add("foo-bar");
    assertEquals(1, spyArrayList.size());

    spyArrayList.remove("foo-bar");
    assertEquals(0, spyArrayList.size());
  }

  @Test
  void testSpyV4() {
    List<String> spyArrayList = spy(ArrayList.class);

    assertEquals(0, spyArrayList.size());
    when(spyArrayList.size()).thenReturn(5);
    assertEquals(5, spyArrayList.size());
  }
}
