public class Transform2D {

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] newArray = new double[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double radians = Math.toRadians(theta);
        double cosTheta = Math.cos(radians);
        double sinTheta = Math.sin(radians);

        for (int i = 0; i < x.length; i++) {
            double newX = x[i] * cosTheta - y[i] * sinTheta;
            double newY = x[i] * sinTheta + y[i] * cosTheta;
            x[i] = newX;
            y[i] = newY;
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        // Test data
        double[] x = {0, 1, 1, 0};
        double[] y = {0, 0, 1, 1};
        double alpha = 2.0;
        double dx = 1.0;
        double dy = 1.0;
        double theta = 90.0;

        System.out.println("Original Polygon:");
        printPolygon(x, y);

        // Test scale()
        scale(x, y, alpha);
        System.out.println("After scaling:");
        printPolygon(x, y);

        // Test translate()
        translate(x, y, dx, dy);
        System.out.println("After translation:");
        printPolygon(x, y);

        // Test rotate()
        rotate(x, y, theta);
        System.out.println("After rotation:");
        printPolygon(x, y);

        // Test copy()
        double[] copiedX = copy(x);
        double[] copiedY = copy(y);
        System.out.println("Copied Polygon:");
        printPolygon(copiedX, copiedY);
    }

    // Utility method to print the polygon
    private static void printPolygon(double[] x, double[] y) {
        for (int i = 0; i < x.length; i++) {
            System.out.println("(" + x[i] + ", " + y[i] + ")");
        }
        System.out.println();
    }
}
