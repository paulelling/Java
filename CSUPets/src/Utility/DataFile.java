package Utility;

import java.util.*;

public class DataFile implements File {
    List<FileLine> fileLines;
    
    public DataFile(List<FileLine> fileLines) {
        this.fileLines = fileLines;
    }
    
    public void addLine(String line) {
        FileLine fileLine = new FileLine(line);
        fileLines.add(fileLine);
    }
    
    public List<FileLine> getFileLines() {
        return fileLines;
    }

    public Iterator createIterator() {
        return new ListIterator(fileLines);
    }    
    
}
