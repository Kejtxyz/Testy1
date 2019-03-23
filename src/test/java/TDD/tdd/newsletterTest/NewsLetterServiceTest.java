package TDD.tdd.newsletterTest;

import TDD.tdd.newsletter.Client;
import TDD.tdd.newsletter.Message;
import TDD.tdd.newsletter.NewsLetterService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NewsLetterServiceTest {

    NewsLetterService newsLetterService = new NewsLetterService();
    Client clientAMock = mock(Client.class, "clientA");
    Client clientBMock = mock(Client.class, "clientB");
    Message messageMock = mock(Message.class);

    @Test
    void subscribedClientShouldReciveMessage(){

        NewsLetterService newsLetterService = new NewsLetterService();
       //  interface
        Client clientMock = mock(Client.class);
        Message messageMock = mock(Message.class);
         // w newsletter najpierw dodajmey subskrybenta,
        newsLetterService.addSubscriber(clientMock);
        newsLetterService.send(messageMock);

        // w kliencie musimy sprawdzic czy zostala wywolana metoda receiveMessage
        verify(clientMock).receiveMessage(messageMock);
    }

    @Test
    void messageShouldBeSendToManySubscribers(){
        // act / when
        newsLetterService.addSubscriber(clientAMock);
        newsLetterService.addSubscriber(clientBMock);
        newsLetterService.send(messageMock);

        // assert / then
        verify(clientAMock).receiveMessage(messageMock);
        verify(clientBMock).receiveMessage(messageMock);
    }


    @Test
    void subscribedClientShouldNotReciveMessage(){
        // wysylamy wiadomosc tylko // subskryebnt-klient jest u gory, - wiadomosc tez,
        newsLetterService.send(messageMock);

        verify(clientAMock, never()).receiveMessage(messageMock);
        verify(clientBMock, never()).receiveMessage(messageMock);

    }


    @Test
    void shouldSendOnlyOneMessageToManySubscribedClients(){
        newsLetterService.addSubscriber(clientAMock);
        newsLetterService.addSubscriber(clientAMock);
        verify(clientAMock, times(1)).receiveMessage(messageMock);  // wynik powinin byc fail
    }
}


// na koniec robimy refactor kodu
//  i sprawdzamy czy test nadal przechodzi