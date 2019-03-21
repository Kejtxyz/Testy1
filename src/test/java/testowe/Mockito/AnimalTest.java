package testowe.Mockito;

import Mockito.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

// ZASADA BIALEJ SKRZYNKI KOD KTORY TESTUJEMY JEST NAM ZNANY !!
public class AnimalTest {

    @Test
    void testName() {
        Animal animal = mock(Animal.class);  // nasz mock , czy ta wartosc zostanie przyporzadkowana do nazwy pimpus??

        assertEquals("Pimpuś", animal.getName());// aktualnie jest null
    }
}
