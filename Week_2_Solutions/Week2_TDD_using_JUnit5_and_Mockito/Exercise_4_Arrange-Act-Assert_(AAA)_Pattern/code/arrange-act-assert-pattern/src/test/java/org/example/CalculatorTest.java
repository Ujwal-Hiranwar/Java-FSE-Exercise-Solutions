package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

private Calculator calculator;

  @Before
  public void setUp() {
      //setup is done
      calculator = new Calculator();
      System.out.println("Setup: New Calculator created");
  }

  @After
    public void tearDown() {
      //teardown is done
      calculator = null;
      System.out.println("Teardown: Calculator object is equals null");
  }

  @Test
  public void testAddition() {
      // Arrange
      int a = 10;
      int b = 5;

      // Act
      int result = calculator.add(a, b);

      // Assert
      assertEquals(15, result);
  }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 3;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }
}