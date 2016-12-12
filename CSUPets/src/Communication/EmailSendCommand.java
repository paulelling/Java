package Communication;

public class EmailSendCommand implements Command {
    Email email;
    
    public EmailSendCommand(Email email) {
        this.email = email;
    }
    
    public void execute() {
        email.send();
    }    
}
