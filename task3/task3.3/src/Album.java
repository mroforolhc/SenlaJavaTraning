import java.util.*;

public class Album {
    private String artist;
    private String title;
    private int time = 0;
    private String genre;
    private ArrayList<String> listOfGenre = new ArrayList<>();
    private ArrayList<Track> listOfTracks = new ArrayList<>();

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Track> getListOfTracks() {
        return listOfTracks;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    Album(String artist, String title) {
        setArtist(artist);
        setTitle(title);
    }

    public void addTrack(Track track) {
        listOfTracks.add(track);
        setTime(this.getTime() + track.getTime());
        listOfGenre.add(track.getGenre());
    }

    // Search for the most frequent genre from the tracklist (not the best way)
    public void compileAlbum() {
        String prevGenre = listOfGenre.get(0);
        String topGenre = listOfGenre.get(0);
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < listOfGenre.size(); i++) {
            if (listOfGenre.get(i).equals(prevGenre)) count++;
            else {
                if (count > maxCount) {
                    topGenre = listOfGenre.get(i-1);
                    maxCount = count;
                }
                prevGenre = listOfGenre.get(i);
            }
        }
        setGenre(topGenre);
    }

    public void printFullInformation() {
        System.out.println("Album: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("Genre: " + getGenre());
        System.out.println("Time: " + getTime() / 60 + " min " + getTime() % 60 + " sec\n");

        System.out.println("Tracklist:");
        for (Track track : getListOfTracks()) {
            System.out.println(track.getTitle());
        }

    }
}
