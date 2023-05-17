package org.example;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearCheckerTest {
    LeapYearChecker leapYearChecker= new LeapYearChecker();

   @Property
   @Report(Reporting.GENERATED)
    void pass(@ForAll @Size(value=1000) List<@IntRange(min = -1000, max = 1000) Integer> numbers,
              @ForAll @IntRange(min = 1001, max = 2000) int value,
              @ForAll @IntRange(max = 99) int indexToAddElement){
       numbers.add(indexToAddElement,value);
       assertEquals(value,leapYearChecker.trovaMassimo(numbers));


   }

}