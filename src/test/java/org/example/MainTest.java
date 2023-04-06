package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "1,2", "55,10"})
    void fibonacciTestHappyPath(int expected, int actualInput){
        assertEquals(expected, main.fibonacci(actualInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    void fibonacciTestSadPath1(int actualInput){
        assertThrows(InputMismatchException.class, () -> main.fibonacci(actualInput));
    }

    @ParameterizedTest
    @NullSource
    void fibonacciTestSadPath2(int actualInput){
    }

}