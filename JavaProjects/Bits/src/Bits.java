public class Bits {
    public static void main(String[] args) {
        // Check if the user provided a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java Bits <integer>");
            return;
        }

        // Parse the command-line argument as an integer
        int n = Integer.parseInt(args[0]);

        // Check if the input is negative
        if (n < 0) {
            System.out.println("Illegal input: Please provide a non-negative integer.");
            return;
        }

        // Compute the number of bits using a while loop
        int count = 0;
        while (n >= 1) {
            n = n / 2;
            count++;
        }

        // Print the result
        System.out.println("Number of bits: " + count);
    }
}