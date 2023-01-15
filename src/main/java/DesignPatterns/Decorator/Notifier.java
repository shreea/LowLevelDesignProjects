package DesignPatterns.Decorator;

public class Notifier implements INotifier{
    private final String userName;
    protected final DatabaseService databaseService;

    public Notifier(String userName) {
        this.userName = userName;
        databaseService = new DatabaseService();
    }

    public void send(String msg) {
        String mail = databaseService.getNameFromUsername(userName);
        System.out.println("Sending mail to : " + mail);
    }

    @Override
    public String getUsername() {
        return userName;
    }

}
