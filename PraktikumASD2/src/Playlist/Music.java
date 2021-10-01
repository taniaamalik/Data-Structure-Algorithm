package Playlist;

public class Music {

    private String Judul;
    private String Penyanyi;

    public Music() {

    }

    public Music(String Judul, String Penyanyi) {
        this.Judul = Judul;
        this.Penyanyi = Penyanyi;
    }

    public String getJudul() {
        return Judul;
    }

    public String getPenyanyi() {
        return Penyanyi;
    }

}