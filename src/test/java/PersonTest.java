import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    void constructorShouldSetName(){
        Person person = new Person("Jan Kowalski");

        assertEquals("Jan Kowalski", person.getName()); // oczewikana wartosc , i meotde pobierana
    }
}
