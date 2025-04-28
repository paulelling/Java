package org.mp.machineprogramsapi;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logging {

    private String logFile;

    public Logging() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        logFile = cfg.GetLogFile();
    }

    public void Write(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
