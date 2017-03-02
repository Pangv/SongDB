package de.lebk.songdb.app;

import de.lebk.songdb.db_connection.DatabaseConnection;
import de.lebk.songdb.db_connection.InitDatabase;
import de.lebk.songdb.db_connection.ManageDatabase;
import de.lebk.songdb.gui.SongUI;

import java.sql.SQLException;

/**
 * @author sopaetzel
 */
public class App {

    public static void main(String[] args) {
        SongUI.main(args);


        try {
            DatabaseConnection.getInstance().openConnection();

            new InitDatabase().createTables();
            new ManageDatabase().getResult("song");
            DatabaseConnection.getInstance().closeConnection();


        } catch (SQLException e) {
            System.err.println("SQL konnte nicht ausgeführt werden");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Treiber nicht gefunden");
        } finally {
            if (DatabaseConnection.getInstance().getConnection() != null) {
                try {
                    DatabaseConnection.getInstance().closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
