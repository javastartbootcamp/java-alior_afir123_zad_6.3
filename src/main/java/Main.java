import Control.Control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        File inputFile = new File("operations.txt");
        Path path = Path.of("answer.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            int lines = 0;
            Control.readFile(scanner, path, lines);
        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Błędne dane. Program zakończony.");
        }
    }
}