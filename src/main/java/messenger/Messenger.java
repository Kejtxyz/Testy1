package messenger;

public class Messenger {
    // definiowanie pul
    private MailServer mailServer;
    private TemplateEngine templateEngine;
    // towrzenie kontruktora
    public Messenger(MailServer mailServer , TemplateEngine templateEngine){
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    public void sendMessage(){

    }
}
