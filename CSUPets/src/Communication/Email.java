package Communication;

public class Email {
    private String fromName;
    private String fromAddress;
    private String toName;
    private String toAddress;
    private String subject;
    private String body;
    
    public Email(String fromName, String fromAddress, String toName, String toAddress, String subject, String body) {
        this.fromName = fromName;
        this.fromAddress = fromAddress;
        this.toName = toName;
        this.toAddress = toAddress;
        this.subject = subject;
        this.body = body;
    }
    
    public void write() {
    }
    
    public void send() {
    }
}
