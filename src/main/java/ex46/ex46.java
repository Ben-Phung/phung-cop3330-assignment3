/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Ben Phung
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
    Create input file
    Initialize map
    Using strings from input files to count frequency of each string
    Print histogram with largest string count on top
 */

public class ex46 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        readFile(map);
        print(map);
    }

    public static void readFile(Map<String, Integer> map) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("src\\main\\java\\ex46\\exercise46_input.txt"));
        while(scan.hasNext())
        {
            String string = scan.next();
            if (map.containsKey(string))
            {
                map.put(string, map.get(string) +1);
            }
            else
            {
                map.put(string, 1);
            }
        }
    }

    public static void print(Map<String, Integer> map)
    {
        for(String key: map.keySet())
        {
            System.out.printf("%-10s", key+":");
            for (int i = map.get(key); i > 0; i--)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }
}