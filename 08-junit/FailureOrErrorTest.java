package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    void test1() {
        fail();
    }

    @Test
    void test2() {
        throw new ArithmeticException("Nie mozna dzielić przez 0");
    }

    @Test
    void test3() {
        try{
            int a = 100/0;
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}
