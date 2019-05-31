package TicTac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

class Map extends JPanel {
    static final int GAME_MODE_HVA = 0;
    static final int GAME_MODE_HVH = 1;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOTS_PADDING = 5;

    private static final int STATE_DRAW = 0;
    private static final int STATE_HUMAN_WIN = 1;
    private static final int STATE_AI_WIN = 2;
    private int stateGameOver;

    private static final String MSG_DRAW = "Ничья!";
    private static final String MSG_HUMAN_WIN = "Победил игрок!";
    private static final String MSG_AI_WIN = "Победил компьютер!";


    private final Random random = new Random();
    private final Font font = new Font("Times new roman", Font.BOLD, 48);

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean initialized;
    private boolean gameOver;


    Map(){
        setBackground(Color.WHITE);
    }
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeX][fieldSizeY];
        initialized = true;
        gameOver = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
                repaint();
            }
        });
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    private void update(MouseEvent e) {
        if (gameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!isValidCell(cellX, cellY) || !isEmptyCell(cellY, cellX)) return;
        field[cellX][cellY] = DOT_HUMAN;
        if(checkWin(DOT_HUMAN)) {
            stateGameOver = STATE_HUMAN_WIN;
            gameOver = true;
            return;
        }
        if(isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
            return;
        }
        aiTurn();
        repaint();
        if(checkWin(DOT_AI)) {
            stateGameOver = STATE_AI_WIN;
            gameOver = true;
            return;
        }
        if(isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
            return;
        }

    }

    private void render(Graphics g){
        if(!initialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;
        g.setColor(Color.BLACK);
        for (int i = 0; i <= fieldSizeY ; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i <= fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(isEmptyCell(j, i)) continue;
                if(field[i][j] == DOT_HUMAN){
                    g.setColor(Color.BLUE);
                }
                else if(field[i][j] == DOT_AI){
                    g.setColor(new Color(255, 0, 0));
                } else {
                    throw new RuntimeException("can't recognize cell" + field[i][j]);
                }
                g.fillOval(i * cellWidth + DOTS_PADDING,
                        j * cellHeight+ DOTS_PADDING,
                        cellWidth - DOTS_PADDING * 2,
                        cellHeight- DOTS_PADDING * 2);
            }
        }
        if(gameOver){
            showMessageGameOver(g);
        }
    }

    void showMessageGameOver(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(font);
        switch (stateGameOver){
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_HUMAN_WIN:
                g.drawString(MSG_HUMAN_WIN, 70, getHeight() / 2);
                break;
            case STATE_AI_WIN:
                g.drawString(MSG_AI_WIN, 20, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("unexpected Gameover state: " + stateGameOver);
        }
    }

    private void aiTurn() {
        if(turnAIWinCell()) return;
        if(turnHumanWinCell()) return;
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) return true;
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        field[i][j] = DOT_AI;
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, dot)) return true;
                if (checkLine(i, j, 1, 1, winLength, dot)) return true;
                if (checkLine(i, j, 0, 1, winLength, dot)) return true;
                if (checkLine(i, j, 1, -1, winLength, dot)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        final int far_x = x + (len - 1) * vx;
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != dot) return false;
        }
        return true;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) { return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; }

    private boolean isEmptyCell(int x, int y) { return field[y][x] == DOT_EMPTY; }


}

