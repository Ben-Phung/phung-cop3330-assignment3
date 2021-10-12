/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Ben Phung
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Declare infile
    Read/scan file by splitting each input between commas
    Apply different inputs to different indexes
    Print
 */

public class ex42 {
    public static void main( String[] args) throws FileNotFoundException {
        printHeader();
        readFile();
    }
    public static void readFile() throws FileNotFoundException {
        // Read file
        Scanner scan = new Scanner(new File("src\\main\\java\\ex42\\exercise42_input.txt"));
        String[] string;
        // While
        while(scan.hasNext()){
            // Inputs are split by commas in the input file
            string = scan.nextLine().split(",");
            System.out.printf( "%-10s%-10s%-10s\n", string[0], string[1], string[2]);
        }
    }
    // Prints header
    public static void printHeader(){
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");
    }
}