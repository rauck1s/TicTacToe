package windowTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToe extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 1;
    public static final int FIELD_0 = 2;
    int[][] field;
    int key = 0;
    public TicTacToe(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3];
        initGame();
    }

    public void initGame() {
        for(int i =0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                field[i][j] = FIELD_EMPTY;
            }
        }
    }

    /*клики мышки*/
    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            int i = (int)((float) x / getWidth() * 3);
            int j = (int)((float) y / getHeight() * 3);
            if(field[i][j] == FIELD_EMPTY){
                field[i][j] = FIELD_X;
            }
        }
    }

    /*отвечает за рисовку ноликов и крестиков, но подумать надо про алгоритм с раставлением ноликов(как передать ячейку,
    * как определять где крестики и как лучше ставить нолики)*/
    void drawX0(Graphics graphics){
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(field[i][j] == FIELD_X){
                    drawX(i, j, graphics);
                    search_0(i, j, graphics);
                    key++;
                }
            }
        }
    }

    public void search_0(int i, int j, Graphics graphics) {
        switch (key){
            case 1 ->{
                moveFirst(i,j,graphics);
            }
            case 2 ->{
                moveSecond(i,j,graphics);
            }
            case 3->{

            }

        }
    }

    public void moveSecond(int i, int j, Graphics graphics) {

    }

    public void moveFirst(int i, int j, Graphics graphics){
        if(field[1][1] != FIELD_X){
            draw0(1,1,graphics);
        }
        else {
            draw0(0,2,graphics);
        }
    }

    /*ставит крестики*/
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
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawGrid(graphics);
    }
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
}
