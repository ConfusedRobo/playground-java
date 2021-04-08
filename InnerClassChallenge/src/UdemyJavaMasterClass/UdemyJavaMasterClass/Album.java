package UdemyJavaMasterClass;

import java.util.*;

public class Album {

    private final List<Song> songList;
    private final String albumTitle;

    public Album(String albumTitle) {

        songList = new ArrayList<>();
        this.albumTitle = albumTitle;

    }

    public void addSong(Song song) {

        songList.add(song);

    }

    public String getAlbumTitle() {

        return albumTitle;

    }

    public List<Song> getSongList() {

        return songList;

    }

}
