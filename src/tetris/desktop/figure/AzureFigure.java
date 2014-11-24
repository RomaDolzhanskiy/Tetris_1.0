package tetris.desktop.figure;

import tetris.desktop.MainWindow;
import tetris.logic.MovingBeyondException;

import javax.swing.*;

/**
 * Обект AzureFigure, одна из семи основных фигур игры. Наследуется от Figure.
 */
public class AzureFigure extends Figure {

    /**
     * Иконка для кубиков фигуры лазурного цвета.
     */
    private ImageIcon icon = new ImageIcon("src\\image\\Azure.jpg");

    /**
     * Кубики с которых состоит фигура.
     */
    private JLabel square1 = new JLabel(icon);
    private JLabel square2 = new JLabel(icon);
    private JLabel square3 = new JLabel(icon);
    private JLabel square4 = new JLabel(icon);

    /**
     * Переменная которая говорит о позиции фигуры.
     */
    private int sideFigure = 0;

    public AzureFigure() {
        // Инициализируются элементы класса потомка.
        super.square1 = square1;
        super.square2 = square2;
        super.square3 = square3;
        super.square4 = square4;
    }

    private int getSideFigure() {
        return sideFigure;
    }

    private void setSideFigure(int sideFigure) {
        this.sideFigure = sideFigure;
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
        square1.setLocation(150, 0);
        square1.setSize(30, 30);
        label.add(square1);

        square2.setLocation(150, 30);
        square2.setSize(30, 30);
        label.add(square2);

        square3.setLocation(150, 60);
        square3.setSize(30, 30);
        label.add(square3);

        square4.setLocation(150, 90);
        square4.setSize(30, 30);
        label.add(square4);
    }

    /**
     * Метод вращает на один шаг по кругу фигуру, на которой он вызван.
     * Метод синхронизирован по объекту, полученному в качестве входного параметра.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    @Override
    public void runFigureRound(MainWindow.Run monitor) {
        synchronized (monitor) {
            // Записывается изначальное положение/координаты кубиков.
            int square1X = square1.getX();
            int square1Y = square1.getY();
            int square2X = square2.getX();
            int square2Y = square2.getY();
            int square3X = square3.getX();
            int square3Y = square3.getY();
            int square4X = square4.getX();
            int square4Y = square4.getY();
            try {

                // Определяется положение фигуры,
                // и в зависимости от положения фигура вращается
                // путем передвижения элементов фигуры.
                switch (getSideFigure()) {

                    case 0:
                        runSquareLeft(square4);
                        runSquareUp(square4);
                        runSquareLeft(square4);
                        runSquareUp(square4);
                        runSquareLeft(square3);
                        runSquareUp(square3);
                        runSquareRight(square1);
                        runSquareDown(square1);

                        setSideFigure(1);

                        break;
                    case 1:
                        runSquareUp(square4);
                        runSquareRight(square4);
                        runSquareRight(square4);
                        runSquareRight(square3);
                        runSquareDown(square2);
                        runSquareDown(square1);
                        runSquareDown(square1);
                        runSquareLeft(square1);

                        setSideFigure(2);

                        break;
                    case 2:
                        runSquareLeft(square1);
                        runSquareUp(square1);
                        runSquareLeft(square1);
                        runSquareUp(square1);
                        runSquareLeft(square2);
                        runSquareUp(square2);
                        runSquareRight(square4);
                        runSquareDown(square4);

                        setSideFigure(3);

                        break;
                    case 3:
                        runSquareUp(square1);
                        runSquareRight(square1);
                        runSquareRight(square1);
                        runSquareRight(square2);
                        runSquareDown(square3);
                        runSquareDown(square4);
                        runSquareDown(square4);
                        runSquareLeft(square4);

                        setSideFigure(0);

                        break;
                }
            } catch (MovingBeyondException e) {
                // Если ловим exception (нельзя перемещаться)
                // то кубики возвращаются в исходное положение.
                square1.setLocation(square1X, square1Y);
                square2.setLocation(square2X, square2Y);
                square3.setLocation(square3X, square3Y);
                square4.setLocation(square4X, square4Y);
            }
        }
    }
}
