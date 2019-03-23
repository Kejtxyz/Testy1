package testowe.messenger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
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

        Messenger messenger = new Messenger();

        messenger.sendMessage();

        // weryfikacja

    }
}
