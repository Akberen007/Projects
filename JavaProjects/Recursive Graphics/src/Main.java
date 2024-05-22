import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Boxes {

    private int level = 9;

    private void drawBoxes(Graphics g, int level, int locX, int locY, int side, int delta) {
        g.drawRect(locX, locY, side, side);
        if (level > 0) {
            int newLocX = locX + delta;
            int newLocY = locY + delta;
            drawBoxes(g, level - 1, newLocX, newLocY, side - 2 * delta, delta);
        } // if
    } // drawBoxes()

    /**
     * draw() is the public method that handles drawing of the boxes
     * @param g is a reference to the current Graphics object
     */
    public void draw(Graphics g) {
        drawBoxes(g, level, 20, 20, 300, 10);
    } // draw()

    public static void main(String args[]) {
        new DrawingGUI("Boxes");
    }
} // Boxes

class DrawingGUI extends JFrame {

    public DrawingGUI(String title) {
        setTitle(title);
        setVisible(true);
        setSize(340, 360);
        getContentPane().add(new DrawingPanel());
    }
}

class DrawingPanel extends JPanel {
    public void paintComponent(Graphics g) {
        new Boxes().draw(g); // Create a Boxes object and call draw()
    }
}