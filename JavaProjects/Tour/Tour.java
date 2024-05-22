import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class Tour {
    private Node first; // Reference to the first node in the tour
    private int size; // Number of points in the tour

    // Nested Node class representing a node in the circularly linked list
    private class Node {
        private Point2D point; // Point associated with this node
        private Node next; // Reference to the next node in the tour

        public Node(Point2D point) {
            this.point = point;
            this.next = null;
        }
    }

    // Default constructor for an empty tour
    public Tour() {
        first = null;
        size = 0;
    }

    // Constructor for a 4-point tour (A → B → C → D → A)
    public Tour(Point2D a, Point2D b, Point2D c, Point2D d) {
        first = new Node(a);
        first.next = new Node(b);
        first.next.next = new Node(c);
        first.next.next.next = new Node(d);
        first.next.next.next.next = first; // Circular reference
        size = 4;
    }

    // Returns the number of points in the tour
    public int size() {
        return size;
    }

    // Returns the length of the tour
    public double length() {
        if (size < 2) return 0.0; // Length of an empty or single-point tour is 0
        double totalLength = 0.0;
        Node current = first;
        do {
            totalLength += current.point.distanceTo(current.next.point);
            current = current.next;
        } while (current != first);
        return totalLength;
    }

    // Returns a string representation of the tour
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size > 0) {
            Node current = first;
            do {
                sb.append(current.point.toString()).append("\n");
                current = current.next;
            } while (current != first);
        }
        return sb.toString();
    }

    // Draws the tour using StdDraw
    public void draw() {
        if (size > 1) {
            Node current = first;
            do {
                current.point.drawTo(current.next.point);
                current = current.next;
            } while (current != first);
        }
    }

    // Insert the given point into the current tour using the Insert Nearest heuristic
    public void insertNearest(Point2D p) {
        // Implement Insert Nearest heuristic here
    }

    // Insert the given point into the current tour using the Smallest Neighbor heuristic
    public void insertSmallest(Point2D p) {
        // Implement Smallest Neighbor heuristic here
    }
}
