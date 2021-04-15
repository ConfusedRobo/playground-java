package UdemyJavaMasterClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static final Scanner scannerObject = new Scanner(System.in);
    private static final LinkedList<Song> playlist = new LinkedList<>();
    private static final Album kamikaze = new Album("Kamikaze");
    private static final Album ronin = new Album("Ronin");

    public static void main(String[] args) {

        database();
        boolean quit = false;
        boolean play = false;
        ListIterator<Song> songListIterator = playlist.listIterator();

        printMenu();
        while (!quit) {

            System.out.println("Enter your choice: ");
            int choice = scannerObject.nextInt();
            scannerObject.nextLine();
            switch (choice) {

                case 0:
                    printMenu();
                    break;

                case 1:
                    if (!play) {

                        System.out.println("Start playing first!");
                        break;

                    }

                    if (songListIterator.hasNext()) {

                        Song song = songListIterator.next();
                        System.out.println("Changed. Now playing:");
                        System.out.println(song.getTitle()
                                + "\t" + song.getDuration());

                    } else
                        System.out.println("You have reached the end of the playlist!");

                    break;

                case 2:
                    if (!play) {

                        System.out.println("Start playing first!");
                        break;

                    }

                    if (songListIterator.hasPrevious()) {

                        Song song = songListIterator.previous();
                        System.out.println("Changed. Now playing:");
                        System.out.println(song.getTitle()
                                + "\t" + song.getDuration());

                    } else
                        System.out.println("You have reached the start of the playlist!");

                    break;

                case 3:
                    if (playlist.isEmpty()){

                        System.out.println("Playlist is empty!");
                        break;

                    }

                    System.out.println("Replaying playlist!");
                    System.out.println("Now playing:");
                    songListIterator = playlist.listIterator();

                    break;

                case 4:
                    if (playlist.isEmpty()) {

                        System.out.println("Playlist is empty!");
                        break;

                    }

                    printPlaylist();
                    System.out.println("Enter song number: ");
                    int songNumber = scannerObject.nextInt();

                    if (songNumber <= playlist.size() && songNumber >= 0) {

                        playlist.remove(songNumber);
                        songListIterator = playlist.listIterator();
                        System.out.println("Song removed!");
                        System.out.println("New playlist: ");
                        printPlaylist();

                    } else
                        System.out.println("Out of bounds!");

                    break;

                case 5:
                    printTotalList();
                    System.out.println("Type in the song's title: ");
                    String songTitle = scannerObject.nextLine();

                    if (kamikaze.isSongTitle(songTitle)) {

                        playlist.add(kamikaze.checkIfAvail(songTitle));
                        songListIterator = playlist.listIterator();
                        System.out.println("Song added!");

                    } else if (ronin.isSongTitle(songTitle)) {

                        playlist.add(ronin.checkIfAvail(songTitle));
                        songListIterator = playlist.listIterator();
                        System.out.println("Song added!");

                    } else
                        System.out.println("Song not found!");

                    break;

                case 6:
                    if (playlist.isEmpty()) {

                        System.out.println("Playlist is empty!");
                        break;

                    }

                    if (!play) {

                        play = true;
                        System.out.println("Playing!");

                    } else {

                        play = false;
                        System.out.println("Paused!");

                    }

                    break;

                case 7:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry!");

            }

        }

    }

    private static void printTotalList() {

        System.out.println("Albums and songs: ");

        System.out.println("Album: " + kamikaze.getTitle());
        for (int i = 0; i < kamikaze.getSongs().size(); i++)
            System.out.println(i + ". " + kamikaze.getSongs().get(i).getTitle()
                    + "\t" + kamikaze.getSongs().get(i).getDuration());

        System.out.println();

        System.out.println("Album: " + ronin.getTitle());
        for (int i = 0; i < ronin.getSongs().size(); i++)
            System.out.println(i + ". " + ronin.getSongs().get(i).getTitle()
                    + "\t" + ronin.getSongs().get(i).getDuration());

    }

    private static void printPlaylist() {

        if (playlist.isEmpty()) {

            System.out.println("Playlist is empty!");
            return;

        }

        ListIterator<Song> songListIterator = playlist.listIterator();
        System.out.println("Playlist contains: ");

        while (songListIterator.hasNext()) {

            Song song = songListIterator.next();

            System.out.println(songListIterator.nextIndex() - 1 + ". "
                    + song.getTitle() + "\t"
                    + song.getDuration());

        }


    }

    private static void printMenu() {

        System.out.println("Playlist options");
        System.out.println("0. Reprint menu");
        System.out.println("1. Skip forward to the next song");
        System.out.println("2. Skip backward to the previous song");
        System.out.println("3. Replay song");
        System.out.println("4. Remove a song from the playlist");
        System.out.println("5. Add a song to the playlist");
        System.out.println("6. Start playing");
        System.out.println("7. Quit application");

    }

    private static void database() {

        ArrayList<Song> tempVarK = new ArrayList<>();

        tempVarK.add((new Song("The Ringer", "5:37")));
        tempVarK.add((new Song("Greatest", "3:46")));
        tempVarK.add((new Song("Lucky You(feat Joyner Lucas)", "4:04")));
        tempVarK.add((new Song("Paul - Skit", "0:35")));
        tempVarK.add((new Song("Normal", "3:42")));
        tempVarK.add((new Song("Em Calls Paul - Skit", "0:49")));
        tempVarK.add((new Song("Stepping Stone", "5:09")));
        tempVarK.add((new Song("Not Alike(feat Royce Da 5'9'')", "4:48")));
        tempVarK.add((new Song("Kamikaze", "3:36")));
        tempVarK.add((new Song("Fall", "4:22")));
        tempVarK.add((new Song("Nice Guy(with Jessie Reyez)", "2:30")));
        tempVarK.add((new Song("Good Guy", "2:22")));
        tempVarK.add((new Song("Venom - From The Motion Picture", "4:29")));

        kamikaze.setSongs(tempVarK);

        ArrayList<Song> tempVarR = new ArrayList<>();

        tempVarR.add((new Song("Don't Get in My Way", "6:48")));
        tempVarR.add((new Song("Slave", "4:39")));
        tempVarR.add((new Song("Nice to Meet Me", "6:17")));
        tempVarR.add((new Song("Go Silent", "5:04")));
        tempVarR.add((new Song("Silver Crimson Black", "6:48")));
        tempVarR.add((new Song("Greeting the Menace", "4:26")));
        tempVarR.add((new Song("I Can Get It Back", "7:37")));
        tempVarR.add((new Song("Fade Away", "5:55")));
        tempVarR.add((new Song("Teachings of a Ronin", "5:12")));
        tempVarR.add((new Song("The Zoo", "5:33")));

        ronin.setSongs(tempVarR);

    }

}
