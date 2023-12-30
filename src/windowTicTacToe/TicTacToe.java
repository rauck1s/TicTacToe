package windowTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToe extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 1;
    public static final int FIELD_0 = 2;
    int[][] field;
    boolean key = true;
    public TicTacToe(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            int i = (int)((float) x / getWidth() * 3);
            int j = (int)((float) y / getHeight() * 3);
            if(field[i][j] == FIELD_EMPTY){
                if(key){
                }
                else if(!key){

                }
            }
        }
    }
    void drawX0(Graphics graphics){
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){

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
