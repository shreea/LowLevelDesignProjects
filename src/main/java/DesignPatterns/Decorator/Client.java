package DesignPatterns.Decorator;

public class Client {

    public static void main(String[] args) {
        INotifier notifier = new WhatsAppDecorator(new Notifier("Shreya"));
        notifier.send("Hello hello");
    }
}
