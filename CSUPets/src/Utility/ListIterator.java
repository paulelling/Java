package Utility;

import java.util.*;

public class ListIterator implements Iterator {
    List<FileLine> lines;
    int position = 0;

    public ListIterator(List<FileLine> lines) {
        this.lines = lines;
    }

    public FileLine next() {
        FileLine line = lines.get(position);
        position = position + 1;
        return line;
    }

    public boolean hasNext() {
        if (position >= lines.size()) {
            return false;
        } else {
            return true;
        }
    }    
}
