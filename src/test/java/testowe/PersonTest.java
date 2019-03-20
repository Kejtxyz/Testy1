package testowe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class PersonTest {

     Person person = new Person("Jan Kowalski");
     Person spouse = new Person("Alicja Nowak");


    @Test
    void constructorShouldSetName() {


        Assertions.assertEquals("Jan Kowalski", person.getName()); // oczewikana wartosc , i meotde pobierana
    }

    @Test
    void personShouldHaveChild() {
        Person child = new Person("Adam Kowalski");

        person.addChild(child);
        assertNotNull(person.getChildren());
        Assertions.assertEquals(1, person.getChildren().size()); // czy lista jest dlugosci 1 ??// // kolejny sprawdzjacy test// // oczekujue ze lista ma dlugosc 1
    }

    @Test
    void personShouldHaveSpouse() {

        Person lover = new Person("Bartek K");

        person.marriage(spouse);
        person.marriage(lover);

        Assertions.assertNotNull(person.getSpouse(), "Mezem jana kowalskiekgo powinna byc alicja Nowak" +
                ",a obecnie jest Bartek K" + person.getSpouse().getName());
    }

    @Test
    void spouseShouldHaveSpouse() {


        person.marriage(spouse);  //// czy nasz adroga polowka tez ma nas??//// kolejny test//// ta droga osoba powinna miec pierwsza osobe
        Assertions.assertEquals(person, spouse.getSpouse());
    }

    @Test
    void loverShouldNotMarriageMarriedPerson(){  // kochanek nie powiennien wziasc slubu z osoba po slubie

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse); // jan wzial slub z alicja
        lover.marriage(person);
        // sprawdzamy
        assertAll(
                () -> Assertions.assertNull(lover.getSpouse(), lover.getName()+
                        "jest  w zwiazku z" ),
                () -> Assertions.assertEquals(spouse, person.getSpouse())
        );
      //  assertNull(lover.getSpouse());
      //  assertEquals(spouse, person.getSpouse());  // sprawdzamy ,jan kowlaski za zone powinnien miec ciagle alicje nowak
    }
    @Test // czy osoby sa po slubie ze soba
    void personShouldNotBeMarriedWithAnotherOne(){


        person.marriage(spouse);

        Assertions.assertFalse(person.isMarriedWithAnotherPerson(spouse));   // sprawdzamy czy wszystko w ziwazku jest ok?
    }

    @Test   // czy ta 3 osoba kogos nie ma
    void personShouldBeMarriedWithAnotherOne(){

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse);

        Assertions.assertTrue(person.isMarriedWithAnotherPerson(lover)); // sprawdzamy czy jan jest z inna osoba niz bartek
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
    //    testowe.Person person = new testowe.Person("Jan Kowalski");
    //    testowe.Person spouse = new testowe.Person("Alicja Nowak");
        // Act // When
        person.marriage(spouse);
        person.divorce();
        // Assert // Then
        assertNull(spouse.getSpouse());

    }

    @Test
    void personShouldEarnSomeMoney(){  // zarabia pieniadze pierwszy raz
        person.earn(1000);

        assertEquals(1000, person.getMoney());

    }

    @Test
    void personShouldEarnMuchMoney(){  // zarabia pieniadze kolejny raz
        person.earn(1000);
        person.earn(500);

        assertEquals(1500,person.getMoney());
    }
        // sprawdzenie -- wyjatek

        @Test
    void personShouldNotEarnMinusMoney(){
        person.earn(100);
         Exception exception = assertThrows(MinusMoneyException.class,() -> {
            person.earn(-100);
        });
        assertEquals("No minus money", exception.getMessage()); // zarobki nie moga byc ujemne
        }

        @Test
    void personShouldEarnMoneyAfterWork(){
       assertTimeout(Duration.ofMillis(1000), () -> {     // assertTimeoutPreemptively- jesli wykonuje sie za dlugo to konczy,ucina
           person.work(100, 300);          //zwykly assertTimeout metoda czeka do zakonczenia wykonywania metody, i metoda timeout powie o ile czasu za dlugo wykonywala sie metoda,
       });
        // sprawdzamy jak dlugo bedzie wykonywana metoda przy wiekszej sumie
        assertEquals(300, person.getMoney());
        }

        @Test
        // uzywamy gdy chcemy dac warunki
        void testSomethingWithAssume(){
        System.setProperty("ENV", "PROD");
        // test moze sie wykonac dopiero w srodowisku produkcyjnym
        assumeTrue(System.getProperty("ENV").equals("PROD"));
        // ALT + ENTER - import //
        assertTrue(true);
        }

        // testy sprawdzajace - mozna usunac -zrobic refaktor - testy parametryzowane sprawdzja to samo
    @Test
    void emailShouldBeValid1(){
        person.setEmail("jan.kowalski@szkolenie.pl");

        assertTrue(person.isEmailValid());  // powinno zwrocic true
    }
    @Test
    void emailShouldBeValid2(){
        person.setEmail("jan@szkolenie.pl");

        assertTrue(person.isEmailValid());  // powinno zwrocic true
    }
    @Test
    void emailShouldBeValid3(){
        person.setEmail("jaszkolenie.pl");

        assertFalse(person.isEmailValid());  // powinno zwrocic false
    }


    @ParameterizedTest  // przekazujemy tylko prawidlowe testy , // testy poprzednie emaili sa zbedne,mozna usunac,bo ten tez sprawdza emaile
    @ValueSource(strings = {"jan.kowalski@szkolenie.pl","jan@szkolenie.pl","jakie@szkolenie.pl","@jakszolenie.pl" })  // kazda wartosc bedzie wpadala jako argument email, test zostanie uruchomiony tyle razy ile jest przypadkow
    void emailsShouldBeValid(String email){
        person.setEmail(email);

        assertTrue(person.isEmailValid());

    }

    @ParameterizedTest  // przekazujemy tylko prawidlowe testy , // testy poprzednie emaili sa zbedne,mozna usunac,bo ten tez sprawdza emaile
    @ValueSource(strings = {"@szkolenie.pl","jan.I.szkolenie.pl","@szkolenie.pl","@jakszolenie.pl" })  // kazda wartosc bedzie wpadala jako argument email, test zostanie uruchomiony tyle razy ile jest przypadkow
    void emailsShouldNotBeValid(String email){
        person.setEmail(email);

        assertFalse(person.isEmailValid());

    }

    // test parametryzowany z metoda fabrykujaca
    @ParameterizedTest
    @MethodSource(value = "provideValidEmails" )
    void emailsShouldByValidByMethodSource(String email){
        person.setEmail(email);

        assertTrue(person.isEmailValid());   // ma zwrocic true
    }
    // oczekiwanie co zwroci,co ma sprawdzic
    static Stream provideValidEmails(){
        return Stream.of("jan.kowalski@szkolenie.pl","jan@szkolenie.pl","jakie@szkolenie.pl");
    }



    }




