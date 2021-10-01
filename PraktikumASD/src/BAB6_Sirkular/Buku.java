package BAB6_Sirkular;

public class Buku {

    private final String judul, kategori;
    private final int hargaSewa, hargaDenda;

    public Buku(String kategori, String judul, int hargaSewa, int hargaDenda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = hargaSewa;
        this.hargaDenda = hargaDenda;
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public int getHargaDenda() {
        return hargaDenda;
    }
}