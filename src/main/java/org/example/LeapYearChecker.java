package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeapYearChecker {

    public  Integer trovaMassimo(List<Integer> array) {
        if (array.size()== 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto.");
        }

        int max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }

        return max;
    }
}