// Import libraries
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* This program uses selection sort and files.
* It will sort all the numbers in each line.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-04-14
*/

// Creating class
public final class SelectSort {

    /**
     * SPACE is simply just a space.
     */
    private static final String SPACE = " ";

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private SelectSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - Input/Output exception
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Write output string to output file
        final FileWriter myWriter = new FileWriter("output.txt");

        // Introduce program to user
        System.out.println("This sorts a file of numbers"
            + " using selection sort.");

        // Pass the path to the file as a parameter
        final File file = new File("./input.txt");
        final Scanner scanner = new Scanner(file);

        // Loop while there's another line in the file'
        while (scanner.hasNextLine()) {

            // Assign current line to variable
            final String line = scanner.nextLine();

            // Split line into array of strings
            final String[] lineArrayStr = line.split(SPACE);

            // Perform selection sort
            for (int pass = 0; pass < lineArrayStr.length - 1; pass++) {
                // Assign minimum to first element
                int min = pass;

                // Loop through array
                for (int index = pass + 1; index
                    < lineArrayStr.length; index++) {

                    // Check if current element is less than minimum
                    if (Integer.parseInt(lineArrayStr[index])
                        < Integer.parseInt(lineArrayStr[min])) {

                        // Assign current element to minimum
                        min = index;
                    }
                }
                // Swap minimum with current element
                if (min != pass) {
                    final String temp = lineArrayStr[pass];
                    lineArrayStr[pass] = lineArrayStr[min];
                    lineArrayStr[min] = temp;
                }
            }

            // Write sorted line to output string
            for (int counter = 0; counter < lineArrayStr.length; counter++) {
                // Add number to output string
                outputStr += lineArrayStr[counter] + SPACE;
            }
            // Add new line to output string
            outputStr += "\n";

            // Write to output file
            myWriter.write(outputStr);

            // Reset output string
            outputStr = "";
        }

        // Close scanner
        scanner.close();

        // Close writer
        myWriter.close();
    }
}
