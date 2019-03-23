package PowerMockJunit4;

import org.junit.Before;
import org.junit.Test;   // wersja 4  junit
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import testowe.Person;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)    // rozszerzenie biblioteki extension - run width
public class PowerMockPersonTest {

    private String name = "Adam Nowak";
    private Person person;


    @Before
    public void setUp(){
      person  = new Person(name);
    }


    @Test
    public void constructorShouldSetName() {
      assertEquals("Konstruktor powinin ustawić" + name, name, person.getName());

        // wszystkie metody w junit wersji 4 musza byc publiczne
        assertEquals("KOnstruktor powinnien ustawic Jan Kowalski " ,name, person.getName());
    }

    // testowanie metod prywatnych
    @Test
    public void testHowMuchEarnByPriveMethod() throws Exception {   // exception
      int result =   Whitebox.invokeMethod(person, "howMuchEarn"); // powerMock, w stringu metode ktora bedize testowana
        assertEquals(500, result);
    }


}
