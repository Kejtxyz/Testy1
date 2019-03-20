import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person;
    Person spouse;

    @BeforeEach
    void setUp(){
        // np, obiekty
        // przed kazdym testem bedzie tworozny obiekt person
        person = new Person("Jan Kowalski");
        spouse = new Person("Alicja Nowak");
    }

    @Test
    void constructorShouldSetName() {


        assertEquals("Jan Kowalski", person.getName()); // oczewikana wartosc , i meotde pobierana
    }

    @Test
    void personShouldHaveChild() {
        Person child = new Person("Adam Kowalski");

        person.addChild(child);
        assertNotNull(person.getChildren());
        assertEquals(1, person.getChildren().size()); // czy lista jest dlugosci 1 ??// // kolejny sprawdzjacy test// // oczekujue ze lista ma dlugosc 1
    }

    @Test
    void personShouldHaveSpouse() {

        Person lover = new Person("Bartek K");

        person.marriage(spouse);
        person.marriage(lover);

        assertNotNull(person.getSpouse(), "Mezem jana kowalskiekgo powinna byc alicja Nowak" +
                ",a obecnie jest Bartek K" + person.getSpouse().getName());
    }

    @Test
    void spouseShouldHaveSpouse() {


        person.marriage(spouse);  //// czy nasz adroga polowka tez ma nas??//// kolejny test//// ta droga osoba powinna miec pierwsza osobe
        assertEquals(person, spouse.getSpouse());
    }

    @Test
    void loverShouldNotMarriageMarriedPerson(){  // kochanek nie powiennien wziasc slubu z osoba po slubie

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse); // jan wzial slub z alicja
        lover.marriage(person);
        // sprawdzamy
        assertAll(
                () -> assertNull(lover.getSpouse(), lover.getName()+
                        "jest  w zwiazku z" ),
                () -> assertEquals(spouse, person.getSpouse())
        );
      //  assertNull(lover.getSpouse());
      //  assertEquals(spouse, person.getSpouse());  // sprawdzamy ,jan kowlaski za zone powinnien miec ciagle alicje nowak
    }
    @Test // czy osoby sa po slubie ze soba
    void personShouldNotBeMarriedWithAnotherOne(){


        person.marriage(spouse);

        assertFalse(person.isMarriedWithAnotherPerson(spouse));   // sprawdzamy czy wszystko w ziwazku jest ok?
    }

    @Test   // czy ta 3 osoba kogos nie ma
    void personShouldBeMarriedWithAnotherOne(){

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse);

        assertTrue(person.isMarriedWithAnotherPerson(lover)); // sprawdzamy czy jan jest z inna osoba niz bartek
    }

    @Test
    void personShouldNotHaveSpouseAfterDivorce(){

        person.marriage(spouse);
        person.divorce();

        assertNull(person.getSpouse());
    }

    @Test
    void spouseShouldNotHaveSpouseAfterDivorce() {
        // Arrange // Given
    //    Person person = new Person("Jan Kowalski");
    //    Person spouse = new Person("Alicja Nowak");
        // Act // When
        person.marriage(spouse);
        person.divorce();
        // Assert // Then
        assertNull(spouse.getSpouse());

    }



    }
// jezeli pierwsza nie przjedzie droga zostanie automatycznie zatrzymana



