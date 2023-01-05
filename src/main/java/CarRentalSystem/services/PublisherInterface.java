package CarRentalSystem.services;

public interface PublisherInterface {
    void register(SubscriberInterface subscriber);

    void deregister(SubscriberInterface subscriberInterface);

    void notifySubscribers();
}
