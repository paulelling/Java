package org.mp.machineprogramsapi.repository;

import org.mp.machineprogramsapi.Configuration;
import org.mp.machineprogramsapi.Logging;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;

public class Database {

    private String connectionString;
    private Logging logging;

    public Database() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        connectionString = cfg.GetDatabaseConnectionString();
        logging = new Logging();
    }

    public String GetFirstName() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String sql = "SELECT FirstName FROM Users";
            ResultSet rs = stmt.executeQuery(sql);
            String firstName = "";

            if (rs.next()) {
                firstName = rs.getString("FirstName");
            }

            return firstName;
        } catch (SQLException e) {
            logging.Write(e.getMessage());
            return null;
        }
    }
}
