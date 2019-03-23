package testowe;

import Mockito.Animal;
import com.sun.istack.internal.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.stream.Stream;

import static jdk.internal.dynalink.support.Guards.isNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.*;

// testow sie nie dokumentuje
// nazwa testu ma mowic od czego jest , i sprawdza czy kod jest prawidlowy
public class PersonTest {
// tworzenie obiektu
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
    void loverShouldNotMarriageMarriedPerson() {  // kochanek nie powiennien wziasc slubu z osoba po slubie

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse); // jan wzial slub z alicja
        lover.marriage(person);
        // sprawdzamy
        assertAll(
                () -> Assertions.assertNull(lover.getSpouse(), lover.getName() +
                        "jest  w zwiazku z"),
                () -> Assertions.assertEquals(spouse, person.getSpouse())
        );
        //  assertNull(lover.getSpouse());
        //  assertEquals(spouse, person.getSpouse());  // sprawdzamy ,jan kowlaski za zone powinnien miec ciagle alicje nowak
    }

    @Test
        // czy osoby sa po slubie ze soba
    void personShouldNotBeMarriedWithAnotherOne() {


        person.marriage(spouse);

        Assertions.assertFalse(person.isMarriedWithAnotherPerson(spouse));   // sprawdzamy czy wszystko w ziwazku jest ok?
    }

    @Test
        // czy ta 3 osoba kogos nie ma
    void personShouldBeMarriedWithAnotherOne() {

        Person lover = new Person(" Bartek K ");

        person.marriage(spouse);

        Assertions.assertTrue(person.isMarriedWithAnotherPerson(lover)); // sprawdzamy czy jan jest z inna osoba niz bartek
    }

    @Test
    void personShouldNotHaveSpouseAfterDivorce() {

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
    void personShouldEarnSomeMoney() {  // zarabia pieniadze pierwszy raz
        person.earn(1000);

        assertEquals(1000, person.getMoney());

    }

    @Test
    void personShouldEarnMuchMoney() {  // zarabia pieniadze kolejny raz
        person.earn(1000);
        person.earn(500);

        assertEquals(1500, person.getMoney());
    }
    // sprawdzenie -- wyjatek

    @Test
    void personShouldNotEarnMinusMoney() {
        person.earn(100);
        Exception exception = assertThrows(MinusMoneyException.class, () -> {
            person.earn(-100);
        });
        assertEquals("No minus money", exception.getMessage()); // zarobki nie moga byc ujemne
    }

    @Test
    void personShouldEarnMoneyAfterWork() {
        assertTimeout(Duration.ofMillis(1000), () -> {     // assertTimeoutPreemptively- jesli wykonuje sie za dlugo to konczy,ucina
            person.work(100, 300);          //zwykly assertTimeout metoda czeka do zakonczenia wykonywania metody, i metoda timeout powie o ile czasu za dlugo wykonywala sie metoda,
        });
        // sprawdzamy jak dlugo bedzie wykonywana metoda przy wiekszej sumie
        assertEquals(300, person.getMoney());
    }

    @Test
        // uzywamy gdy chcemy dac warunki
    void testSomethingWithAssume() {
        System.setProperty("ENV", "PROD");
        // test moze sie wykonac dopiero w srodowisku produkcyjnym
        assumeTrue(System.getProperty("ENV").equals("PROD"));
        // ALT + ENTER - import //
        assertTrue(true);
    }

    // testy sprawdzajace - mozna usunac -zrobic refaktor - testy parametryzowane sprawdzja to samo
    @Test
    void emailShouldBeValid1() {
        person.setEmail("jan.kowalski@szkolenie.pl");

        assertTrue(person.isEmailValid());  // powinno zwrocic true
    }

    @Test
    void emailShouldBeValid2() {
        person.setEmail("jan@szkolenie.pl");

        assertTrue(person.isEmailValid());  // powinno zwrocic true
    }

    @Test
    void emailShouldBeValid3() {
        person.setEmail("jaszkolenie.pl");

        assertFalse(person.isEmailValid());  // powinno zwrocic false
    }


    @ParameterizedTest
    // przekazujemy tylko prawidlowe testy , // testy poprzednie emaili sa zbedne,mozna usunac,bo ten tez sprawdza emaile
    @ValueSource(strings = {"jan.kowalski@szkolenie.pl", "jan@szkolenie.pl", "jakie@szkolenie.pl", "@jakszolenie.pl"})
        // kazda wartosc bedzie wpadala jako argument email, test zostanie uruchomiony tyle razy ile jest przypadkow
    void emailsShouldBeValid(String email) {
        person.setEmail(email);

        assertTrue(person.isEmailValid());

    }

    @ParameterizedTest
    // przekazujemy tylko prawidlowe testy , // testy poprzednie emaili sa zbedne,mozna usunac,bo ten tez sprawdza emaile
    @ValueSource(strings = {"@szkolenie.pl", "jan.I.szkolenie.pl", "@szkolenie.pl", "@jakszolenie.pl"})
        // kazda wartosc bedzie wpadala jako argument email, test zostanie uruchomiony tyle razy ile jest przypadkow
    void emailsShouldNotBeValid(String email) {
        person.setEmail(email);

        assertFalse(person.isEmailValid());

    }

    // test parametryzowany z metoda fabrykujaca
    @ParameterizedTest
    @MethodSource(value = "provideValidEmails")
    void emailsShouldByValidByMethodSource(String email) {
        person.setEmail(email);

        assertTrue(person.isEmailValid());   // ma zwrocic true
    }


    // oczekiwanie co zwroci,co ma sprawdzic
    static Stream provideValidEmails() {
        return Stream.of("jan.kowalski@szkolenie.pl", "jan@szkolenie.pl", "jakie@szkolenie.pl");
    }


    @ParameterizedTest
    @MethodSource(value = "provideEmails")
    void checkEmailCorrections(String email, boolean expectedValidation) {
        person.setEmail(email);

        assertEquals(expectedValidation, person.isEmailValid(), "Email " + email + "should be : " + expectedValidation);
    }


    // provide - dostarcza cos poprostu, - ,    ale w metodach abstarakcyjnych jest wykorzystywane w wzorcach projektowych
    //  zwraca streama i przechodzi po streamie i jest wykonywany z kazdym argumentem i jest wykonywnay dla kazdego testu z osobna
    static Stream provideEmails() {
        return Stream.of(
                Arguments.of("jan.kowalski@szkolenie.pl", true),
        Arguments.of("jan@szkolenie.pl", true),
        Arguments.of("jakie@szkolenie.pl", false)
        );
    }
// ma wyjsc nie znaleziono pliku
    @ParameterizedTest
    @CsvFileSource(resources = "/emails.csv")
    void checkEmailsCorrectionFromFile(String email, boolean exceptedValidator){
        person.setEmail(email);

        assertEquals(exceptedValidator, person.isEmailValid());
    }

    // Testy parametryzowane z pliku CSV
    @ParameterizedTest
    @CsvSource(value = {"jan.kowalski@szkolenie.p\", true","jakie@szkolenie.pl, false"})
            void checkEmailCorrectionByCsvSource(String email , boolean expectedValidation){
        person.setEmail(email);

        assertEquals(expectedValidation, person.isEmailValid());
    }

    @Test
    void testTwoArgumentsConstrusctor(){
        Person newPerson = new Person("Jan Kowalski", 18);

        assertThat(newPerson.getName())
                .isEqualTo("Jan Kowalski")
                .isEqualToIgnoringCase("jan kowalski")
                 .isNotNull();

        assertThat(newPerson.getAge())
        .isEqualTo(18)
        .isLessThan(20)
        .isGreaterThan(10)
        .isBetween(0,100);
    }



    //***   mockito ****//


    @Test
    void personShouldGoForWalkWithAnimal() {
        //arrange / given
        Animal animalMock = mock(Animal.class);
        //zdefiniowanie wartosci
        long time = 100;
        int cash = 40;
        String place = "PARK";

        // act/ when
        person.workForWalk(100, 40, animalMock, "PARK");
        when(animalMock.isHungry()).thenThrow(Exception.class);

        // assert  / then
        verify(animalMock).goForWalk("PARK");  //  sprawdzamy czy poszla na spacer
        assertEquals(40, person.getMoney());  // sprawdzamy czy zarobia osoba
    }

    @Test
    void setSpouseCheatingOnPerson() {
        // arrange / given
        Person newSpouseMock = mock(Person.class);
        // act / when
        person.marriage(newSpouseMock);   // czy osoba wychodzi za nowego malzonka
        //   when(newSpouseMock.isMarriedWithAnotherPerson(person)).thenReturn(true);  // jesli metoda byla by nie implementowana, to asssertem mozemy sprawdzic czy istnieje

        // assert  /  then
        verify(newSpouseMock).marriage(person);
        assertFalse(newSpouseMock.isMarriedWithAnotherPerson(person));
    }
    
}










