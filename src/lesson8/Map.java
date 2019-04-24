package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private static final int NOT_SIGN = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;

    int[][] field;
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
                super.mouseReleased(e);
                gameProcess(e);
            }
        });
    }


    void gameProcess(MouseEvent e) {

        cellX = e.getX() / cellWidth;
        cellY = e.getY() / cellHeight;
        System.out.println("x: " + cellX + " y: " + cellY);
        if (isCellBusy(cellX, cellY)) {
            field[cellX][cellY] = DOT_HUMAN;
            repaint();
        }
        aiShot();
        repaint();
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        field = new int[fieldSizeX][fieldSizeY];
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
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] != NOT_SIGN) {
                    if (field[i][j] == DOT_HUMAN) {
                        // Рисуем крестик
                        g.setColor(Color.RED);
                        g.drawLine((i * cellHeight), (j * cellWidth), (i + 1) * cellHeight, (j + 1) * cellWidth);
                        g.drawLine((i + 1) * cellHeight, (j * cellWidth), (i * cellHeight), (j + 1) * cellWidth);
                    }
                    if (field[i][j] == DOT_AI) {
                        // Рисуем нолик
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellHeight), (j * cellWidth), cellHeight, cellWidth);
                    }
                }
            }
        }
    }

    void aiShot() {
        Random random = new Random();

        int x, y;
        do {
            x = random.nextInt(this.fieldSizeX);
            y = random.nextInt(this.fieldSizeY);
        } while (!this.isCellBusy(y, x));
        field[x][y] = DOT_AI;
    }
}



