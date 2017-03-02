package de.lebk.songdb.data_store;

import de.lebk.songdb.song.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sopaetzel
 */
public class DataStore {
    private static DataStore ourInstance = new DataStore();
    private List<Song> songList = new ArrayList<>();
    private int index;

    public static DataStore getInstance() {
        return ourInstance;
    }

    private DataStore() {
    }


    public void getSongAt(int position) {

    }


    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Song getSongByTitle(String songTitle) {
        Iterator<Song> songIterator = songList.iterator();
        Song song;

        while (songIterator.hasNext()) {
            song = songIterator.next();
            if (songTitle.equalsIgnoreCase(song.getSongTitle())) {
                return song;
            }

        }
        return null;

    }
}
