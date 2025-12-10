# Simple Music Playlist Manager (Java - Doubly Linked List)

## Project Overview

This project is a command-line interface (CLI) application developed in Java that simulates a music playlist manager. It is built from scratch using a custom-implemented **Doubly Linked List (DLL)** as its core data structure to store and manage `Song` objects. The goal of this project was to deeply understand and master the concepts of Linked Lists by implementing all common operations without relying on Java's built-in `LinkedList` class.

## Features

The `Playlist` class, powered by its custom Doubly Linked List, supports the following operations:

### Song Management:
*   **Add Song:**
    *   `addSong(Song newSong)`: Adds a song to the end of the playlist.
    *   `addSongAtPosition(int position, Song newSong)`: Inserts a song at a specified 0-based index. Handles insertion at the beginning, end, and in the middle of the list.
*   **Delete Song:**
    *   `deleteSong(String title)`: Removes the first occurrence of a song by its title.
    *   `deleteSong(int index)`: Removes a song at a specified 0-based index.
    *   `deleteFirstSong()`: Removes the song at the beginning of the playlist.
    *   `deleteLastSong()`: Removes the song at the end of the playlist.
    *   All delete operations correctly handle edge cases (empty list, single song, deleting head/tail, deleting from middle) and ensure proper updating of `head`, `tail`, `currentSongNode`, and `size`.

### Playback & Navigation:
*   `playCurrentSong()`: Plays the currently selected song. If no song is selected, it defaults to playing the first song in the playlist.
*   `goToNextSong()`: Moves the `currentSongNode` to the next song in the playlist. Loops back to the beginning if at the end.
*   `goToPreviousSong()`: Moves the `currentSongNode` to the previous song in the playlist. Loops back to the end if at the beginning.

### Information & Status:
*   `listPlaylist()`: Displays all songs in the playlist in their current order.
*   `showSizeOfPlaylist()`: Prints the current number of songs in the playlist.
*   `doesSongExist(String title)`: Checks if a song with a given title is present in the playlist.
*   `isPlaylistEmpty()`: Returns `true` if the playlist contains no songs, `false` otherwise.

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/boeani05/MusicPlaylistManagement.git
    cd MusicPlaylistManagement/src
    ```
2.  **Compile the Java code:**
    Navigate to the directory containing your `.java` files (e.g., `src` if you have one) and compile them:
    ```bash
    javac *.java
    ```
3.  **Run the application:**
    ```bash
    java PlaylistApp
    ```

## How to Use

Once the `PlaylistApp` is running, you will be presented with an interactive menu:
* === Playlist Manager ===
* Add Song
* Add Song at certain position
* Delete a song (title)
* Delete a song (index)
* Delete the first song
* Delete the last song
* List playlist
* Show size of playlist
* Go to the next song
* Go to the previous song
* Play the current song
* Check, if song exists
* Check, if playlist is empty
* Exit

Enter the number corresponding to your desired action and follow the prompts. The application provides feedback for each operation and handles invalid inputs gracefully.

## Project Structure

*   `Song.java`: Defines the `Song` object with properties like `title`, `artist`, and `duration`.
*   `Playlist.java`: Contains the core `Doubly Linked List` implementation, including the `Node` inner class and all playlist management methods.
*   `PlaylistApp.java`: The main application class that provides the interactive command-line interface for the user to interact with the `Playlist`.

## Learning Outcomes

This project was a deep dive into:
*   **Data Structures:** A hands-on implementation of a Doubly Linked List from first principles.
*   **Java Fundamentals:** Mastering object-oriented programming, class design, and reference manipulation.
*   **Algorithm Design:** Developing robust logic for insertion, deletion, and traversal operations, carefully handling numerous edge cases.
*   **Console I/O:** Implementing user interaction through `Scanner` and handling input errors.
*   **Problem-Solving:** Breaking down a complex problem into manageable functions and systematically addressing each challenge.

## Future Enhancements (Stretch Goals)

*   **Sorting:** Implement sorting functionality (e.g., by title or artist) using an appropriate algorithm (e.g., Bubble Sort, Merge Sort for Linked Lists). This would be explored after covering common sorting algorithms in the Computer Science roadmap.
*   **Persistence:** Save and load the playlist to/from a file (e.g., CSV, JSON) so that it persists between application runs.
*   **Error Handling Refinements:** Implement custom exceptions for specific error conditions.
*   **More Advanced Features:** Implement shuffle, repeat, or specific song selection.