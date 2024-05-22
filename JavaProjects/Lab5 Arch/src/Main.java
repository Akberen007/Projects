import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.moveinment;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> variables = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue; // Пропуск пустых строк
            }
            String[] tokens = line.split("\\s+", 3); // Разбиваем строку на три токена (максимум)

            if (tokens.length < 2) {
                System.err.println("Invalid input format.");
                continue; // Пропускаем строки с неверным форматом
            }

            if (tokens[1].equals("DB")) {
                String varName = tokens[0];
                String value = tokens[2].replaceAll("'", ""); // Удаляем одинарные кавычки
                variables.put(varName, value);
            }else if (tokens[0].equals("ADD")) {
                String var1 = tokens[1];
                String var2 = tokens[2];
                if (!variables.containsKey(var1) || !variables.containsKey(var2)) {
                    System.err.println("Invalid argument.");
                    continue;
                }
                int result = Integer.parseInt(variables.get(var1),10) + Integer.parseInt(variables.get(var2), 10);
                System.out.println(Integer.toHexString(result).toUpperCase());
            } else if (tokens[0].equals("INC")) {
                String var = tokens[1];
                if (!variables.containsKey(var)) {
                    System.err.println("Invalid argument.");
                    continue;
                }
                int result = Integer.parseInt(variables.get(var), 10) + 1;
                System.out.println(Integer.toHexString(result).toUpperCase());
                break;
            }else if (tokens[0].equals("SUB")) {
                String var1 = tokens[1];
                String var2 = tokens[2];
                if (!variables.containsKey(var1) || !variables.containsKey(var2)) {
                    System.err.println("Куда бежишь молодой.");
                    continue;
                }
                BigInteger result = new BigInteger(variables.get(var1).replaceAll("h", ""), 16)
                        .subtract(new BigInteger(variables.get(var2).replaceAll("h", ""), 16));
                System.out.println(result.toString(16).toUpperCase() + "h");
                break;
            }else if (tokens[0].equals("MOV")) {
                String var1 = tokens[1];
                String var2 = tokens[2];
                if (!variables.containsKey(var2)) {
                    System.err.println("Invalid argument.");
                    continue;
                }
                variables.put(var1, variables.get(var2));
                System.out.println(variables.get(var1));
                break;
            }else if (tokens[0].equals("MUL"))
            {
                String var1 = tokens[1];
                String var2 = tokens[2];
                if (!variables.containsKey(var1) || !variables.containsKey(var2)){
                    System.err.println("Invalid argument.");
                    continue;
                }
                int result = Integer.parseInt(variables.get(var1),10) * Integer.parseInt(variables.get(var2), 10);
                System.out.println(Integer.toHexString(result).toUpperCase());
            }

        }
    }
}
