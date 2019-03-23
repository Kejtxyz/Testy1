package TDD.tdd.newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsLetterService {

   // refactor kodu Client robimy liste clientow
    private List<Client> clients = new ArrayList<>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
     for(Client client : clients){
         client.receiveMessage(message);
     }

        //  client.receiveMessage(message);
    }
}
