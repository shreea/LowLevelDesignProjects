package CarRentalSystem.exceptions;

public class BookingCreationException extends Exception{

    public BookingCreationException(String message, Throwable err) {
        super(message, err);
    }
}
