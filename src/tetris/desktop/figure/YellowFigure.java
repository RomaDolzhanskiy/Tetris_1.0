package tetris.desktop.figure;


import tetris.desktop.MainWindow;

import javax.swing.*;

/**
 * Обект YellowFigure, одна из семи основных фигур игры. Наследуется от Figure.
 */
public class YellowFigure extends Figure {

    /**
     * Иконка для кубиков фигуры желтого цвета.
     */
    private ImageIcon icon = new ImageIcon("src\\image\\Yellow.jpg");

    /**
     * Кубики с которых состоит фигура.
     */
    private JLabel square1 = new JLabel(icon);
    private JLabel square2 = new JLabel(icon);
    private JLabel square3 = new JLabel(icon);
    private JLabel square4 = new JLabel(icon);

    public YellowFigure() {
        // Инициализируются элементы класса потомка.
        super.square1 = square1;
        super.square2 = square2;
        super.square3 = square3;
        super.square4 = square4;
    }

    /**
     * Метод создает фигуру, на которой он вызывается и добавляет ее на Label, переданную в качестве входного параметра.
     *
     * @param label Панель, на которую будет помещена фигура после создания.
     */
    @Override
    public void createFigure(JLabel label) {

        // Элементам/кубикам фигуры задаются координаты расположения,
        // после чего добавляются на label.
        square1.setLocation(120, 0);
        square1.setSize(30, 30);
        label.add(square1);

        square2.setLocation(120, 30);
        square2.setSize(30, 30);
        label.add(square2);

        square3.setLocation(150, 0);
        square3.setSize(30, 30);
        label.add(square3);

        square4.setLocation(150, 30);
        square4.setSize(30, 30);
        label.add(square4);
    }

    /**
     * Метод ничего не вращает так как фигура квадратная.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    @Override
    public void runFigureRound(MainWindow.Run monitor) {
        // do nothing // фигура квадратная
    }
}
