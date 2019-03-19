import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Person spouse;
    private List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        // przypisujemy konstruktor od zmiennej lokalnej
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
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
    // metoda pomocnicza
// czy jest z inna osoba?
    public boolean isMarriedWithAnotherPerson(Person personToCheck) {
        if (spouse == null) {
            return true;
        } // czy osoby sa sobie rowne??
        if(personToCheck.getSpouse().equals(this)){
            return false;  // jezeli sa rowni
        }else {
            return true;
        } // jezeli nie sa rowni ,ta sa w innym zwiazku
        }
    }

// CTRL + L   - UKLADA KOD
