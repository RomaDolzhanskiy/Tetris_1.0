package tetris.logic;

import tetris.desktop.MainWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Класс обработчик нажатий кнопок клавиатуры.
 */
public class TetrisKeyAdapter implements KeyListener {

    /**
     * Объект по которому происходит синхронизация потоков.
     */
    MainWindow.Run monitor;

    public TetrisKeyAdapter(MainWindow.Run monitor) {
        this.monitor = monitor;
    }

    /**
     * Переменная значение которой говорит о нажатии кнопки паузы.
     */
    private static boolean isPause = false;

    /**
     * Основной метод обработки нажатий кнопок клавиатуры.
     *
     * @param event нажатие кнопки.
     */
    @Override
    public void keyPressed(KeyEvent event) {

        // если не нажали кнопку "пауза".
        if (monitor.isAlive()) {

            switch (event.getKeyCode()) {
                case KeyEvent.VK_SPACE:

                    // бросается interrupt() для объекта, по которому происходит синхронизация.
                    monitor.interrupt();

                    if (!isPause) {
                        // в основном окне появляется надпись "пауза".
                        MainWindow.pause.setVisible(true);
                        isPause = true;
                    } else {
                        // в основном окне пропадает надпись "пауза".
                        MainWindow.pause.setVisible(false);
                        isPause = false;
                    }
            }
        } else {
            // do nothing
        }

        // если поток, по которому происходит синхронизация, работает и "пауза" нажата.
        if (monitor.isAlive() && !isPause) {
            switch (event.getKeyCode()) {

                case KeyEvent.VK_UP:

                    // движение фигуры по кругу.
                    Mover.сurrentFigure.runFigureRound(monitor);
                    break;
                case KeyEvent.VK_DOWN:

                    // движение фигуры вниз.
                    Mover.сurrentFigure.runFigureDown(monitor);
                    break;
                case KeyEvent.VK_LEFT:

                    // движение фигуры влево.
                    Mover.сurrentFigure.runFigureLeft(monitor);
                    break;
                case KeyEvent.VK_RIGHT:

                    // движение фигуры по вправо.
                    Mover.сurrentFigure.runFigureRight(monitor);
                    break;

            }

        } else {
            switch (event.getKeyCode()) {

                case KeyEvent.VK_ENTER:

                    // Play again

                    break;
            }
        }
    }

    /**
     * Метод ничего не делает.
     * @param event
     */
    @Override
    public void keyReleased(KeyEvent event) {
    }

    /**
     * Метод ничего не делает.
     * @param event
     */
    @Override
    public void keyTyped(KeyEvent event) {
    }
}


