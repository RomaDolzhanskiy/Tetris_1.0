package tetris.logic;

/**
 * Exception для уведомления о завершении игры.
 */
public class GameOverException extends Exception {
    public GameOverException(String text) {
        super(text);
    }
}