/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Ben Phung
 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
    Declare input and output file
    Read infile
    Don't hard code number of names, use array list
    Sort list of names alphabetically using collections.sort
    Print into outfile
    Close files
 */

public class ex41 {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner infile = new Scanner(new File("src\\main\\java\\ex41\\exercise41_input.txt"));

        // Array list to avoid hard coding amount of names
        ArrayList<String> names = new ArrayList<String>();

        readFile(infile, names);
        // Sort names
        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        infile.close();

        try {
            outputFile(names);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readFile(Scanner scan, ArrayList<String> nameList)
    {
        // Scan file
        while (scan.hasNextLine())
        {
            nameList.add(scan.nextLine());
        }
    }

    public static void outputFile(ArrayList<String> nameList) throws IOException
    {
        FileWriter output = new FileWriter("src\\main\\java\\ex41\\exercise41_output.txt");
        // Write in output
        output.write("Total of " + nameList.size() + " names\n");
        output.write("-----------------\n");

        for (String name : nameList)
        {
            output.write(name + "\n");
        }
        output.close();
    }




}
