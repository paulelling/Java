package Utility;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class DataFileManager extends FileManager {
    
    
    public static void updateLine(String filePath, int lineNumber, String flag) {
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), Constants.charset);
            String lineToUpdate = lines.get(lineNumber);
            lineToUpdate = lineToUpdate.substring(0, lineToUpdate.lastIndexOf(";") + 1) + " " + flag;
//            deleteFileContent(filePath);      

            List<FileLine> fileLines = null;

            for (int i = 0; i < lines.size(); i++) {
                fileLines.add(new FileLine(lines.get(i)));
            }

            DataFile dataFile = new DataFile(fileLines);

            Iterator fileIterator = dataFile.createIterator();
            
            int i = 0;
            
            while (fileIterator.hasNext()) {
                FileLine fileLine = fileIterator.next();
                String line = fileLine.getLine();
                
                if (i == lineNumber) {
                    line = lineToUpdate;
                }
                
//                appendToFileAddLine(filePath, line);
                
                i++;
            }    
            
        }catch (IOException e) {
            System.out.println("Utility.FileManager.updateLine Exception: " + e.getMessage());
        }    
    }    
    
}
