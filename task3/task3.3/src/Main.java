public class Main {
    public static void main(String[] args) {
        Track track1 = new Track("BLOOD.", 118, "Rap");
        Track track2 = new Track("DNA.", 186, "Rap");
        Track track3 = new Track("ELEMENT.", 209, "Rap");
        Track track4 = new Track("HUMBLE.", 177, "Rap");
        Track track5 = new Track("GOD.", 249, "Rap");

        Album alb = new Album("Kendrick Lamar", "DAMN.");
        alb.addTrack(track1);
        alb.addTrack(track2);
        alb.addTrack(track3);
        alb.addTrack(track4);
        alb.addTrack(track5);

        alb.compileAlbum();
        alb.printFullInformation();
    }

}
