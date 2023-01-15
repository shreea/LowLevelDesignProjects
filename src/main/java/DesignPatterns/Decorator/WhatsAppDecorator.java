package DesignPatterns.Decorator;

public class WhatsAppDecorator extends BaseNotifierDecorator{
    WhatsAppDecorator(INotifier wrapped) {
        super(wrapped);
    }
    @Override
    public void send(String message) {
        super.send(message);
        String phoneNumber = databaseService.getPhoneNumberFromUsername(getUsername());
        System.out.println("Sending " + message + " using " + phoneNumber);
    }
}
