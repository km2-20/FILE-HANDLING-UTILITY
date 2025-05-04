import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class FileHandler {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        System.out.println("===== File Handling Utility =====");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Write to file");
                System.out.println("2. Read file");
                System.out.println("3. Modify file");
                System.out.println("4. Exit");

                try {
                    int choice = Integer.parseInt(scanner.nextLine().trim());

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter text to write to file:");
                            String textToWrite = scanner.nextLine();
                            writeFile(textToWrite);
                        }
                        case 2 -> readFile();
                        case 3 -> {
                            System.out.println("Enter text to replace:");
                            String oldText = scanner.nextLine();
                            System.out.println("Enter new text:");
                            String newText = scanner.nextLine();
                            modifyFile(oldText, newText);
                        }
                        case 4 -> {
                            running = false;
                            System.out.println("Exiting... Thank you!");
                        }
                        default -> System.out.println("Invalid choice! Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }
        }
    }

    private static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_PATH, true), StandardCharsets.UTF_8))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Content written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist. Please write something first.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            System.out.println("\nContents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void modifyFile(String oldText, String newText) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist. Please write something first.");
            return;
        }

        try {
            String content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            if (!content.contains(oldText)) {
                System.out.println("The text to be replaced was not found.");
                return;
            }

            content = content.replace(oldText, newText);
            Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
