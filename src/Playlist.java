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
}