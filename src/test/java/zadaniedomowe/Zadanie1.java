package zadaniedomowe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Napisz program , ktory liczy liczby pierwsze , a nastepnie przetestuj go piszac testy jednostkowe z wykorzystaniem testow parametryzowanych
// Arguments.of(2, true)
// Arguments.of(10, false)
public class Zadanie1 {
    Zadanie1 c = new Zadanie1();
    private List<Zadanie1> children = new ArrayList<>();



// test parametryzujacy
    @ParameterizedTest
    @ValueSource(ints = {4,7,5})
    private void assertEquals(int c) {
        System.out.println(c);

        assertEquals(c);
    }

}

