package testowe.Mockito;

import Mockito.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// ZASADA BIALEJ SKRZYNKI KOD KTORY TESTUJEMY JEST NAM ZNANY !!
public class AnimalTest {

    Animal animal = mock(Animal.class);  // nasz mock , czy ta wartosc zostanie przyporzadkowana do nazwy pimpus??

    @Test
    void testName() {


        when(animal.getName()).thenReturn("Pimpuś"); // jezeli kto kolwiek wywola metode getName pimpus, to zwroci true !

      //  when(animal.getName()).thenReturn("Kajtek"); //  false
        assertEquals("Pimpuś", animal.getName());// aktualnie jest null
    }

    @Test
    void testWeight(){
        when(animal.getWeight()).thenReturn(10);

        assertEquals(10,animal.getWeight());
    }

    @Test
    void testHunger(){
        when(animal.isHungry()).thenReturn(true);

        assertTrue(animal.isHungry());
    }




}
