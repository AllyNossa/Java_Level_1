package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    Player player;
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private static final char NOT_SIGN = '*';

    char[][] field;
    int fieldSizeX;
    int fieldSizeY;

    int winLen;

    int cellHeight;
    int cellWidth;

    int cellX;
    int cellY;

    boolean isInitialized = false;

    Map() {
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e, player);
            }
        });

        modeAgainstAI();
    }


    void update(MouseEvent e, Player player) {

        cellX = e.getX() / cellWidth;
        cellY = e.getY() / cellHeight;
        System.out.println("x: " + cellX + " y: " + cellY);
        repaint();
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        field = new char[fieldSizeX][fieldSizeY];
        isInitialized = true;
        repaint();

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = NOT_SIGN;
                System.out.print(field[i][j]);
            }
        }

        System.out.println();
    }

    void modeAgainstAI() {
        Player player = new Player('X');
        while(true) {
            AI ai = new AI('O');
            player.shot(cellX, cellY, this);
            if (isFieldFull()) {
                System.out.println("Игра окончена");
                break;
            }
            repaint();
            ai.aiShot(this);
            if (isFieldFull()) {
                System.out.println("Игра окончена");
                break;
            }
            repaint();
        }
    }

    boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > fieldSizeX - 1 || y > fieldSizeY - 1) {
            return false;
        }
        return field[x][y] == NOT_SIGN;
    }

    boolean isFieldFull() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == NOT_SIGN)
                    return false;
            }
        }
        return true;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {
        if (!isInitialized) {
            return;
        }

        int panelWindth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeX;
        cellWidth = panelWindth / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWindth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] != NOT_SIGN) {
                    if (field[i][j] == 'X') {
                        // Рисуем крестик
                        g.setColor(Color.RED);
                        g.drawLine((i * cellHeight), (j * cellWidth), (i + 1) * cellHeight, (j + 1) * cellWidth);
                        g.drawLine((i + 1) * cellHeight, (j * cellWidth), (i * cellHeight), (j + 1) * cellWidth);
                    }
                    if (field [i][j] == 'O') {
                        // Рисуем нолик
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellHeight), (j * cellWidth), cellHeight, cellWidth);
                    }
                }
            }
        }
    }


}

class Player {
    private char sign;

    public Player(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    void shot (int x, int y, Map map) {

        if (map.isCellBusy(x, y)) {
            map.field[x][y] = sign;
        }
    }
}

class AI {
    private char sign;
    Random random = new Random();

    public AI(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    void aiShot(Map map) {
        int x,y;
        AI ai = new AI('O');

        do {
            x = random.nextInt(map.fieldSizeX);
            y = random.nextInt(map.fieldSizeY);
        } while (!map.isCellBusy(y,x));

        map.field[x][y] = ai.getSign();
    }
}


