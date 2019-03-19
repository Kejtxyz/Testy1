import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void constructorShouldSetName() {
        Person person = new Person("Jan Kowalski");

        assertEquals("Jan Kowalski", person.getName()); // oczewikana wartosc , i meotde pobierana
    }

    @Test
    void personShouldHaveChild() {
        Person person = new Person("Jan Kowalski");
        Person child = new Person("Adam Kowalski");

        person.addChild(child);
        assertNotNull(person.getChildren());
        assertEquals(1, person.getChildren().size()); // czy lista jest dlugosci 1 ??// // kolejny sprawdzjacy test// // oczekujue ze lista ma dlugosc 1
    }

    @Test
    void personShouldHaveSpouse() {
        Person person = new Person("Jan Kowalski");
        Person spouse = new Person("Alicja Nowak");
        Person lover = new Person("Bartek K");

        person.marriage(spouse);
        person.marriage(lover);

        assertNotNull(person.getSpouse(), "Mezem jana kowalskiekgo powinna byc alicja Nowak" +
                ",a obecnie jest Bartek K" + person.getSpouse().getName());
    }

    @Test
    void spouseShouldHaveSpouse() {
        Person person = new Person("Jan Kowalski");
        Person spouse = new Person("Alicja Nowak");

        person.marriage(spouse);  //// czy nasz adroga polowka tez ma nas??//// kolejny test//// ta droga osoba powinna miec pierwsza osobe
        assertEquals(person, spouse.getSpouse());
    }

    @Test
    void loverShouldNotMarriageMarriedPerson(){
        Person person = new Person(" Jan Kowalski ");
        Person spouse = new Person(" Alicja Nowak ");
        Person lover = new Person(" Bartek K ");

        person.marriage(spouse); // jan wzial slub z alicja
        lover.marriage(person);
        // sprawdzamy
        assertAll(
                () -> assertNull(lover.getSpouse(), lover.getName()+
                        "jest  w zwiazku z" + lover.getSpouse().getName()),
                () -> assertEquals(spouse, person.getSpouse())
        );
      //  assertNull(lover.getSpouse());
      //  assertEquals(spouse, person.getSpouse());  // sprawdzamy ,jan kowlaski za zone powinnien miec ciagle alicje nowak
    }
    @Test // czy osoby sa po slubie ze soba
    void personShouldNotBeMarriedWithAnotherOne(){
        Person person = new Person("Jan Kowalski");
        Person spouse = new Person("Alicja Nowak");

        person.marriage(spouse);

        assertFalse(person.isMarriedWithAnotherPerson(spouse));   // sprawdzamy czy wszystko w ziwazku jest ok?
    }

    @Test   // czy ta 3 osoba kogos nie ma
    void personShouldBeMarriedWithAnotherOne(){
        Person person = new Person(" Jan Kowalski ");
        Person spouse = new Person(" Alicja Nowak ");
        Person lover = new Person(" Bartek K ");

        person.marriage(spouse);

        assertTrue(lover.isMarriedWithAnotherPerson(person)); // sprawdzamy czy bartek jest z inna osoba
    }



}
// jezeli pierwsza nie przjedzie droga zostanie automatycznie zatrzymana

// poprawic ostatni test // w domu //

