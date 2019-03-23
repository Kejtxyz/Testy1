package testowe.Messenger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import messenger.Client;
import messenger.MailServer;
import messenger.Messenger;
import messenger.TemplateEngine;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MessengerTest {

    @Test
    void shouldSendMessenger(){
        //  dummy //
        Template templateMock = mock(Template.class);
        //  stub  //
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        // mock (spy)
        MailServer mailServer = mock(MailServer.class);
        // stub //
        Client clientMock = mock(Client.class);


        Messenger messenger = new Messenger();

        messenger.sendMessage();

        // weryfikacja

    }
}
