package tetris.logic;

/**
 * Exception для уведомления о запрете движения фигуры.
 */
public class MovingBeyondException extends Exception {
    public MovingBeyondException(String text) {
        super(text);
    }
}
