package messenger;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class Messenger {
    // definiowanie pul
    private MailServer mailServer;
    private TemplateEngine templateEngine;
    // towrzenie kontruktora
    public Messenger(MailServer mailServer , TemplateEngine templateEngine){
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    public void sendMessage(Client client, Template template){
        String message = templateEngine.prepareMessage(template,client);  // okreslamy ze silnik wzwrucil jakas wiaodmosc
        mailServer.send(client.getEmail(), message);

    }
}
