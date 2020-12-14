package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = null;

    /* Aby setUp() działał z beforeAll należałoby zmienić metodę na statyczną */

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    void addTest() {
        assertEquals(7,calculator.add(2,5));
        assertEquals(0,calculator.add(0,0));
    }

    @Test
    void multiplyTest() {
        assertEquals(0,calculator.multiply(3,0));
        assertEquals(10,calculator.multiply(10,1));
    }

    @Test
    void addPositiveNumbersTest() {
        Throwable throw1 = assertThrows(IllegalArgumentException.class, ()->{calculator.addPositiveNumbers(-3,6);});
        assertEquals("The arguments must be positive", throw1.getMessage());
    }

}