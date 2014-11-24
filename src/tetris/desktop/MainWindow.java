package tetris.desktop;

import tetris.logic.GameOverException;
import tetris.logic.Mover;
import tetris.logic.TetrisKeyAdapter;

import javax.swing.*;
import java.awt.*;

/**
 * Класс, где определенно основное окно программы. Наследник JFrame.
 * Так же присутствует вложенный класс наследник Thread,
 * в котором метод run создает фигуру и начинает ее движение.
 */
public class MainWindow extends JFrame {

    /**
     * Иконка программы.
     */
    ImageIcon icon = new ImageIcon("src\\image\\images.jpg");

    /**
     * Основная панель программы на которую добавляются все элементы.
     */
    JLabel label = new JLabel(new ImageIcon("src\\image\\Fon.png"));

    /**
     * Label для оповещения об остановке игры при нажатии паузы.
     */
    public static JLabel pause = new JLabel("Для старта нажмите ПРОБЕЛ");

    /**
     * Label для оповещения об завершении игры.
     */
    public static JLabel gameOver = new JLabel("Game over");

    /**
     * Фон для текстов программы.
     */
    Font font = new Font("Verdana", Font.BOLD, 14);

    /**
     * Экземпляр класса Run для создания и запуска нового потока, в котором создаются и начинают движение основные фигуры.
     */
    Run run = new Run();

    public Run getRun() {
        return run;
    }

    /**
     * Метод, который создает основное окно программы.
     * На основную панель программы добавляется правая панель с результатами игры и следующими фигурами.
     * Создается новый поток, в котором создаются и начинают движение основные фигуры.
     */
    public void newGame() {

        // Создается окно программы, указываются его размеры, расположение и поведение.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocation(600, 50);
        setSize(450, 599);
        setTitle("Tetris");
        setIconImage(icon.getImage());

        // Основная Label на которую размещаются все элементы добавляется в окно программы,
        // определяется ее размер и расположение.
        label.setLocation(0, 0);
        label.setSize(444, 570);
        label.setVisible(true);
        add(label);

        // На основное окно добавляется слушатель событий клавиатуры.
        addKeyListener(new TetrisKeyAdapter(getRun()));

        // На основную Label добавляется label которая появится при нажатии паузы.
        // Определяется ее размер, расположение и стиль текста.
        // По умолчанию ее не видно.
        pause.setLocation(0, 50);
        pause.setSize(330, 30);
        pause.setFont(font);
        pause.setHorizontalAlignment(SwingConstants.CENTER);
        pause.setForeground(Color.GREEN);
        pause.setVisible(false);
        label.add(pause);

        // На основную Label добавляется label которая появится при завершении игры.
        // Определяется ее размер, расположение и стиль текста.
        // По умолчанию ее не видно.
        gameOver.setLocation(0, 80);
        gameOver.setSize(330, 30);
        gameOver.setFont(font);
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setForeground(Color.GREEN);
        gameOver.setVisible(false);
        label.add(gameOver);

        // На основную Label добавляется правая панель.
        new RightPanelOnWindow(label).addRightPanel();


        // Создается и запускается новый поток, который создает и приводит в движение основные фигуры.
        Thread thread = getRun();
        thread.start();

    }

    /**
     * Класс наследник Thread, предназначен для создания нового потока
     * в котором единственный метод run, где создаются и приводятся в движение основные фигуры игры.
     */
    public class Run extends Thread {

        /**
         * Метод run в котором создаются и приводятся в движение основные фигуры игры.
         */
        public void run() {
            try {
                while (true) {
                    // создается экземпляр Mover, и вызывается метод {@code createAndRunFigure();}
                    // который создает и приводит в движение основные фигуры игры.
                    Mover mover = new Mover(getRun());
                    mover.createAndRunFigure(label);
                }
            } catch (GameOverException gameOverException) {

                // если ловим exception то поток завершает свою работу, game over!
            }

        }
    }

}