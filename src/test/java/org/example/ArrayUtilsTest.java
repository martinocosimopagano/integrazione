package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    ArrayUtils utils = new ArrayUtils();

    @Test
    public void nullCase(){
        int[] nullArray = null;
        utils.reverse(nullArray,0,0);
        assertNull(nullArray);
    }

    @Test
    public void negativeStartCase(){
        int array1[] = {4,5,6,7,8};
        int array2[] = {6,5,4,7,8};
        utils.reverse(array1,-1,3);
        assertArrayEquals(array2, array1);
    }

}