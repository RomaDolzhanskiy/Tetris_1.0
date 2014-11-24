package tetris.desktop;

import tetris.logic.TetrisScore;

import javax.swing.*;
import java.awt.*;

/**
 * Класс в котором создаются элементы правой панели основного окна игры.
 */
public class RightPanelOnWindow {

    /**
     * Экземпляр класса TetrisScore который используется в методе {@code refreshScore();}
     * Метод определяет текущий уровень игры, кол-во очков и максимальное кол-во очков.
     */
    TetrisScore tetrisScore = new TetrisScore();

    /**
     * Фон для текстов программы.
     */
    Font font = new Font("Verdana", Font.BOLD, 14);

    /**
     * Label для вывода количества набранных очков.
     */
    private static JLabel scoreValue = new JLabel();

    /**
     * Label для отображения текущего уровня игры.
     */
    private static JLabel levelValue = new JLabel();

    /**
     * Label для отображения кол-ва максимально набранных очков.
     */
    private static JLabel highScoreValue = new JLabel();

    JLabel label;

    public RightPanelOnWindow(JLabel label) {
        this.label = label;
    }
    public RightPanelOnWindow() {

    }

    /**
     * Метод который добавляет элементы правой панели на основное окно игры.
     * На элемент Label (инициализированный в конструкторе) добавляются элементы правой панели игры.
     */
    public void addRightPanel() {

        // создается, размещается добавляется на панель элемент Next Figure
        JLabel nextFigure = new JLabel("Next Figure");
        nextFigure.setLocation(330, 5);
        nextFigure.setSize(105, 30);
        nextFigure.setVisible(true);
        nextFigure.setFont(font);
        nextFigure.setHorizontalAlignment(SwingConstants.CENTER);
        nextFigure.setForeground(Color.GREEN);
        label.add(nextFigure);

        // создается, размещается добавляется на панель элемент Level
        JLabel level = new JLabel("Level");
        level.setLocation(330, 320);
        level.setSize(105, 30);
        level.setVisible(true);
        level.setFont(font);
        level.setHorizontalAlignment(SwingConstants.CENTER);
        level.setForeground(Color.GREEN);
        label.add(level);

        // создается, размещается и добавляется на панель элемент Score
        JLabel score = new JLabel("Score");
        score.setLocation(330, 390);
        score.setSize(105, 30);
        score.setVisible(true);
        score.setFont(font);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setForeground(Color.GREEN);
        label.add(score);

        // создается, размещается и добавляется на панель элемент High Score
        JLabel highScore = new JLabel("High Score");
        highScore.setLocation(330, 460);
        highScore.setSize(105, 30);
        highScore.setVisible(true);
        highScore.setFont(font);
        highScore.setHorizontalAlignment(SwingConstants.CENTER);
        highScore.setForeground(Color.GREEN);
        label.add(highScore);

        // создается, размещается и добавляется на панель, label для значение элемента High Score
        highScoreValue.setLocation(330, 490);
        highScoreValue.setSize(105, 30);
        highScoreValue.setVisible(true);
        highScoreValue.setFont(font);
        highScoreValue.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreValue.setForeground(Color.GREEN);
        label.add(highScoreValue);

        // создается, размещается и добавляется на панель, label для значение элемента Score
        scoreValue.setLocation(330, 420);
        scoreValue.setSize(105, 30);
        scoreValue.setVisible(true);
        scoreValue.setFont(font);
        scoreValue.setHorizontalAlignment(SwingConstants.CENTER);
        scoreValue.setForeground(Color.GREEN);
        label.add(scoreValue);

        // создается, размещается и добавляется на панель, label для значение элемента Level
        levelValue.setLocation(330, 350);
        levelValue.setSize(105, 30);
        levelValue.setVisible(true);
        levelValue.setFont(font);
        levelValue.setHorizontalAlignment(SwingConstants.CENTER);
        levelValue.setForeground(Color.GREEN);
        label.add(levelValue);

        // добавляется значение элементов scoreValue; levelValue; highScoreValue;
        refreshScore();
    }

    /**
     * Метод для изменения значений элементов scoreValue; levelValue; highScoreValue;
     * Значения высчитываются в классе TetrisScorecore.
     */
    public void refreshScore() {
        scoreValue.setText(String.valueOf(tetrisScore.getScore()));
        levelValue.setText(String.valueOf(tetrisScore.getLevel()));
        highScoreValue.setText(String.valueOf(tetrisScore.gethighScore()));

    }
}
