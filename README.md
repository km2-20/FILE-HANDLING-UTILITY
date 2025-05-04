# FILE-HANDLING-UTILITY

NAME: KALYANI SITARAM MAHAJAN

COMPANY: CODTECH IT SOLUTIONS

INTERN ID: CT04DA245

DOMAIN: JAVA PROGRAMMING

DURATION: 4 WEEKS

MENTOR: NEELA SANTOSH

OUTPUT: 
![Image](https://github.com/user-attachments/assets/6a409006-a06c-46cf-a1e1-4fdd1e41335b)

![Image](https://github.com/user-attachments/assets/0ffeac7e-0cd3-44ae-9114-748635418470)

![Image](https://github.com/user-attachments/assets/143b3138-d213-47a4-b83f-622efa8a3781)

DESCRIPTION:
The Java program is a simple *file handling utility* that performs:
1. Writing text to a file (`sample.txt`)
2. Reading contents from the file
3. Modifying specific text in the file (find and replace)

*Key Features in Code*

1. Modular Methods:
  * `writeFile(String content)` → Appends new content to the file.
  * `readFile()` → Reads and displays the file content.
  * `modifyFile(String oldText, String newText)` → Replaces occurrences of text.

2. Safe Handling :
  * Uses `try-with-resources` to safely manage file and input streams.
  * Validates file existence before reading or modifying.
  * Handles exceptions and invalid input gracefully.

The sample output shows a user:
1. Writing a line to the file: `"Hello, this is a test line."`
2. Reading the file — confirms the line was written.
3. Modifying `"test"` to `"sample"` — then reading the file again.
4. Exiting the program cleanly.

*Conclusion*
This is a beginner-friendly, interactive CLI tool demonstrating *basic file I/O*, *string manipulation*, and *exception handling* in Java. The output confirms each operation behaves as expected.

