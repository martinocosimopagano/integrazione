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

    // -------------------------------------------------------------------------------------------

    @Test
    void case1(){
        assertEquals(null, c.toCamelCase(null, false, '-'));
    }

    @Test
    void case2(){
        assertEquals("stringaDaConvertire", c.toCamelCase("stringa da convertire", false));
    }

    @Test
    void case3(){
        assertEquals("", c.toCamelCase("", false, '-', '.'));
    }

    @Test
    void case4(){
        assertEquals("", c.toCamelCase("", true));
    }

    @Test
    void case5(){
        assertEquals("noncontieneseparatori", c.toCamelCase("noncontieneseparatori", false, '-'));
    }

    @Test
    void case6(){
        assertEquals("", c.toCamelCase("- . -- .. .", false, '-', '.'));
    }

    @Test
    void case7(){
        assertEquals("stringagiaincamelcase", c.toCamelCase("stringaGiaInCamelCase", false, '-'));
    }
}


