public class NoonSnooze {
    public static void main(String[] args) {
        // Check if the user provided a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java NoonSnooze <minutes>");
            return;
        }

        // Parse the command-line argument as an integer
        int snooze = Integer.parseInt(args[0]);

        // Calculate hours and minutes
        int hours = (12 + snooze / 60) % 12;
        int minutes = snooze % 60;

        // Determine if it's AM or PM
        String period = (snooze / 60) % 24 < 12 ? "AM" : "PM";

        // Format and print the result
        System.out.printf("Time after snooze: %02d:%02d %s%n", hours, minutes, period);
    }
}