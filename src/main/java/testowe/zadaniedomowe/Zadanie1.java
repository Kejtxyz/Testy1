package testowe.zadaniedomowe;

import java.util.Scanner;
// Napisz program , ktory liczy liczby pierwsze
// , a nastepnie przetestuj go piszac testy jednostkowe
// z wykorzystaniem testow parametryzowanych
// Arguments.of(2, true)
// Arguments.of(10, false)
public class Zadanie1 {
    public static void main(String[] args) {
        int a;
        int b = 1;
        Scanner scannerFirstInt = new Scanner(System.in);
        int c = scannerFirstInt.nextInt();
         int d1 = c/b;
        int  d2 = c/c;
        if (d1 == c && d2 == b){
            System.out.println(c);
            System.out.println("to jest liczba pierwsza");
        }
        else
        System.out.println("to nie jest liczba pierwsza");
    }
}
