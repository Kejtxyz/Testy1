package testowe.messenger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import messenger.Messenger;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MessengerTest {

    @Test
    void shouldSendMessenger(){
        // dummy //
        Template templateMock = mock(Template.class);
        Messenger messenger = new Messenger();

        messenger.sendMessage();

        // weryfikacja

    }
}
