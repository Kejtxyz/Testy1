package testowe;

import Mockito.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Person {
    private int age;
    private String name;
    private Person spouse;  // spouse - małżonek
    private List<Person> children = new ArrayList<>();



    private int money;  // osoba bedzie zarabiac, nastepnie dodatemy getter

    private String email; // tworzymy email osobie person ..// towrymy setter i getter

    private String regex = "^(.+)@.(.+)$";  // ( - czego sie tyczy ^-poczatkowy wyraz   $co jest pod nim (.+)sprawdza czy jest jaki kolwiek znak   @czy jest miedzy wyrazami
    Pattern pattern = Pattern.compile(regex);  // sprawdza czy pasuje pod nasz wzor , regex = wyrazenie regularne

    // ALT + Insert //
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }







    public Person(String name) {
        this.name = name;
        // przypisujemy konstruktor od zmiennej lokalnej
    }


    ////
    public Person(String name, int age){
     //   this.name = name;
        this(name);
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public int getAge() {return  age;}

    public Person getSpouse() {
        return spouse;
    }

    public int getMoney(){  // pobieranie geeter , piniedzy
        return money;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void marriage(Person newPersonInMyLife) {
        if (spouse == null && !newPersonInMyLife.isMarriedWithAnotherPerson(this)) {  // jesli jest z inna osoba, bedzie true, w innym przypadku to nie prawda -negacja !
            this.spouse = newPersonInMyLife;
            spouse.marriage(this);
        }
    }

    public void divorce() {  // rekurencja - odwolywanie funkcji do samej siebie
        Person ex = this.spouse;   // byly(A)
        this.spouse = null;

        if (ex.getSpouse() != null) {
            ex.divorce();
        }
    }

    // metoda pomocnicza
// czy jest z inna osoba?
    public boolean isMarriedWithAnotherPerson(Person personToCheck) {
        if (spouse == null) {
            return false;
        } // czy osoby sa sobie rowne??
        if (!spouse.equals(personToCheck)) {
            return true;  // jezeli sa razem
        } else {
            return false;
        } // jezeli nie sa rowni ,ta sa w innym zwiazku
    }


    public void earn(int cash) {
        // sprawdzenie, nie mozna zarobic ujemnych pieniedzy
        if (cash < 0){
            throw new MinusMoneyException("No minus money");
        }
        //   money = money + cash;
        money += cash;
    }
    // jak dlugo pracuje
    // ile pieniedzy otrzyma za wykonana prace
    public void work(long time, int cash) {
     try{
        Thread.sleep(time);
        earn(cash);
    }catch (InterruptedException exception){ // nazwa zmiennej e moze byc inna e - jest domyslnie e  to samo co exception, nazwa tylko
         exception.printStackTrace(); // nastepnie do tego dopisujemy test
     }

    }
    public boolean isEmailValid(){
        return pattern.matcher(email).matches();  // matches - sprawdza czy email jest zgodny z wyrazeniem regularnym, czy bedzie jakis znak na poacztku,czy bedzie malpa@
    }



    public void workForWalk(long time , int cash, Animal animal, String place){   // zwierzatka idzie do jakiegos miejsca na spacer
       animal.goForWalk(place);
        work(time, cash);
    }

}
// CTRL + L   - UKLADA KOD
