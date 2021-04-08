package UdemyJavaMasterClass;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final  Album nightCall = new Album("Nightcall");
    private static final  Album answerLove = new Album("Answer Love");

    public static void main(String[] args) {

        Main.SongList myPlaylist = new Main.SongList();

        database();
        boolean quit = false;
        int choice;

        System.out.println("Playlist options:-");
        printMenu();
        while (!quit) {
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Add from the following:\n" +
                                       "Press");
                    System.out.println("1. " + nightCall.getAlbumTitle());
                    System.out.println("2. " + answerLove.getAlbumTitle());
                    System.out.print("Your choice: ");
                    choice = scanner.nextInt();

                    if (choice == 1) {
                        System.out.println("Press");
                        for (int i = 0; i < nightCall.getSongList().size(); i++)
                            System.out.println(i + ". Title: " + nightCall.getSongList().get(i).getSongTitle() +
                                    "              Duration: " + nightCall.getSongList().get(i).getSongDuration());

                        System.out.print("Your choice: ");
                        choice = scanner.nextInt();

                        if (choice > -1 && choice < nightCall.getSongList().size()) {

                            myPlaylist.addToPlaylist(nightCall.getSongList().get(choice));
                            System.out.println("\n\nSong added!");

                        } else {
                            System.out.println("Invalid choice!");
                        }

                    } else if (choice == 2) {
                        System.out.println("Press");
                        for (int i = 0; i < answerLove.getSongList().size(); i++)
                            System.out.println(i + ". Title: " + answerLove.getSongList().get(i).getSongTitle() +
                                    "              Duration: " + answerLove.getSongList().get(i).getSongDuration());

                        System.out.print("Your choice: ");
                        choice = scanner.nextInt();

                        if (choice > -1 && choice < answerLove.getSongList().size()) {

                            myPlaylist.addToPlaylist(answerLove.getSongList().get(choice));
                            System.out.println("\n\nSong added!");

                        } else {
                            System.out.println("Invalid choice!");
                        }

                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 2:
                    if (myPlaylist.getPlaylist().isEmpty())
                        System.out.println("Playlist is empty!");

                    else {
                        System.out.println("Remove from the following:\n" +
                                           "Press");
                        for (int i = 0; i < myPlaylist.getPlaylist().size(); i++)
                            System.out.println(i + ". Title: " + myPlaylist.getPlaylist().get(i).getSongTitle()
                                    + "              Duration: " + myPlaylist.getPlaylist().get(i).getSongDuration());

                        System.out.print("Your choice: ");
                        choice = scanner.nextInt();

                        if (choice > -1 && choice < myPlaylist.getPlaylist().size()) {
                            Song dummy = myPlaylist.getPlaylist().get(choice);
                            myPlaylist.removeFromPlaylist(dummy);
                            System.out.println("Song removed!");
                        }

                        else {
                            System.out.println("Invalid choice!");
                        }
                    }
                    break;
                case 3:
                    myPlaylist.traversePlaylist();
                    break;
                case 4:
                    if (myPlaylist.getPlaylist().isEmpty()) {
                        System.out.println("Playlist is empty!");
                    } else {
                        System.out.print("Search for a song:-\n" +
                                "Song title: ");
                        String searchTitle = scanner.nextLine();
                        System.out.print("Song duration: ");
                        String searchDuration = scanner.nextLine();
                        Song dummy = new Song(searchTitle, searchDuration);
                        myPlaylist.findSong(dummy);
                    }
                    break;
                case 5:
                    printMenu();
                    break;
                case 0:
                    quit = true;
                    System.out.println("Application closed!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Press\n" +
                           "1. Add a song to playlist.\n" +
                           "2. Remove a song from your playlist.\n" +
                           "3. View playlist\n" +
                           "4. Find a song in the playlist.\n" +
                           "5. Reprint menu\n" +
                           "0. Quit.");

    }

    private static void database() {
        nightCall.addSong(new Song("Inferno", "4:12"));
        nightCall.addSong(new Song("Lusive", "3:25"));
        nightCall.addSong(new Song("Sleepwalking", "5:06"));
        answerLove.addSong(new Song("Hatsukoi", "2:26"));
        answerLove.addSong(new Song("Anata", "2:19"));
        answerLove.addSong(new Song("Dakishimetai", "2:49"));
        answerLove.addSong(new Song("Futari de Ikou", "2:10"));
        answerLove.addSong(new Song("Answer Love", "3:05"));
        answerLove.addSong(new Song("Aishiteru", "2:12"));
    }

    private static class SongList {
        private final List<Song> playlist;

        public SongList() {
            this.playlist = new ArrayList<>();
        }

        public List<Song> getPlaylist() {
            return playlist;
        }

        public void addToPlaylist(Song song) {
            playlist.add(song);
        }

        public void removeFromPlaylist(Song song) {
            playlist.remove(song);
        }

        public void findSong(Song song) {
            for (int i = 0; i < playlist.size(); i++)
                if (playlist.get(i).getSongTitle().equals(song.getSongTitle()) && playlist.get(i).getSongDuration().equals(song.getSongDuration())) {

                    System.out.println("Found match at index number: " + i);
                    return;

                }

            if (!isExists(song))
                System.out.println("Song doesn't exist in playlist!");
        }

        private boolean isExists(Song song) {
            return playlist.contains(song);
        }

        public void traversePlaylist() {
            if (playlist.isEmpty()) {
                System.out.println("Playlist is empty!");
                return;
            }

            for (int i = 0; i < playlist.size(); i++)
                System.out.println(i + ". Title: " + playlist.get(i).getSongTitle()
                        + "              Duration: " + playlist.get(i).getSongDuration());
        }
    }
}
