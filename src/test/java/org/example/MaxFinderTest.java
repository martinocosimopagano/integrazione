package org.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxFinderTest {
    MaxFinder maxFinder = new MaxFinder();

   @Property(generation = GenerationMode.RANDOMIZED)
   @Report(Reporting.GENERATED)
   @StatisticsReport(format = Histogram.class)
    void pass(@ForAll @Size(value = 100) List<@IntRange(min = -1000, max = 1000) Integer> numbers,
              @ForAll @IntRange(min = 1001) int value,
              @ForAll @IntRange(max = 99) int indexToAddElement){
       numbers.add(indexToAddElement,value);
       assertEquals(indexToAddElement, maxFinder.trovaIndiceUnicoMassimo(numbers));
       for(int element: numbers){
           Statistics.collect(element >= 0 ? "positivo" : "negativo");
       }
       Statistics.label("Value").collect(value);
       Statistics.label("indexToAddElement").collect(indexToAddElement);



   }

    @Property
    @Report(Reporting.GENERATED)
    void fail(@ForAll @Size(value=100) List<@IntRange(min = -1000, max = 1000) Integer> numbers,
              @ForAll @IntRange(min = 1001, max = 2000) int value,
              @ForAll @IntRange(max = 50) int indexToAddElement1,
              @ForAll @IntRange(min = 52, max = 99) int indexToAddElement2){
        numbers.add(indexToAddElement1,value);
        numbers.add(indexToAddElement2,value);
        assertEquals(-1, maxFinder.trovaIndiceUnicoMassimo(numbers));

    }

    @Property
    @Report(Reporting.GENERATED)
    void invalid(@ForAll @Size(value=1500) List<@IntRange(min = -1000, max = 1000) Integer> numbers){
        assertThrows(Exception.class, () -> maxFinder.trovaIndiceUnicoMassimo(numbers));
    }
}