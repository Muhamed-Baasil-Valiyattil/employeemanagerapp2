package com.litmus7.employeemanager.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
* Handles raw I/O opeartions like write , read and append
* 
*/

public class TextFileUtil {

    /**
    * read raw data from text file
    * file is read from specific path if user has specified the path , else a pre-defined path is used
    *
    * @param filepath filepath to .txt file , if it's empty path TEXT_FILE_PATH is used as default path.
    * @throws IOException In case error occurs during opening or reading of file
    * @return lines , list of Strings read from file, each String is a line in file
    */

    public static List<String> getdataFromFile(String filepath) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(filepath.trim()));
        List<String> lines = new ArrayList<>();
        
        String line;

        while ((line = reader.readLine()) != null) {

            lines.add(line);
            
        }
        reader.close();
        return lines;
	   
    }
    

    /**
    * write list of lines of String type into a default file (csv file)
    * file is overwritten
    * @param lines list of String (lines) to write to file
    * @param filePath path of file to write the data
    * @throws IOException In case error occurs during opening or writing to file
    */

    public static void writeDataToFile(List<String> lines , String filePath) throws IOException{

        PrintWriter writer = new PrintWriter(filePath);

        for (String line : lines) {

            writer.printf(line);
            
        }
        writer.close();

    }

    /**
    * write list of lines of String type into a default file (csv file)
    * file is appended
    *
    * @param line String that is appended to file
    * @param filePath path of file to append the data
    * @throws IOException In case error occurs during opening or writing to file
    */

    public static void appendDataToFile(String line , String filePath) throws IOException{

        PrintWriter writer = new PrintWriter(new FileWriter(filePath,true));
        writer.printf(line);     
        writer.close();

    }


}
