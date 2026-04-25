package exceptions;

public class InvalidSelectionException extends Exception {

    public InvalidSelectionException() {
        super("Please select both an order and a courier.");
    }

    public InvalidSelectionException(String message) {
        super(message);
    }
}