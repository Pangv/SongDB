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

        //String dropTable = "DROP TABLE IF NOT EXIST" + table;
        //statement.executeUpdate(dropTable);

        String createTable = "CREATE TABLE IF NOT EXISTS " + table
                + " (SONG VARCHAR(76) PRIMARY KEY NOT NULL, SINGER VARCHAR(255) NOT NULL)";

        statement.executeUpdate(createTable);



        statement.executeUpdate(mdb.mergeRow(table, "Delta", "C2C"));
        statement.executeUpdate(mdb.mergeRow(table, "Sonnentanz", "Klangkarussel"));
        statement.executeUpdate(mdb.mergeRow(table, "Fiction", "The XX"));
        statement.executeUpdate(mdb.mergeRow(table, "Sun and Moon", "Above & Beyond"));

    }



}
