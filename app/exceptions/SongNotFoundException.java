package exceptions;

/**
 * @author Marlon Kewaldar
 * Class representing an exception that will be thrown if a song isn't found based on its IDs
 */
@SuppressWarnings("ALL")
class SongNotFoundException extends Exception {
    @SuppressWarnings("unused")
    public SongNotFoundException() {
        super("The current song wasn't found. Please reload the page.");
    }

    @SuppressWarnings("unused")
    public SongNotFoundException(String message) {
        super(message);
    }

    @SuppressWarnings("unused")
    public SongNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @SuppressWarnings("unused")
    public SongNotFoundException(Throwable cause) {
        super(cause);
    }

    @SuppressWarnings("unused")
    public SongNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
