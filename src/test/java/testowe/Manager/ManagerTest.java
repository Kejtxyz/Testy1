package testowe.Manager;

import menager.Database;
import menager.Network;
import menager.UserManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testowe.Person;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ManagerTest {
    // czy majac jakies pola,obiekty, mocki,
    // czy jakies czynnosci zostana wywolane na bazie danych
    String email = "Jan.kowalski@wp.pl";  // DUMMY ,tylklo musi istniec, nie ma interreakcji z nim nigdzie pozniej
    // mockowanie na dwa sposoby , @Mock albo  Person userMock = mock(Person.class);
    @Mock
    Database databaseMock;
    @Mock
    Network networkMock;
    //  Database databaseMock = mock(Database.class);    to smao co @Mock
  //  Network networkMock = mock(Network.class);

    @InjectMocks  // wstrzykuje mocki do menagera
    UserManager userManager;

    Person userMock = mock(Person.class);

    //UserManager userManager = new UserManager(databaseMock, networkMock);

    // sprawdza czy uzytkownikowi udalo sie zalogowacł


    @Test
    void loginSuccess() {
        when(userMock.getEmail()).thenReturn(email);

        boolean result = userManager.login(userMock);

        assertTrue(result);
        assertEquals(userMock, userManager.getUser());  // przypisany uzytkownik zostal przypisany do kontruktora
        verify(databaseMock).save(userMock);
        verify(networkMock).upload(userMock);  // verify sprawdzamy czy metoda sie uruchomila

    }

    @Test
    void loginFailure() {
        Person user = null;

        boolean result = userManager.login(user);

        assertFalse(result);
        verify(databaseMock, never()).save(user);
        verify(networkMock, never()).upload(user);
    }


    ////    F A K E    ////
    // fake - operujemy na zlozonych obiektach, wiekszej ilosci obiektow
    // np, filmy, rezyser,autor, tytul, a stub np,imie rezysera
    // np, getUser.cars

    String[][] fake = {
            {"Ople", "Astra", "2.0", "5-osobowy"},
            {"Fiat", "Punto", "1.5", "5-osobowy"},
            {"Ford", "Focus", "1.8", "5-osobowy"},
            {"Audi", "TT", "3.0", "5-osobowy"},
            {"Ford", "Focus", "1.8", "5-osobowy"},
    };


}

