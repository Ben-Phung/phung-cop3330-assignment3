/*
 * UCF COP3330 Fall 2021 Assignment 3 Solution
 * Copyright 2021 Ben Phung
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    Prompt user
    Store inputs for each question to pass into other functions
    Create folders for js and css if user enters y

 */

public class ex43 {
    public static String site;
    public static String author;
    public static char jScript;
    public static char css;

    public static void main( String[] args) throws IOException {
        prompt();
        directories(site, jScript, css, author);
        print(site, jScript, css);
    }

    public static void prompt(){
        System.out.print( "Site name: " );
        Scanner siteInput = new Scanner(System.in);
        site = siteInput.nextLine();

        System.out.print( "Author: " );
        Scanner authorInput = new Scanner(System.in);
        author = authorInput.nextLine();

        System.out.print( "Do you want a folder for JavaScript? (y or n) " );
        Scanner jsInput = new Scanner(System.in);
        jScript = jsInput.nextLine().toLowerCase().charAt(0);

        System.out.print( "Do you want a folder for CSS? (y or n) " );
        Scanner cssInput = new Scanner(System.in);
        css = cssInput.nextLine().toLowerCase().charAt(0);
    }

    public static void directories(String sName, char jFolder, char cFolder, String aName) throws IOException{
        jFolder = Character.toLowerCase(jFolder);
        cFolder = Character.toLowerCase(cFolder);

        String dPath = "src/main/java/ex43/website/" +sName;

        // Use mkdirs to create directories
        File file = new File(dPath);
        file.mkdirs();

        indexHTML(dPath, sName, aName);

        //
        if (jFolder == 'y')
        {
            File file3 = new File(dPath+ "/js");
            file3.mkdir();
        }

        if (cFolder == 'y')
        {
            File file4 = new File(dPath+ "/css");
            file4.mkdir();
        }

    }

    public static void indexHTML(String pathPlacement, String website, String creator) throws IOException
    {
        String path = pathPlacement + "/index.html";
        FileWriter writeIndex = new FileWriter(path);

        writeIndex.write("<!DOCTYPE html>\n<html>\n\n<head>\n");
        writeIndex.write("\t<meta author=\"" +creator+ "\">\n");
        writeIndex.write("\t<title>" +website+ "</title>\n");
        writeIndex.write("</head>\n\n<body>\n</body>\n\n</html>");

        writeIndex.close();

    }


    // Print output
    public static void print(String siteName, char jFolder, char cFolder){
        System.out.println("Created ./website/" +siteName);
        System.out.println("Created ./website/" +siteName+ "/index.html");

        if (jFolder == 'y')
        {
            System.out.println("Created ./website/" +siteName+ "/js");
        }

        if (cFolder == 'y')
        {
            System.out.println("Created ./website/" +siteName+ "/css");
        }
    }
}