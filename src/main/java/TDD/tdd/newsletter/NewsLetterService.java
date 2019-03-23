package TDD.tdd.newsletter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsLetterService {

   // refactor kodu Client robimy liste clientow
    private Set<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
     for(Client client : clients){
         client.receiveMessage(message);
     }

        //  client.receiveMessage(message);
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
