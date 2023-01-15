package DesignPatterns.Decorator;

public class BaseNotifierDecorator implements INotifier{
    private final INotifier wrapped;
    protected final DatabaseService databaseService;

    BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        databaseService = new DatabaseService();
    }
    @Override
    public void send(String message) {
        wrapped.send(message);
    }
    @Override
    public String getUsername() {
        return wrapped.getUsername();
    }
}
