package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseUtilitiesTest {
    CaseUtilities c = new CaseUtilities();

    @Test
    void simpleCase(){
        assertEquals("laMiaProva", c.toCamelCase("la mia prova", false));
    }

    @Test
    void simpleCaseWithCustomDelimiter(){
        assertEquals(
                "LaMiaProvaConDiversiDelimitatori",
                c.toCamelCase("la mia prova-con-diversi -delimitatori ", true, '-')
        );
    }

    @Test
    void emptyStringCase(){
        assertEquals("", c.toCamelCase("", false));
    }

    @Test
    void nullStringCase(){
        assertNull(c.toCamelCase(null, false));
    }

}


