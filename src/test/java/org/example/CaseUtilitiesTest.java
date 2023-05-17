package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseUtilitiesTest {
    CaseUtilities c;
    @BeforeEach
    void createInstance(){
        c = new CaseUtilities();
    }
/*
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

 */

    // -------------------------------------------------------------------------------------------

    @Test
    //Null String, 1 Delimiters, false
    void nullStringCase(){
        assertEquals(null, c.toCamelCase(null, false, '-'));
    }


    @Test
    //Regular String, 0 Delimiters, false
    void noExtraDelimiters(){
        assertEquals("stringaDaConvertire", c.toCamelCase("stringa da convertire", false));
    }

    @Test
        //String of length > 1, 1 Delimeters, True
    void lenghtMajor1CapitalizeTrue(){
        assertEquals("ConvertiQuestaStringa",c.toCamelCase("converti-questa-stringa",true,'-'));
    }

    @Test
    //empty String, 0 Delimiters, false
    void emptyStringCase(){
        assertEquals("", c.toCamelCase("", false));
    }

    @Test
    void manyDelimiters(){assertEquals("convertiQuestaStringa",c.toCamelCase("converti-questa.stringa",false,'-','.'));}

    @Test
        //String of length 1, 0 Delimeters, True
    void lenght1CapitalizeTrue(){
        assertEquals("C",c.toCamelCase("c",true));
    }

    @Test
        //str è già in CamelCase, 1 Delimiters, false
    void stringInCamelCase(){
        assertEquals("stringagiaincamelcase", c.toCamelCase("stringaGiaInCamelCase", false, '-'));
    }

    @Test
        //carattere speciale(non avente maiuscola) dopo separatore
    void specialCharacterAfterDelimiters(){
        assertEquals("prova-stringa", c.toCamelCase("prova -stringa", false));
    }

    @Test
        //carattere speciale come prima lettera con capitalizeFirstLetter
    void specialCharacterIsFirstWithCapitalize(){
        assertEquals("-prova-stringa", c.toCamelCase("-prova -stringa", true));
    }
    @Test
    void unconventionalCharacters(){
        assertEquals("مرحباًجميعاً", c.toCamelCase("مرحباً جميعاً", false,'-'));
    }

    @Test
        //empty String, 0 Delimiters, true
    void capitalizeEmptyStringCase(){
        assertEquals("", c.toCamelCase("", true));
    }

    @Test
        //str non contiene i caratteri separatori, 1 Delimiters, false
    void stringWithoutDelimiters(){
        assertEquals("noncontieneseparatori", c.toCamelCase("noncontieneseparatori", false, '-'));
    }


    @Test
        //str contiene solo caratteri separatori, 2 Delimiters, false
    void stringOnlyDelimiters(){
        assertEquals("", c.toCamelCase("-- . -.", false, '-', '.'));
    }

    @Test
    void lessCharactersThenDelimiters(){assertEquals("up",c.toCamelCase("up",false,'-','.',',','['));}

    @Test
    void startDelimiters(){assertEquals("ciao",c.toCamelCase("-ciao",false,'-'));}







}


