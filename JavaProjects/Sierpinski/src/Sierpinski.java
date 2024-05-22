public class Sierpinski {

    // Draw a filled equilateral triangle
    public static void filledEquilateralTriangle(double x, double y, double size) {
        double height = size * Math.sqrt(3) / 2;
        double[] xCoords = { x, x - size / 2, x + size / 2 };
        double[] yCoords = { y, y + height, y + height };
        StdDraw.filledPolygon(xCoords, yCoords);
    }

    // Draw Sierpinski triangle recursively
    public static void drawSierpinski(int n, double x, double y, double size) {
        if (n == 0) {
            filledEquilateralTriangle(x, y, size);
        } else {
            double height = size * Math.sqrt(3) / 2;
            drawSierpinski(n - 1, x, y, size / 2); // Bottom-left triangle
            drawSierpinski(n - 1, x + size / 2, y, size / 2); // Bottom-right triangle
            drawSierpinski(n - 1, x + size / 4, y + height / 2, size / 2); // Top triangle
        }
    }

    // Initialize StdDraw parameters and call the recursive function
    public static void initializeDraw(int n) {
        StdDraw.setPenColor(StdDraw.BLUE);
        drawSierpinski(n, 0.5, 0, 0.5);
    }

    // Main function
    public static void main(String[] args) {
        int n = 5; // Level of recursion
        initializeDraw(n);
    }
}
