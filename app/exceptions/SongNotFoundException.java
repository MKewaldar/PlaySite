package exceptions;

/**
 * @author Marlon Kewaldar
 * Class representing an exception that will be thrown if a song isn't found based on its IDs
 */
public class SongNotFoundException extends Exception {
    public SongNotFoundException() {
    }

    public SongNotFoundException(String message) {
        super(message);
    }

    public SongNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SongNotFoundException(Throwable cause) {
        super(cause);
    }

    public SongNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
