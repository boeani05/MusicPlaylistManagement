public class Playlist {
    private static class Node {
        Song song;
        Node next;
        Node previous;

        public Node(Song song) {
            this.song = song;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentSongNode;

    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentSongNode = null;
        this.size = 0;
    }

    public void addSong(Song newSong) {
        Node newNode = new Node(newSong);

        if (head == null) {
            head = newNode;
            tail = newNode;
            currentSongNode = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;

        System.out.println("Song '" + newSong.getTitle() + "' added!");
    }

    public void addSongAtPosition(int position, Song newSong) {
        Node newNode = new Node(newSong);

        if (position < 0 || position > size) {
            System.out.println("Position input not valid");
        } else if (position == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
                currentSongNode = newNode;
            } else {
                head.previous = newNode;
                newNode.next = head;
                head = newNode;
                currentSongNode = head;
            }

            size++;

            System.out.println("Song '" + newSong.getTitle() + "' added at Pos. " + position + ".");
        } else if (position == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;

            size++;

            System.out.println("Song '" + newSong.getTitle() + "' added at Pos. " + position + ".");
        } else {
            int counter = 0;
            Node currentNode = head;

            for (int i = 0; i < position - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next.previous = newNode;

            newNode.previous = currentNode;
            newNode.next = currentNode.next;

            currentNode.next = newNode;

            size++;

            System.out.println("Song '" + newSong.getTitle() + "' added at Pos. " + position + ".");
        }
    }

    public void deleteSong(String title) {
        if (head == null) {
            System.err.println("There are no songs in this playlist yet!");
            return;
        }

        Node nodeToDelete = null;
        Node searchNode = head;

        while (searchNode != null) {
            if (searchNode.song.getTitle().equals(title)) {
                nodeToDelete = searchNode;
                break;
            }
            searchNode = searchNode.next;
        }

        if (nodeToDelete == null) {
            System.err.println("Song '" + title + "' not found in this playlist!");
            return;
        }

        if (currentSongNode == nodeToDelete) {
            if (nodeToDelete.next != null) {
                currentSongNode = nodeToDelete.next;
            } else if (nodeToDelete.previous != null) {
                currentSongNode = nodeToDelete.previous;
            } else {
                currentSongNode = null;
            }
        }

        if (nodeToDelete.previous == null && nodeToDelete.next == null) {

            head = null;
            tail = null;
        } else if (nodeToDelete.previous == null) {
            head = nodeToDelete.next;
            head.previous = null;
        } else if (nodeToDelete.next == null) {
            tail = nodeToDelete.previous;
            tail.next = null;
        } else {
            nodeToDelete.previous.next = nodeToDelete.next;
            nodeToDelete.next.previous = nodeToDelete.previous;
        }

        size--;
        System.out.println("Song '" + title + "' deleted successfully!");
    }

    public void deleteSong(int index) {
        if (index < 0 || index >= size) {
            System.err.println("Invalid index!");
            return;
        }

        if (head == null) {
            System.err.println("Playlist is empty!");
            return;
        }
        int iterationCounter = 0;
        Node currentNode = head;

        while (currentNode != null) {
            if (iterationCounter == index) {
                if (currentNode == head && currentNode == tail) {
                    head = null;
                    tail = null;
                } else if (currentNode == head) {
                    head = currentNode.next;
                    head.previous = null;
                } else if (currentNode == tail) {
                    tail = currentNode.previous;
                    tail.next = null;
                } else {
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                }

                if (currentSongNode == currentNode) {
                    if (currentNode.next != null) {
                        currentSongNode = currentNode.next;
                    } else if (currentNode.previous != null) {
                        currentSongNode = currentNode.previous;
                    } else {
                        currentSongNode = null;
                    }
                }

                size--;
                System.out.println("Song deleted successfully!");
                break;
            } else {
                iterationCounter++;
                currentNode = currentNode.next;
            }
        }
    }

    public void deleteFirstSong() {
        if (head == null) {
            System.err.println("This playlist is empty!");
            return;
        }

        Node oldHead = head;

        if (head.equals(tail)) {
            head = null;
            tail = null;
            currentSongNode = null;
        } else {
            head = head.next;
            head.previous = null;

            if (currentSongNode == oldHead) {
                currentSongNode = head;
            }
        }
        size--;
        System.out.println("First song deleted successfully!");
    }

    public void deleteLastSong() {
        if (tail == null) {
            System.err.println("This playlist is empty!");
            return;
        }

        Node oldTail = tail;

        if (tail == head) {
            head = null;
            tail = null;
            currentSongNode = null;
        } else {
            tail = tail.previous;
            tail.next = null;

            if (currentSongNode == oldTail) {
                currentSongNode = tail;
            }
        }
        size--;
        System.out.println("Last song deleted successfully!");
    }

    public void listPlaylist() {
        if (head == null) {
            System.err.println("Nothing to show here!");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.song);
            currentNode = currentNode.next;
        }
    }

    public void showSizeOfPlaylist() {
        System.out.println(size);
    }

    public void goToNextSong() {
        if (head == null) {
            System.err.println("No songs in this playlist!");
            return;
        }

        if (currentSongNode == null) {
            currentSongNode = head;
            System.out.println("Moved to the first song!");
        } else if (head == tail) {
            System.err.println("No more songs in this playlist!");
        } else if (currentSongNode == tail) {
            currentSongNode = head;
            System.out.println("Reached the end of the playlist, moving to the first song.");
        } else {
            currentSongNode = currentSongNode.next;
            System.out.println("Successfully moved to the next song!");
        }
    }

    public void goToPreviousSong() {
        if (tail == null) {
            System.err.println("No songs in this playlist!");
            return;
        }

        if (currentSongNode == null) {
            currentSongNode = head;
            System.out.println("Moved to the first song!");
        } else if (tail == head) {
            System.err.println("No more songs in this playlist!");
        } else if (currentSongNode == head) {
            currentSongNode = tail;
            System.out.println("Reached the beginning of the playlist, moving to the last song.");
        } else {
            currentSongNode = currentSongNode.previous;
            System.out.println("Successfully moved to the previous song!");
        }
    }

    public void playCurrentSong() {
        if (head == null) {
            System.err.println("No songs to play in this playlist!");
            return;
        }

        if (currentSongNode == null) {
            currentSongNode = head;
        }
        System.out.println("Now playing: " + currentSongNode.song.getTitle());
    }

    public boolean doesSongExist(String title) {
        if (head == null) {
            System.err.println("There are no songs in this playlist!");
            return false;
        }

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.song.getTitle().equals(title)) {
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    public boolean isPlaylistEmpty() {
        return head == null;
    }
}