package de.lebk.songdb.db_connection;

import de.lebk.songdb.data_store.DataStore;
import de.lebk.songdb.song.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sopaetzel
 */
public class ManageDatabase {

    Statement statement;

    public ResultSet getResult(String... vals) throws SQLException {
        statement = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet selectRS = statement.executeQuery("SELECT * FROM " + vals[0]);
        System.out.println("Result-Set: ");
        System.out.println("==============\n");
        while (selectRS.next()) {
            System.out.printf("%s, %s\n", selectRS.getString(1),
                    selectRS.getString(2));
            DataStore.getInstance().getSongList().add(new Song(selectRS.getString(1), selectRS.getString(2)));
        }
        System.out.println("");
        return selectRS;
    }


    public String mergeRow(String table, String name, String singer) throws SQLException {
        statement = DatabaseConnection.getInstance().getConnection().createStatement();
        return "MERGE INTO " + table + " VALUES('" + name + "', '" + singer + "');";
    }


}
