package Control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Control {
    private static String printAnswer(double firstNumber, String operationSign, double secondNumber, double answer) {
        String content = firstNumber + " " + operationSign + " " + secondNumber + " = " + answer;
        System.out.println(content);
        return content;
    }

    private static void writeToFile(Path path, String content) throws IOException {
        Files.writeString(path, content + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

    public static void readFile(Scanner scanner, Path path, int lines) throws IOException {
        while (scanner.hasNext()) {
            double firstNumber = Double.parseDouble(scanner.next());
            String operationSign = scanner.next();
            double secondNumber = Double.parseDouble(scanner.next());
            double answer = 0;
            switch (operationSign) {
                case "+" -> answer = firstNumber + secondNumber;
                case "-" -> answer = firstNumber - secondNumber;
                case "/" -> answer = firstNumber / secondNumber;
                case "*" -> answer = firstNumber * secondNumber;
            }
            String content = Control.printAnswer(firstNumber, operationSign, secondNumber, answer);
            Control.writeToFile(path, content);
            lines++;
        }
    }
}