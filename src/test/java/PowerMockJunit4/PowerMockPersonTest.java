package PowerMockJunit4;


import org.junit.Test;   // wersja 4  junit
import testowe.Person;

import static org.junit.Assert.assertEquals;

public class PowerMockPersonTest {

    @Test
    public void constructorShouldSetName() {
        String name = "Jan Kowalski";
        Person person = new Person(name);
        // wszystkie metody w junit wersji 4 musza byc publiczne
        assertEquals("KOnstruktor powinnien ustawic Jan Kowalski " ,name, person.getName());
    }

}
