import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== File Handling Utility =====");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Write to file");
            System.out.println("2. Read file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter text to write to file:");
                    String textToWrite = scanner.nextLine();
                    writeFile(textToWrite);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    System.out.println("Enter text to replace:");
                    String oldText = scanner.nextLine();
                    System.out.println("Enter new text:");
                    String newText = scanner.nextLine();
                    modifyFile(oldText, newText);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }

    // Write text to file
    private static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Content written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read text from file
    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nContents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found! Create one by writing to it.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Modify text in file
    private static void modifyFile(String oldText, String newText) {
        try {
            File file = new File(FILE_PATH);
            String content = new String(Files.readAllBytes(file.toPath()));
            content = content.replaceAll(oldText, newText);
            Files.write(file.toPath(), content.getBytes());
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
