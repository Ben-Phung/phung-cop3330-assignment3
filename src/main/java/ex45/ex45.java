/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Ben Phung
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Prompt for name of output file
    Initialize in and out files
    Scan infile while it has a next line
    Replace all instances of utilize to use
    Write in outfile
 */

public class ex45 {
    public static void main( String[] args) throws IOException {
        String outName = prompt();
        outFile(outName);
    }
    // Method to scan for name
    public static String prompt()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Output file name: ");
        return scan.nextLine();
    }
    // Write out put file
    public static void outFile(String fileName) throws IOException
    {
        File inputFile = new File("src\\main\\java\\ex45\\exercise45_input.txt");
        try (Scanner scan = new Scanner(inputFile)) {
            FileWriter writeOut = new FileWriter("src\\main\\java\\ex45\\"+fileName+".txt");
            // Run through infile
            while (scan.hasNextLine()) {
                String words = scan.nextLine();
                // Replace all utilize with use
                words = words.replaceAll("utilize", "use");
                writeOut.write(words);
                writeOut.write("\n");
            }
            // Close outfile
            writeOut.close();
        }
    }
}