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
        network.upload(user);
        database.save(user);

        this.user = user;

        return true ;
    }



}
