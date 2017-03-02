package de.lebk.songdb.song;

/**
 * @author sopaetzel
 */
public class Song {

    private String songTitle;
    private String singer;

    public Song(String songTitle, String singer) {
        this.songTitle = songTitle;
        this.singer = singer;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
