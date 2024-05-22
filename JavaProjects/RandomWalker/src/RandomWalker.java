public class RandomWalkers {
    public static void main(String[] args) {
        // Check if the user provided two command-line arguments
        if (args.length != 2) {
            System.out.println("Usage: java RandomWalkers <n> <trials>");
            return;
        }

        // Parse the command-line arguments as integers
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Variables to store the current location (x, y) and total squared distance
        int x, y, totalSquaredDistance;

        // Repeat the experiment for the specified number of trials
        for (int trial = 0; trial < trials; trial++) {
            // Reset the location and squared distance for each trial
            x = 0;
            y = 0;
            totalSquaredDistance = 0;

            // Simulate the random walk of n steps
            for (int step = 0; step < n; step++) {
                // Randomly choose a direction (up, down, left, or right)
                int direction = (int) (Math.random() * 4);

                // Update the location based on the chosen direction
                switch (direction) {
                    case 0: // Up
                        y++;
                        break;
                    case 1: // Down
                        y--;
                        break;
                    case 2: // Left
                        x--;
                        break;
                    case 3: // Right
                        x++;
                        break;
                }
            }

            // Calculate the squared distance for the current trial and update totalSquaredDistance
            int squaredDistance = x * x + y * y;
            totalSquaredDistance += squaredDistance;
        }

        // Calculate the mean squared distance
        double meanSquaredDistance = (double) totalSquaredDistance / trials;

        // Print the result
        System.out.println("mean squared distance = " + meanSquaredDistance);
    }
}