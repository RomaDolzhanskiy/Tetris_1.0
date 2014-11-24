package tetris.logic;

import java.io.*;

/**
 * Класс для вычисления результатов игры.
 * В классе вычисляется текущее кол-во очков, уровень, максимальное кол-во очков
 * и скорость с какой основные фигуры падают вниз.
 */
public class TetrisScore {

    /**
     * Кол-во чков игрока.
     */
    private static int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore() {
        // очки увеличиваются на 10.
        score += 10;
        // если кол-во очков больше чем максимальное кол-во очков, то максимальное кол-во очков увеличивается,
        // в файлик где хранится значение максимального кол-ва очков записывается новое значение.
        if (Integer.parseInt(gethighScore()) <= getScore()) {
            writeHighScore(String.valueOf(getScore()));
        }
    }

    /**
     * Уровень игры.
     */
    private static int level = 1;

    public int getLevel() {

        return level;
    }

    public void setLevel() {

        // если кол-во очков больше равно максимальному кол-ву очков уровня, то
        // значение максимального кол-во очков уровня увеличивается,
        // значение уровня увеличивается и значение скорости падения фигур увеличивается.
        if (getScore() >= getlevelValue()) {
            setlevelValue();
            level += 1;
            setSpeed();
        }
    }

    /**
     * Максимальное кол-во очков уровня, для перехода на следующий уровень.
     */
    private static int levelValue = 100;

    private int getlevelValue() {
        return levelValue;
    }

    private void setlevelValue() {
        levelValue += 100;
    }

    /**
     * Значение скорости падения основных фигур.
     */
    private int speed = 300;

    public int getSpeed() {
        return speed;
    }

    private void setSpeed() {
        speed -= 20;
    }

    /**
     * Файл со значением максимального кол-ва очков.
     */
    File file = new File("src\\image\\HighScore.txt");

    /**
     * Метод для записи значения максимального кол-ва очков игры.
     * Метод записывает значение максимального кол-ва очков игры в файл {@code new File("src\\image\\HighScore.txt");}
     * если файла нет то он создается.
     *
     * @param text значение которое нужно записать.
     */
    private void writeHighScore(String text) {

        // если файла нет то он создается.
        if (!file.exists()) {
            File file = new File("src\\image\\HighScore.txt");
        }


        try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {

            out.print(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод для считывания значения максимального кол-ва очков игры.
     * Метод считывает значение максимального кол-ва очков игры с файла {@code new File("src\\image\\HighScore.txt");}
     * если файла нет то он создается.
     *
     * @return значение максимального кол-ва очков игры.
     */
    private String readHighScore() {

        String text;

        // если файла нет то он создается.
        if (!file.exists()) {
            File file = new File("src\\Image\\HighScore.txt");
            writeHighScore("0");
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {

            text = in.readLine();
            return text;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String gethighScore() {
        return readHighScore();
    }

}
