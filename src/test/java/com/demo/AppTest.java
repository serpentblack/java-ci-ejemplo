package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {
  @Test void suma_debe_funcionar() {
    assertEquals(5, App.suma(2, 3));
  }
}
