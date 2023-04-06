package org.example;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        CaseUtilities c = new CaseUtilities();
        System.out.println("ecco il risultato:  ");
        System.out.println(c.toCamelCase("aas weweSis awe ", false, '-', '.'));
    }

    int fibonacci(int n){
        if(n < 0)
            throw new InputMismatchException();

        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}