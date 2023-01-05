package CarRentalSystem.services;

import CarRentalSystem.exceptions.BookingCreationException;
import CarRentalSystem.factory.TotalBookingPriceFactory;
import CarRentalSystem.models.Booking;
import CarRentalSystem.models.enums.BookingStatus;
import CarRentalSystem.models.enums.TotalBookingPriceForVehicleStrategyType;
import CarRentalSystem.repository.BookingRepository;
import CarRentalSystem.strategies.TotalBookingPriceForVehicle.TotalBookingPriceForVehicleStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements PublisherInterface {
    List<SubscriberInterface> subscriberInterfaceList = new LinkedList<>();
    private final TotalBookingPriceFactory totalBookingPriceFactory;
    private final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) throws BookingCreationException {
        try {
            TotalBookingPriceForVehicleStrategy totalBookingPriceForVehicleStrategy = totalBookingPriceFactory.getTotalBookingPriceForVehicleStrategy(TotalBookingPriceForVehicleStrategyType.HOURLY);
            double totalPrice = totalBookingPriceForVehicleStrategy.getTotalBookingPriceForVehicle(booking.getVehicleId());
            booking.setTotalPrice(totalPrice);
            return booking;
        } catch (Exception e) {
            throw new BookingCreationException(e.getMessage(), e);
        }
    }

    public boolean changeBookingStatus(String bookingId, BookingStatus bookingStatus) {
        return bookingRepository.updateStatusForBooking(bookingId, bookingStatus);
    }

    @Override
    public void register(SubscriberInterface subscriber) {
        subscriberInterfaceList.add(subscriber);
    }

    @Override
    public void deregister(SubscriberInterface subscriberInterface) {
        subscriberInterfaceList.remove(subscriberInterface);
    }

    @Override
    public void notifySubscribers() {
        subscriberInterfaceList.forEach(SubscriberInterface::notifySubscriber);
    }

}
