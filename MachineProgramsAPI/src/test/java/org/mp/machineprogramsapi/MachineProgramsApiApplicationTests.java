package org.mp.machineprogramsapi;

import org.junit.jupiter.api.Test;
import org.mp.machineprogramsapi.repository.Database;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MachineProgramsApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void addition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void firstName() throws ParserConfigurationException, IOException, SAXException {
        Database database = new Database();
        String firstName = database.GetFirstName();
        assertEquals("Kate", firstName);
    }
}
