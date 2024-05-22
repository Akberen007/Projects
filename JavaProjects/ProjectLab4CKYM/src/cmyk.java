import java.util.Scanner;

class Color {
    int c;
    int m;
    int y;
    int k;

    public Color(int c, int m, int y, int k) {
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }
}

class Cache {
    Color[] blocks;

    public Cache(int size) {
        blocks = new Color[size * 32];
    }
}

class Memory {
    Color[][] cells;

    public Memory(int rows, int cols) {
        cells = new Color[rows][cols * 4];
    }
}

class Algorithm {
    public static void executeAlgorithm1(Memory memory, Cache cache) {
        int totalAccess = memory.cells.length * memory.cells[0].length;
        int miss = totalAccess / memory.cells.length;
        int hit = totalAccess - miss;

        System.out.println("Alghorithm1");
        System.out.println("Total access: " + totalAccess);
        System.out.println("Miss: " + miss);
        System.out.println("Hit: " + hit);
        double hitRatio = (double) hit / totalAccess;
        System.out.println("Hit ratio:" + hitRatio);
    }

    public static void executeAlgorithm2(Memory memory, Cache cache) {
        int totalAccess = memory.cells.length * memory.cells[0].length;
        int miss = totalAccess / memory.cells.length * 2;
        int hit = totalAccess - miss;

        System.out.println("Alghorithm2");
        System.out.println("Total access: " + totalAccess);
        System.out.println("Miss: " + miss);
        System.out.println("Hit: " + hit);
        double hitRatio = (double) hit / totalAccess;
        System.out.println("Hit ratio: " + hitRatio);
    }

    public static void executeAlgorithm3(Memory memory, Cache cache) {
        int totalAccess = memory.cells.length * memory.cells[0].length/2;
        int miss = totalAccess / memory.cells.length * 7;
        int hit = totalAccess - miss;

        System.out.println("Alghorithm3");
        System.out.println("Total access: " + totalAccess);
        System.out.println("Miss: " + miss);
        System.out.println("Hit: " + hit);
        double hitRatio = (double) hit / totalAccess;
        System.out.println("Hit ratio: " + hitRatio);
    }
}

public class cmyk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter N (rows in memory, must be a power of 2):");
        int N = scanner.nextInt();
        if (!isPowerOfTwo(N)) {
            System.out.println("N must be a power of 2. Exiting program.");
            return;
        }

        System.out.println("Enter M (columns in memory, must be a power of 2):");
        int M = scanner.nextInt();
        if (!isPowerOfTwo(M)) {
            System.out.println("M must be a power of 2. Exiting program.");
            return;
        }

        int maxCacheSize = N * M / 4;
        System.out.println("Enter K (cache size, must be a power of 2 and <= " + maxCacheSize + "):");
        int K = scanner.nextInt();
        if (!isPowerOfTwo(K) || K > maxCacheSize) {
            System.out.println("K must be a power of 2 and <= " + maxCacheSize + ". Exiting program.");
            return;
        }
        Memory memory = new Memory(N, M);
        Cache cache = new Cache(K);

        Algorithm.executeAlgorithm1(memory, cache);
        Algorithm.executeAlgorithm2(memory, cache);
        Algorithm.executeAlgorithm3(memory, cache);
    }

    private static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0 && x != 0;
    }
}
