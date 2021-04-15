package UdemyJavaMasterClass;

import java.util.ArrayList;

public class Album {

    private final String title;
    private ArrayList<Song> songs;

    public Album(String title) {

        this.title = title;

    }

    public ArrayList<Song> getSongs() {

        return songs;

    }

    public String getTitle() {

        return title;

    }

    public void setSongs(ArrayList<Song> songs) {

        this.songs = songs;

    }

    public Song checkIfAvail(String title) {

        int i = 0;
        while (i < songs.size()) {

            if (songs.get(i).getTitle().equals(title))
                return songs.get(i);

            i++;

        }

        return null;

    }

    public boolean isSongTitle(String title) {

        int i = 0;
        while (i < songs.size()) {

            if (songs.get(i).getTitle().equals(title))
                return true;

            i++;

        }

        return false;

    }

}
