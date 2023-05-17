package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordinamento {
    public static int[] pidgeonholeSort(int[] arr) {
        // Trova il valore minimo e massimo nell'array
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int size = maxVal - minVal + 1;

        // Inizializza un array di buche (pigeonholes) con valori iniziali a 0
        int[] holes = new int[size];

        // Conta il numero di occorrenze di ciascun valore nell'array
        for (int num : arr) {
            holes[num - minVal]++;
        }

        // Copia i valori dall'array di buche nell'array di output ordinato
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (holes[i] > 0) {
                int value = i + minVal;
                for (int j = 0; j < holes[i]; j++) {
                    sortedList.add(value);
                }
            }
        }

        // Converti la lista ordinata in un array
        int[] sortedArr = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            sortedArr[i] = sortedList.get(i);
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 5};
        int[] sortedArr = pidgeonholeSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

}
