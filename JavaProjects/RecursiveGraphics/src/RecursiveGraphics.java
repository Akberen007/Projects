import javax.swing.*;
import java.awt.*;

public class RecursiveGraphics extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;

        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10);

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        drawTree(g, WIDTH / 2, HEIGHT, -90, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Graphics");
        RecursiveGraphics panel = new RecursiveGraphics();
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
