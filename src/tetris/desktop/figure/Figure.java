package tetris.desktop.figure;

import tetris.desktop.MainWindow;
import tetris.logic.MovingBeyondException;
import tetris.logic.TetrisMatrix;

import javax.swing.*;

/**
 * Базовый класс (предок) всех основных фигур игры.
 * В классе определенны все основные методы поведения фигур.
 */
public class Figure implements FigureInterface {
    /**
     * Кубики, из которых состоит фигура.
     * Инициализируются в конструкторе класса наследника.
     */
    public JLabel square1;
    public JLabel square2;
    public JLabel square3;
    public JLabel square4;

    /**
     * Создается объект TetrisMatrix для работы с методами данного класса.
     * Используется в методах {@code runSquareLeft(); runSquareRight(); runSquareDown(); runSquareUp();}
     * где вызывается метод {@code isEmptyMatrix()} для проверки на занятость места, куда будет перемещаться элемент фигуры.
     *
     */
    TetrisMatrix matrix = new TetrisMatrix();

    /**
     * Метод создает фигуру, на которой он вызывается и добавляет ее на Label, переданную в качестве входного параметра.
     *
     * @param label Панель, на которую будет помещена фигура после создания.
     */
    public void createFigure(JLabel label) {
        // Метод переопределяется в наследнике!
    }

    ;

    /**
     * Метод вращает на один шаг по кругу фигуру, на которой он вызван.
     * Метод синхронизирован по объекту, полученному в качестве входного параметра.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    public void runFigureRound(MainWindow.Run monitor) {
        // Метод переопределяется в наследнике!
    }

    ;

    /**
     * Метод возвращает одну из семи основных фигур, выбранную случайным путем.
     *
     * @return одна из семи фигур выбранная случайным путем.
     */
    public Figure getRandomFigure() {

        // CreateMiniFigure.getFigure(0) - возвращает первый элемент месива fiqure, класса CreateMiniFigure
        // В массив fiqure элементы попадают после генерации методом Math.random().
        switch (CreateMiniFigure.getFigure(0)) {
            case 1:

                return new AzureFigure();
            case 2:

                return new BlueFigure();
            case 3:

                return new GreenFigure();
            case 4:

                return new OrangeFigure();
            case 5:

                return new PurpleFigure();
            case 6:

                return new RedFigure();
            case 7:

                return new YellowFigure();
        }
        return null;
    }

    /**
     * Метод опускает на один шаг вниз (30px) фигуру, на которой он вызван.
     * Метод синхронизирован по объекту, полученному в качестве входного параметра.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    public boolean runFigureDown(MainWindow.Run monitor) {
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

                // Каждый кубик опускается вниз на один шаг (30px.)
                runSquareDown(square1);
                runSquareDown(square2);
                runSquareDown(square3);
                runSquareDown(square4);
                return true;

            } catch (MovingBeyondException e) {

                // Если ловим exception (нельзя перемещаться)
                // то кубики возвращаются в исходное положение.
                square1.setLocation(square1X, square1Y);
                square2.setLocation(square2X, square2Y);
                square3.setLocation(square3X, square3Y);
                square4.setLocation(square4X, square4Y);
                return false;
            }
        }

    }

    /**
     * Метод перемещает на один шаг вправо (30px) фигуру, на которой он вызван.
     * Метод синхронизирован по объекту, полученному в качестве входного параметра.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    public void runFigureRight(MainWindow.Run monitor) {
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
                // Каждый кубик перемещается вправо на один шаг (30px.)
                runSquareRight(square1);
                runSquareRight(square2);
                runSquareRight(square3);
                runSquareRight(square4);
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

    /**
     * Метод перемещает на один шаг влево (30px) фигуру, на которой он вызван.
     * Метод синхронизирован по объекту, полученному в качестве входного параметра.
     *
     * @param monitor Объект по которому синхронизируется данный метод.
     */
    public void runFigureLeft(MainWindow.Run monitor) {
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
                // Каждый кубик перемещается влево на один шаг (30px.)
                runSquareLeft(square1);
                runSquareLeft(square2);
                runSquareLeft(square3);
                runSquareLeft(square4);
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

    /**
     * Метод поднимает вверх на один шаг (30px.) элемент, переданный во входном параметре.
     *
     * @param label Элемент который нужно поднять вверх.
     * @throws MovingBeyondException Если переместить элемент нельзя бросается exception
     */
    void runSquareUp(JLabel label) throws MovingBeyondException {
        // если вверху свободная ячейка элемент поднимается на один шаг.
        if (matrix.isEmptyMatrix(label.getX(), label.getY() - 30)) {
            label.setLocation(label.getX(), label.getY() - 30);
        }
    }

    /**
     * Метод опускает вниз на один шаг (30px.) элемент, переданный во входном параметре.
     *
     * @param label Элемент который нужно опустить вниз.
     * @throws MovingBeyondException Если переместить элемент нельзя бросается exception
     */
    void runSquareDown(JLabel label) throws MovingBeyondException {
        // если внизу свободная ячейка элемент опускается на один шаг.
        if (matrix.isEmptyMatrix(label.getX(), label.getY() + 30)) {
            label.setLocation(label.getX(), label.getY() + 30);
        }
    }

    /**
     * Метод перемещает вправо на один шаг (30px.) элемент, переданный во входном параметре.
     *
     * @param label Элемент который нужно передвинуть вправо.
     * @throws MovingBeyondException Если переместить элемент нельзя бросается exception
     */
    void runSquareRight(JLabel label) throws MovingBeyondException {
        // если справа свободная ячейка элемент перемещается на один шаг.
        if (matrix.isEmptyMatrix(label.getX() + 30, label.getY())) {
            label.setLocation(label.getX() + 30, label.getY());
        }
    }

    /**
     * Метод перемещает влево на один шаг (30px.) элемент, переданный во входном параметре.
     *
     * @param label Элемент который нужно передвинуть влево.
     * @throws MovingBeyondException Если переместить элемент нельзя бросается exception
     */
    void runSquareLeft(JLabel label) throws MovingBeyondException {
        // если слева свободная ячейка элемент перемещается на один шаг.
        if (matrix.isEmptyMatrix(label.getX() - 30, label.getY())) {
            label.setLocation(label.getX() - 30, label.getY());
        }
    }

}
