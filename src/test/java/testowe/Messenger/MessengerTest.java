package testowe.Messenger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import messenger.Client;
import messenger.MailServer;
import messenger.Messenger;
import messenger.TemplateEngine;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MessengerTest {

    @Test
    void shouldSendMessenger(){
        String messenge = "czesc,jan kowlaski, co tam u was?";
        String email = " email@email.pl" ;
        //  dummy //
        Template templateMock = mock(Template.class);
        //  stub  //
        TemplateEngine templateEngineMock = mock(TemplateEngine.class);
        // mock (spy)
        MailServer mailServerMock = mock(MailServer.class);
        // stub //
        Client clientMock = mock(Client.class);

        Messenger messenger = new Messenger(mailServerMock, templateEngineMock);

        when(templateEngineMock.prepareMessage(templateMock, clientMock)).thenReturn(messenge);
        when(clientMock.getEmail()).thenReturn(email);

        messenger.sendMessage(clientMock, templateMock);

        verify(mailServerMock).send(email, messenge);

        messenger.sendMessage(clientMock, templateMock);

        verify(mailServerMock).send(email, messenge);
    }
}
