package windowTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToe extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 1;
    public static final int FIELD_0 = 2;
    int[][] field;
    public TicTacToe(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
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
