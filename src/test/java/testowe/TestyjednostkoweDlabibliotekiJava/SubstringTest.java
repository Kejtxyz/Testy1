package testowe.TestyjednostkoweDlabibliotekiJava;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.VoidDescriptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringTest {

    String string = "Dzban";

    @Test
    void shouldReturnFirstCharacter() {
        // stworzyc substring
        String result = string.substring(0, 1);

        assertEquals("D", result);
        assertThat(result)
                .isEqualTo("D")
                .isEqualToIgnoringCase("d")
                .hasSize(1);
    }

    @Test
    void shouldReturnBanWord() {
        String result2 = string.substring(2, string.length());

        assertEquals("ban", result2);
    }

    @Test
    void shouldReturnLastcharacter() {
        String result = string.substring(4, 5);

        assertEquals("n", result);
    }

    @Test
    void shouldNotReturnAnyCharacter() {
        String result = string.substring(0, 0);  // poaczatkowy indeks wezmie 0 ,i odejmie tez 0, wiec wychodzi 0, i w tescie wychodzi wartosc 0,

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldBeTheSame(){
        String result = string.substring(0, 5);  // powiennien zwrocic caly string  ,5 lub length- dlugosc i tez dziala prawidlowo

        assertEquals(string, result);
    }

    @Test
    void stringShouldBeNull(){
        String stringNull = null;

        assertThrows(NullPointerException.class, () -> {stringNull.substring(0, 2);
        });
    }

    @Test
    void stringShouldBeNullB(){
        String stringNull = null;  // jesli bedzie null - tekst "aaa" to zlapie try, i bedzie fail,test nie wukaze blad

        try{
            stringNull.substring(0,2);
            fail();
        }catch(NullPointerException e){
            System.out.println("Wpadlo nam tutaj");
        }



    }





}

