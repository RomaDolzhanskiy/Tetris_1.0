package tetris.logic;

import tetris.desktop.figure.Figure;

import javax.swing.*;

/**
 * Класс отвечает за расположение основных фигур на игровой площади.
 * <p>Реализация класса.</p>
 * В классе создан массив JLabel, куда добавляются все составные элементы (кубики) основных фигур,
 * в соответствии с координатами их размещения на основной игровой панели после их остановки.
 * Перед движением кубика по игровой панели проверяется на занятость ячейка, куда он должен передвинутся.
 * После остановки кубика проверяется на заполненность остальными кубиками, линия в которой кубик остановился.
 * Если линия заполненная полностью, то все кубики данной линии удаляются а элементы верхних линий опускаются на линию ниже.
 */
public class TetrisMatrix {

    TetrisScore tetrisScore = new TetrisScore();

    /**
     * Массив куда помещаются все элементы основных фигур, согласно их координатам на игровой панели, после их остановки.
     */
    private static volatile JLabel matrix[] = {
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null
    };

    /**
     * Метод возвращает индекс массива согласно координат элемента переданным во входящих параметрах.
     *
     * @param positionX координата X.
     * @param positionY координата Y.
     * @return индекс елемента массива.
     */
    private int getMatrixIndex(int positionX, int positionY) {
        int indexMatrix = 0;
        int minPositionX = 0;
        int maxPositionX = 30;
        int minPositionY = 0;
        int maxPositionY = 30;

        for (; maxPositionY <= 570; ) {
            for (; maxPositionX <= 330; ) {
                if (minPositionX <= positionX && positionX < maxPositionX && minPositionY <= positionY && positionY < maxPositionY) {
                    return indexMatrix;

                } else {
                    minPositionX += 30;
                    maxPositionX += 30;
                    indexMatrix += 1;
                }
            }
            minPositionY += 30;
            maxPositionY += 30;
            minPositionX = 0;
            maxPositionX = 30;
        }
        return -1;
    }

    /**
     * Метод добавляет в массив элемент переданный в параметре.
     *
     * @param label элемент который нужно добавить в массив.
     */
    private void setMatrixLable(JLabel label) {

        matrix[getMatrixIndex(label.getX(), label.getY())] = label;

    }

    /**
     * Метод добавляет в массив все элементы фигуры переданной в параметре.
     *
     * @param figure фигура элементы которой нужно добавить в массив.
     */
    public void setMatrixFigure(Figure figure) {
        setMatrixLable(figure.square1);
        setMatrixLable(figure.square2);
        setMatrixLable(figure.square3);
        setMatrixLable(figure.square4);

    }

    /**
     * Метод проверяет на занятость ячейку массива, если ячейка занята, то бросает exception "MovingBeyondException".
     *
     * @param positionX координата элемента X.
     * @param positionY координата элемента Y.
     * @return true/false
     * @throws MovingBeyondException если ячейка занята.
     */
    public boolean isEmptyMatrix(int positionX, int positionY) throws MovingBeyondException {

        if ((getMatrixIndex(positionX, positionY) == -1) || (matrix[getMatrixIndex(positionX, positionY)] != null)) {
            throw new MovingBeyondException("Выход за рвмки поля");
        }
        return true;

    }

    /**
     * Метод проверяет линию элемента переданного в параметре на заполненность.
     *
     * @param label элемент линию которого нужно проверить на заполненность.
     * @return если вся линия заполненна элементами - true иначе - false
     */
    private boolean chackLine(JLabel label) {
        for (int i = 0; i < 330; i += 30) {
            if (matrix[getMatrixIndex(i, label.getY())] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод удаляет все элементы линии, элемента переданного в параметре, если она полностью заполненна элементами.
     *
     * @param square элемент линию элементов которого нужно удалить.
     */
    private void deleteLine(JLabel square) {
        if (chackLine(square)) {
            for (int i = 0; i < 330; i += 30) {
                JLabel label = matrix[getMatrixIndex(i, square.getY())];
                label.setVisible(false);
                matrix[getMatrixIndex(i, square.getY())] = null;


                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }

            }
            runLinaDown(square);
            tetrisScore.setScore();
            tetrisScore.setLevel();
        }
    }

    /**
     * Метод удаляет все линии элементов, переданной в параметре фигуры, если они полностью заполненны элементами.
     *
     * @param figure фигура линии элементов которой нужно удалить.
     */
    public void deleteLineFigure(Figure figure) {
        deleteLine(figure.square4);
        deleteLine(figure.square3);
        deleteLine(figure.square2);
        deleteLine(figure.square1);
    }

    /**
     * Метод перемещает все элементы линии, переданного в параметре элемента, вниз на одну позицию.
     *
     * @param label элемент линию элементов которого нужно переместить вниз.
     */
    private void runLinaDown(JLabel label) {

        int i = getMatrixIndex(300, label.getY() - 30);
        while (i > 0) {
            if (matrix[i] != null) {

                matrix[getMatrixIndex(matrix[i].getX(), matrix[i].getY() + 30)] = matrix[i];
                matrix[i].setLocation(matrix[i].getX(), matrix[i].getY() + 30);


                matrix[i] = null;
            }
            i--;
        }
    }
}
