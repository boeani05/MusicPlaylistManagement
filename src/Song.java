public class Song {
    private final String title;
    private final String artist;
    private final int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("""
                        
                        === %s (%s) ===
                        \t %d seconds
                        """,
                title,
                artist,
                duration
        );
    }
}
