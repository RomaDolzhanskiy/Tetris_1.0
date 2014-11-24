package tetris.desktop;

/**
 * Класс старта программы с единственным методом main.
 */
public class Main {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.newGame();
    }
}
