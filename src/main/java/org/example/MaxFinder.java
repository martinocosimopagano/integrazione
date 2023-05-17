package org.example;

import java.util.List;

public class MaxFinder {

    public Integer trovaIndiceUnicoMassimo(List<Integer> array) {
        if (array.size() == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto.");
        } else if (array.size() > 1200) {
            throw new IllegalArgumentException("L'array non può essere più lungo di 1000.");
        }

        int max = array.get(0);
        int maxIndex = 0;
        boolean hasMultipleMax = false;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
                maxIndex = i;
                hasMultipleMax = false;
            } else if (array.get(i) == max) {
                hasMultipleMax = true;
            }
        }

        if (hasMultipleMax) {
            return -1; // Indica che ci sono più massimi
        }

        return maxIndex;
    }



}