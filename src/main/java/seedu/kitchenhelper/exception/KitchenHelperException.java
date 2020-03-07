package seedu.kitchenhelper.exception;

/**
 * Signals that some given data does not fulfill some constraints.
 */
public class KitchenHelperException extends Exception {
    /**
     * Constructor for KitchenHelperException.
     *
     * @param message contain relevant information on the failed constraints.
     */
    public KitchenHelperException(String message) {
        super(message);
    }
}
