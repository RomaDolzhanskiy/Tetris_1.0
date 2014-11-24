package tetris.logic;

import tetris.desktop.MainWindow;
import tetris.desktop.RightPanelOnWindow;
import tetris.desktop.figure.CreateMiniFigure;
import tetris.desktop.figure.Figure;

import javax.swing.*;

/**
 * В классе только один метод, который создает основную фигуру и приводит ее в движение.
 */
public class Mover {

    /**
     * Текущая фигура, которая падает в данный момент.
     */
    public static Figure сurrentFigure;

    /**
     * Объект, по которому будет происходить синхронизация.
     */
    MainWindow.Run monitor;

    public Mover(MainWindow.Run monitor) {
        сurrentFigure = new Figure().getRandomFigure();
        this.monitor = monitor;
    }

    RightPanelOnWindow rightPanelOnWindow = new RightPanelOnWindow();

    CreateMiniFigure miniFigure = new CreateMiniFigure();

    TetrisScore tetrisScore = new TetrisScore();

    TetrisMatrix matrix = new TetrisMatrix();

    /**
     * Метод, который создает основную фигуру и приводит ее в движение.
     *
     * @param label Элемент на который добавляется созданная фигура.
     * @throws GameOverException Бросает exception окончания игры.
     */
    public void createAndRunFigure(JLabel label) throws GameOverException {

        // создаются мини-фигурки для правой панели основного окна программы.
        miniFigure.createMiniFigure(label);

        // создается основная фигура, которая будет падать.
        сurrentFigure.createFigure(label);

        // переменная для подсчета кол-ва движений вниз.
        int timesMovDown = 0;

        // основная фигура падает вниз, и возвращает true если упала на один шаг, иначе false.
        while (сurrentFigure.runFigureDown(monitor)) {

            // счетчик увеличивается.
            timesMovDown++;

            try {
                // После каждого движения вниз поток засыпает на время-значение скорости.
                Thread.sleep(tetrisScore.getSpeed());
                // Если другой поток бросает interrupt() для данного экземпляра, то поток останавливается.

            } catch (InterruptedException e) {


                synchronized (monitor) {
                    try {
                       // поток останавливается.
                        monitor.wait();

                        // Если interrupt() бросить еще раз, то поток ничего не делает, и программа продолжает работать.
                    } catch (InterruptedException e1) {

                        // поток ничего не делает, и программа продолжает работать.
                        // do nothing

                    }

                }
            }

        }

        // если фигура упала вниз меньше 1 раза, то бросается exception, игра окончена.
        if (timesMovDown <= 0) {

            // в основном окне появляется надпись Game Over
            MainWindow.gameOver.setVisible(true);

            throw new GameOverException("Game Over");
        }

        // координаты фигуры записываются в матрицу размещения элементов
        // (где видно, какие места на основной панели заняты фигурами а какие свободны).
        matrix.setMatrixFigure(сurrentFigure);

        // если есть полностью заполненная линия, то она удаляется, и верхние линии опускаются вниз.
        matrix.deleteLineFigure(сurrentFigure);

        // В массив fiqure класса CreateMiniFigure рандомно добавляется новый номер следующей фигуры.
        CreateMiniFigure.setFiqure();

        // Обновляются значения правой панели.
        rightPanelOnWindow.refreshScore();
    }
}
