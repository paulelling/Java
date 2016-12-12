package Utility;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class FileManager {    
    
    public static void appendToFile(String filePath, String text) {
        appendFile(filePath, System.lineSeparator());
        appendFile(filePath, text);
    }
    
    public static void appendToFileAddLine(String filePath, String text) {
        appendFile(filePath, text);
        appendFile(filePath, System.lineSeparator());
    }
    
    public static void updateLine(String filePath, int lineNumber, String flag) {
        
        try {            
            List<String> lines = Files.readAllLines(Paths.get(filePath), Constants.charset);
            String lineToUpdate = lines.get(lineNumber);
            lineToUpdate = lineToUpdate.substring(0, lineToUpdate.lastIndexOf(";") + 1) + " " + flag;
            deleteFileContent(filePath);
            
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (i == lineNumber) {
                    line = lineToUpdate;
                }
                appendToFileAddLine(filePath, line);
            }
            
        }catch (IOException e) {
            System.out.println("Utility.FileManager.updateLine Exception: " + e.getMessage());
        }    
    }
    
    public static String getLine(String filePath) {
        String line = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), Constants.charset);
            line = lines.get(0);
        }catch (IOException e) {
            System.out.println("Utility.FileManager.getAllLines Exception: " + e.getMessage());
        }      
        return line;
    }
    
    public static List<String> getAllLines(String filePath) {
        List<String> lines = null;        
        try {
            lines = Files.readAllLines(Paths.get(filePath), Constants.charset);
        }catch (IOException e) {
            System.out.println("Utility.FileManager.getAllLines Exception: " + e.getMessage());
        }
        return lines;
    }
    
    public static int getLineCount(List<String> lines) {
        return lines.size();
    }
    
    public static void deleteFileContent(String filePath) {
        try {            
            PrintWriter pw = new PrintWriter(filePath);
            pw.close();            
        }catch (IOException e) {
            System.out.println("Utility.FileManager.deleteFileContent Exception: " + e.getMessage());
        }    
    }     
    
    public static void overwriteFile(String filePath, String text) {
        try {            
            deleteFileContent(filePath);
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.WRITE);
        }catch (IOException e) {
            System.out.println("Utility.FileManager.overwriteFile Exception: " + e.getMessage());
        }    
    }    
    
    private static void appendFile(String filePath, String text) {
        try {
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Utility.FileManager.appendToFile Exception: " + e.getMessage());
        }    
    }
    
}
