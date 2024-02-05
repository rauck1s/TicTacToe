package windowTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToe extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 1;
    public static final int FIELD_0 = 2;
    int[][] field;
    int move = 0;
    public TicTacToe(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3];
        initGame();

    }
    public void initGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = FIELD_EMPTY;
            }
        }
    }
    /*поле*/
    void drawGrid(Graphics graphics){
        int w = getWidth();
        int h = getHeight();
        int dw = w/3;
        int dh = h /3;
        graphics.setColor(Color.BLACK);
        for(int i =0; i < 3; i++){
            graphics.drawLine(0, dh * i, w, dh *i);
            graphics.drawLine(dw*i, 0 , dw*i, h);
        }
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.clearRect(0, 0 , getWidth(), getHeight());
        drawGrid(graphics);
        drawXO(graphics);

    }
    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            int i = (int)((float) x / getWidth() * 3);
            int j = (int)((float) y / getHeight() * 3);
            move +=1;
            if(field[i][j] == FIELD_EMPTY){
                field[i][j] = FIELD_X;
                repaint();
                switch(move){
                    case 1 ->{
                        searchFirstMove_O(i,j);
                        repaint();
                    }
                    case 2 -> {
                        searchSecondMove_O(i, j);
                    }
                }
            }
        }
    }

     void searchSecondMove_O(int i, int j) {

    }

    void searchFirstMove_O(int i, int j) {
        if(i == 1 && j == 1 ){
            int corner = (int) (0 + (Math.random()*4));
            switch(corner){
                case 1 -> {
                    field[0][0] = FIELD_0;
                    repaint();
                }
                case 2 -> {
                    field[0][2] = FIELD_0;
                    repaint();
                }
                case 3 -> {
                    field[2][0] = FIELD_0;
                    repaint();
                }
                case 4 ->{
                    field[2][2] = FIELD_0;
                    repaint();
                }
            }
        }
        else {
            field[1][1] = FIELD_0;
            repaint();
        }
    }


    /*проверка выигрыша*/
    int checkState(){
        int diagonalLeft = 0;
        int diagonalRight = 0;
        for(int i = 0; i < 3; i++){
            diagonalLeft += field[i][i];
            diagonalRight += field[i][2-i];
        }
        if(diagonalLeft == FIELD_0 * 3 || diagonalLeft == FIELD_X * 3){
            return diagonalLeft;
        }
        if(diagonalRight == FIELD_0 * 3 || diagonalRight == FIELD_X * 3){
            return diagonalRight;
        }
        int check_i;
        int check_j;
        boolean hasEmpty = false;
        for(int i = 0; i < 3; i ++){
            check_i = 0;
            check_j = 0;
            for(int j = 0; j < 3; j++ ){
                if(field[i][j] == 0){
                    hasEmpty = true;
                }
                check_i += field[i][j];
                check_j += field[j][i];
            }if(check_i == FIELD_0 * 3 || check_i == FIELD_X * 3){
                return check_i;
            }if(check_j == FIELD_0 * 3 || check_j == FIELD_X * 3){
                return check_j;
            }
        }if (hasEmpty) return 0; else return -1;
    }

    void drawXO(Graphics graphics){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j ++){
                if( field[i][j] == FIELD_X){
                    drawX(i,j,graphics);
                } else if( field[i][j] == FIELD_0){
                    draw0(i,j, graphics);
                }
            }
        }
    }
    void drawX(int i, int j, Graphics graphics){
        graphics.setColor(Color.BLUE);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawLine(x, y, x + dw , y + dh);
        graphics.drawLine(x, y + dh, x + dw , y);
    }
    /*ставит нолики*/
    void draw0(int i, int j, Graphics graphics){
        graphics.setColor(Color.RED);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawOval(x + 5 * dw/100, y, dw * 9 / 10, dh);
    }
}
