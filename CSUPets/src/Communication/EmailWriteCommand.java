package Communication;

public class EmailWriteCommand implements Command {
    Email email;
    
    public EmailWriteCommand(Email email) {
        this.email = email;
    }
    
    public void execute() {
        email.write();
    }    
}
