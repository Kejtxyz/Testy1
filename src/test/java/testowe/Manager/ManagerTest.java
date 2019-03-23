package testowe.Manager;

import menager.Database;
import menager.Network;
import menager.UserManager;
import org.junit.jupiter.api.Test;
import testowe.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ManagerTest {

    @Test
    void loginSuccess() {
        // czy majac jakies pola,obiekty, mocki,
        // czy jakies czynnosci zostana wywolane na bazie danych
        String email = "Jan.kowalski@wp.pl";
        Database databaseMock = mock(Database.class);
        Network networkMock = mock(Network.class);
        Person userMock = mock(Person.class);

        UserManager userManager = new UserManager(databaseMock, networkMock);
        // sprawdza czy uzytkownikowi udalo sie zalogowac

        when(userMock.getEmail()).thenReturn(email);

        boolean result = userManager.login(userMock);

        assertTrue(result);
        assertEquals(userMock, userManager.getUser());  // przypisany uzytkownik zostal przypisany do kontruktora
        verify(databaseMock).save(userMock);
        verify(networkMock).upload(userMock);

    }

    ////    F A K E    ////
    // fake - operujemy na zlozonych obiektach, wiekszej ilosci obiektow
    // np, filmy, rezyser,autor, tytul, a stub np,imie rezysera
    // np, getUser.cars

    String[][] fake = {
        {"Ople","Astra","2.0","5-osobowy"},
        {"Fiat","Punto","1.5","5-osobowy"},
        {"Ford","Focus","1.8","5-osobowy"},
        {"Audi","TT","3.0","5-osobowy"},
        {"Ford","Focus","1.8","5-osobowy"},
    }
}
