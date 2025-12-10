import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        boolean doesLoopContinue = true;
        int menuInput;

        while (doesLoopContinue) {
            System.out.println("""
                    === Playlist Manager ===
                    
                    1.  Add Song
                    2.  Add Song at certain position
                    3.  Delete a song (title)
                    4.  Delete a song (index)
                    5.  Delete the first song
                    6.  Delete the last song
                    7.  List playlist
                    8.  Show size of playlist
                    9.  Go to the next song
                    10. Go to the previous song
                    11. Play the current song
                    12. Check, if song exists
                    13. Check, if playlist is empty
                    14. Exit
                    """);

            while (true) {
                try {
                    menuInput = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Enter a valid menu choice!");
                } finally {
                    scanner.nextLine();
                }
            }

            Song songToAdd;
            String songTitle;
            String songArtist;
            String yesNoChoice;
            int songDurationMinutes;

            switch (menuInput) {
                case 1:
                    System.out.println("=== Enter the title of the song ===");
                    songTitle = scanner.nextLine();

                    System.out.println("=== Enter the artist of this song ===");
                    songArtist = scanner.nextLine();

                    System.out.println("=== Enter the duration in minutes of this song ===");
                    while (true) {
                        try {
                            songDurationMinutes = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Enter a valid duration in minutes!");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    songToAdd = new Song(songTitle, songArtist, songDurationMinutes);
                    myPlaylist.addSong(songToAdd);
                    break;
                case 2:
                    int positionForSong;

                    System.out.println("=== Enter the title of the song ===");
                    songTitle = scanner.nextLine();

                    System.out.println("=== Enter the artist of this song ===");
                    songArtist = scanner.nextLine();

                    System.out.println("=== Enter the duration in minutes for this song ===");
                    while (true) {
                        try {
                            songDurationMinutes = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Enter a valid duration in minutes!");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    System.out.println("=== At what position would you like to add the song? ===");
                    while (true) {
                        try {
                            positionForSong = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Enter a valid position!");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    songToAdd = new Song(songTitle, songArtist, songDurationMinutes);

                    myPlaylist.addSongAtPosition(positionForSong, songToAdd);
                    break;
                case 3:
                    String titleOfSongToDelete;

                    System.out.println("=== What song would you like to delete? ===");
                    titleOfSongToDelete = scanner.nextLine();

                    System.out.println("--- Do you really want to delete this song? (Y/N) ---");
                    yesNoChoice = scanner.next().toUpperCase();

                    if (yesNoChoice.equals("Y")) {
                        myPlaylist.deleteSong(titleOfSongToDelete);
                    }
                    break;
                case 4:
                    int indexOfSongToDelete;

                    System.out.println("=== What song would you like to delete? ===");
                    while (true) {
                        try {
                            indexOfSongToDelete = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Enter a valid index!");
                        } finally {
                            scanner.nextLine();
                        }
                    }
                    System.out.println("--- Do you really want to delete this song? (Y/N) ---");

                    yesNoChoice = scanner.next().toUpperCase();

                    if (yesNoChoice.equals("Y")) {
                        myPlaylist.deleteSong(indexOfSongToDelete);
                    }
                    break;
                case 5:
                    System.out.println("--- Do you really want to delete the first song? (Y/N) ---");
                    yesNoChoice = scanner.next().toUpperCase();

                    if (yesNoChoice.equals("Y")) {
                        myPlaylist.deleteFirstSong();
                    }
                    break;
                case 6:
                    System.out.println("--- Do you really want to delete the last song? (Y/N) ---");
                    yesNoChoice = scanner.next().toUpperCase();

                    if (yesNoChoice.equals("Y")) {
                        myPlaylist.deleteLastSong();
                    }
                    break;
                case 7:
                    myPlaylist.listPlaylist();
                    break;
                case 8:
                    myPlaylist.showSizeOfPlaylist();
                    break;
                case 9:
                    myPlaylist.goToNextSong();
                    break;
                case 10:
                    myPlaylist.goToPreviousSong();
                    break;
                case 11:
                    myPlaylist.playCurrentSong();
                    break;
                case 12:
                    String songToCheckFor;

                    System.out.println("=== What song would you like to check? ===");
                    songToCheckFor = scanner.nextLine();

                    if (myPlaylist.doesSongExist(songToCheckFor)) {
                        System.out.println("=== Song does exist! ===");
                    } else {
                        System.out.println("=== Song does NOT exist! ===");
                    }
                    break;
                case 13:
                    if (myPlaylist.isPlaylistEmpty()) {
                        System.out.println("=== Playlist is empty! ===");
                    } else {
                        System.out.println("=== Playlist is NOT empty! ===");
                    }
                    break;
                case 14:
                    doesLoopContinue = false;
                    break;
                default:
                    System.err.println("Enter a number from 1 - 14!");
            }
        }
    }
}
