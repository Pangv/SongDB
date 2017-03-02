package de.lebk.songdb.db_connection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sopaetzel
 */
public class InitDatabase {

    Statement statement;


    /*+++++++++++++++++++++++++++++
    +  CREATE TABLES
     ++++++++++++++++++++++++++++++*/
    public void createTables() throws SQLException {
        String table = "Song";

        ManageDatabase mdb = new ManageDatabase();

        statement = DatabaseConnection.getInstance().getConnection().createStatement();

        String dropTable = "DROP TABLE IF EXISTS " + table + ";";
        statement.executeUpdate(dropTable);
        System.out.println("Table dropped");

        String createTable = "CREATE TABLE IF NOT EXISTS " + table
                + " (SONG VARCHAR(76) PRIMARY KEY NOT NULL, SINGER VARCHAR(255) NOT NULL)";

        statement.executeUpdate(createTable);

        System.out.println("Table created");


        statement.executeUpdate(mdb.mergeRow(table, "Delta", "C2C"));
        statement.executeUpdate(mdb.mergeRow(table, "Sonnentanz", "Klangkarussel"));
        statement.executeUpdate(mdb.mergeRow(table, "Fiction", "The XX"));
        statement.executeUpdate(mdb.mergeRow(table, "Sun and Moon", "Above & Beyond"));

        System.out.println("Lines inserted");
        System.out.println("==============\n");

    }



}
