package menager;

import testowe.Person;

public class UserManager {

    private Person user;
    private Database database;
    private Network network;

    public UserManager(Database database, Network network) {
        this.database = database;
        this.network = network;
    }

    public boolean login(Person user){
        network.upload(user);  // mozna zweryfikowac czy zostaly uruchomione, czy user zostal przypisnay do konstruktora w tescie
        database.save(user);

        this.user = user;

        return true ;
    }

    public Person getUser(){
        return this.user;
    }



}
