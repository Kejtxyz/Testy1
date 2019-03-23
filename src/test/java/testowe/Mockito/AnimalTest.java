package testowe.Mockito;

import Mockito.Animal;
import Mockito.TooManyTimesHungryException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// ZASADA BIALEJ SKRZYNKI KOD KTORY TESTUJEMY JEST NAM ZNANY !!
public class AnimalTest {
// mock na klase animal
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

    @Test
    void testHungryException(){

        when(animal.isHungry()).thenThrow(TooManyTimesHungryException.class);

        assertThrows(TooManyTimesHungryException.class, () -> {
           animal.isHungry();
        });
    }

    @Test
    void testGoForWalk(){
        animal.goForWalk("PARK");

        verify(animal).goForWalk("PARK");
    }

    @Test
    void testGoForWalk1(){
        animal.goForWalk(anyString());

        verify(animal).goForWalk("PARK");  // verify() metody uzywamy przy void
    }


    @Test
    void testGoForWalk2(){
        animal.goForWalk("park");

        verify(animal).goForWalk(anyString());  // - anyString - oczekujemy konkretnej wartosci
    }


    // obiekt testowany musi istniec, animal
    // inne rzyczy mozemy mockowac



}
