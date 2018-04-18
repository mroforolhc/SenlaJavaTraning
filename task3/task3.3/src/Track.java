public class Track {
    private String title;
    private int time;
    private String genre;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    Track(String title, int time, String genre) {
        setTitle(title);
        setTime(time);
        setGenre(genre);
    }
}
