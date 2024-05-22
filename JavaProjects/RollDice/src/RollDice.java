public class RollDice {
    public static void main(String[] args) {
        // Check if the user provided a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java RollDice <n>");
            return;
        }

        // Parse the command-line argument as an integer
        int n = Integer.parseInt(args[0]);

        // Validate that n is a positive integer
        if (n <= 0) {
            System.out.println("Please provide a positive integer for the number of rolls.");
            return;
        }

        // Array to store the frequency of each possible total
        int[] totals = new int[51]; // 10 to 60 inclusive

        // Roll the dice n times
        for (int i = 0; i < n; i++) {
            int total = rollDice();
            totals[total - 10]++;
        }

        // Print the histogram
        for (int i = 10; i <= 60; i++) {
            System.out.printf("%2d: %s%n", i, printStars(totals[i - 10]));
        }
    }

    // Simulates rolling ten fair six-sided dice and returns the total
    private static int rollDice() {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += (int) (Math.random() * 6) + 1;
        }
        return total;
    }

    // Helper method to print stars in the histogram
    private static String printStars(int count) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stars.append('*');
        }
        return stars.toString();
    }
}
