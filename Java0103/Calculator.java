import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean programTerminate = true;

        System.out.printf("List of operations: add subtract multiply divide alphabetize\n");
        System.out.printf("Enter an operation:\n");
        String command = input.next().toLowerCase();

        switch (command) {
            case "add":
            case "subtract":
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int inputA = input.nextInt();
                    if (input.hasNextInt()) {
                        int inputB = input.nextInt();
                        int output = 0;
                        if (command.equals("add")) {
                            output = inputA + inputB;
                        } else if (command.equals("subtract")) {
                            output = inputA - inputB;
                        }
                        System.out.println("Answer: " + output);
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "multiply":
            case "divide":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double inputA = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double inputB = input.nextDouble();
                        double output = 0;
                        if (command.equals("multiply")) {
                            output = inputA * inputB;
                            System.out.printf("Answer: %.2f", output);
                        } else if (command.equals("divide") && inputB != 0) {
                            output = inputA / inputB;
                            System.out.printf("Answer: %.2f", output);
                        } else if (command.equals("divide") && inputB == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "alphabetize":
                System.out.println("Enter two words:");
                if (input.hasNext()) {
                    String inputA = input.next();
                    if (input.hasNext()) {
                        String inputB = input.next();
                        int output = inputA.compareTo(inputB);
                        if (output == 0) {
                            System.out.printf("Answer: Chicken or Egg.\n");
                        } else if (output > 0) {
                            System.out.printf("Answer: %s comes before %s alphabetically.\n", inputB, inputA);
                        } else if (output < 0) {
                            System.out.printf("Answer: %s comes before %s alphabetically.\n", inputA, inputB);
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
    }
}
