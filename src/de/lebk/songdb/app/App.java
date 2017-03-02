package de.lebk.songdb.app;

import de.lebk.songdb.data_store.DataStore;
import de.lebk.songdb.db_connection.DatabaseConnection;
import de.lebk.songdb.db_connection.InitDatabase;
import de.lebk.songdb.db_connection.ManageDatabase;
import de.lebk.songdb.gui.SongUI;
import de.lebk.songdb.song.Song;

import java.sql.SQLException;
import java.util.Iterator;

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

            DatabaseConnection.getInstance().getMetaInformation();
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


        Iterator<Song> songIterator = DataStore.getInstance().getSongList().iterator();
        Song song;

        System.out.println("Objekte: ");
        System.out.println("==============\n");
        while (songIterator.hasNext()){
            song = songIterator.next();


            System.out.println(song.getSongTitle() + " " + song.getSinger());
        }


    }

}
