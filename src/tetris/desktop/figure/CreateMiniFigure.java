package tetris.desktop.figure;

import javax.swing.*;

/**
 * Класс в котором определенны маленькие, вспомогательные фигурки для правой панели основного окна программы.
 * Также в классе генерируется случайная последовательность в которой будут создаваться основные фигуры.
 */
public class CreateMiniFigure {

    /**
     * Картинки для мини фигур.
     */
    ImageIcon miniAzure = new ImageIcon("src\\Image\\MiniAzure.jpg");
    ImageIcon miniBlue = new ImageIcon("src\\Image\\MiniBlue.jpg");
    ImageIcon miniGreen = new ImageIcon("src\\Image\\MiniGreen.jpg");
    ImageIcon miniOrange = new ImageIcon("src\\Image\\MiniOrange.jpg");
    ImageIcon miniPurple = new ImageIcon("src\\Image\\MiniPurple.jpg");
    ImageIcon miniRed = new ImageIcon("src\\Image\\MiniRed.jpg");
    ImageIcon miniYellow = new ImageIcon("src\\Image\\MiniYellow.jpg");

    /**
     * Массив в который случайным образом помещаются номера фигур (как маленьких, так и больших фигур, у них одни номера),
     * для дальнейшего создания на основной панели игры.
     */
    private static int[] fiqure = {randomFigure(), randomFigure(), randomFigure(), randomFigure()};

    /**
     * Метод генерации случайных чисел, от 1 до 7.
     *
     * @return случайный номер от 1 до 7.
     */
    private static int randomFigure() {
        return (int) (1 + ((Math.random()) * (7)));
    }

    public static void setFiqure() {
        fiqure[0] = fiqure[1];
        fiqure[1] = fiqure[2];
        fiqure[2] = fiqure[3];
        fiqure[3] = randomFigure();
    }

    public static int getFigure(int i) {
        return fiqure[i];
    }

    /**
     * Массив элементов меленьких фигур, которые на данный момент отображаются на правой панели.
     */
    private static JLabel сurrentMiniFigure[] = {null, null, null, null, null, null, null, null, null, null, null, null};

    /**
     * Метод удаляет маленькие фигуры с правой панели и массива маленьких элементов сurrentMiniFigure.
     */
    private void deleteMiniFigure() {
        for (int i = 0; i < сurrentMiniFigure.length; i++) {
            if (сurrentMiniFigure[i] != null) {
                сurrentMiniFigure[i].setVisible(false);
                сurrentMiniFigure[i] = null;
            }
        }
    }

    /**
     * Метод добавляет элемент переданный в параметре в массив маленьких элементов сurrentMiniFigure.
     *
     * @param label Элемент который нужно добавить в массив.
     */
    private void addMiniFigure(JLabel label) {
        for (int i = 0; i < сurrentMiniFigure.length; i++) {
            if (сurrentMiniFigure[i] == null) {
                сurrentMiniFigure[i] = label;
                return;
            }
        }
    }

    /**
     * Метод удаляет маленькие фигуры с правой панели и создает три новых фигуры на правой панели.
     *
     * @param label Элемент на который добавляются созданные фигуры.
     */
    public void createMiniFigure(JLabel label) {

        // удаляются все маленькие фигурки с правой панели.
        deleteMiniFigure();

        for (int i = 1; i <= 3; i++) {

            // создается маленькая фигура, номер которой соответствует номеру
            // определенного елемента массива сurrentMiniFigure
            switch (getFigure(i)) {

                case 1:
                    createMiniAzure(label);
                    break;
                case 2:
                    createMiniBlue(label);
                    break;
                case 3:
                    createMiniGreen(label);
                    break;
                case 4:
                    createMiniOrange(label);
                    break;
                case 5:
                    createMiniPurple(label);
                    break;
                case 6:
                    createMiniRed(label);
                    break;
                case 7:
                    createMiniYellow(label);
                    break;
            }
        }
        label.updateUI();
    }

    /**
     * Метод возвращает начальную координату начиная с которой должна создаваться следующая мини фигура.
     * Вычисляется самая большая координата из всех элементов массива сurrentMiniFigure и добаляется дистанция до слеующего елемента 40px.
     *
     * @return начальная координата начиная с которой должна создаваться следующая мини фигура
     */
    private int getDistanceBetweenFigure() {
        int maxPositionY = 0;
        for (JLabel anArrFigure : сurrentMiniFigure) {
            if (anArrFigure != null) {
                if (maxPositionY < anArrFigure.getY()) {
                    maxPositionY = anArrFigure.getY();
                }
            }
        }
        return maxPositionY + 40;
    }

    /**
     * Метод создает мини фигуру лазурного цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniAzure(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniAzure);
        square1.setLocation(380, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniAzure);
        square2.setLocation(380, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniAzure);
        square3.setLocation(380, 40 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniAzure);
        square4.setLocation(380, 60 + distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру синего цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniBlue(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniBlue);
        square1.setLocation(370, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniBlue);
        square2.setLocation(370, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniBlue);
        square3.setLocation(370, 40 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniBlue);
        square4.setLocation(390, distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру зеленого цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniGreen(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniGreen);
        square1.setSize(20, 20);
        square1.setLocation(370, distance);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniGreen);
        square2.setLocation(370, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniGreen);
        square3.setLocation(390, 20 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniGreen);
        square4.setLocation(390, 40 + distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру оранжевого цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniOrange(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniOrange);
        square1.setLocation(390, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniOrange);
        square2.setLocation(390, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniOrange);
        square3.setLocation(390, 40 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniOrange);
        square4.setLocation(370, distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру пурпурного цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniPurple(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniPurple);
        square1.setLocation(390, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniPurple);
        square2.setLocation(390, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniPurple);
        square3.setLocation(390, 40 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniPurple);
        square4.setLocation(370, 20 + distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру красного цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniRed(JLabel panel) {
        int distance = getDistanceBetweenFigure();
        JLabel square1 = new JLabel(miniRed);
        square1.setLocation(390, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniRed);
        square2.setLocation(390, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniRed);
        square3.setLocation(370, 20 + distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniRed);
        square4.setLocation(370, 40 + distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }

    /**
     * Метод создает мини фигуру желтого цвета и добавляет ее на элемент переданный в параметре.
     *
     * @param panel элемент на который нужно поместить созданную фигуру.
     */
    private void createMiniYellow(JLabel panel) {
        int distance = getDistanceBetweenFigure();

        JLabel square1 = new JLabel(miniYellow);
        square1.setLocation(370, distance);
        square1.setSize(20, 20);
        panel.add(square1);
        addMiniFigure(square1);
        JLabel square2 = new JLabel(miniYellow);
        square2.setLocation(370, 20 + distance);
        square2.setSize(20, 20);
        panel.add(square2);
        addMiniFigure(square2);
        JLabel square3 = new JLabel(miniYellow);
        square3.setLocation(390, distance);
        square3.setSize(20, 20);
        panel.add(square3);
        addMiniFigure(square3);
        JLabel square4 = new JLabel(miniYellow);
        square4.setLocation(390, 20 + distance);
        square4.setSize(20, 20);
        panel.add(square4);
        addMiniFigure(square4);
    }
}
