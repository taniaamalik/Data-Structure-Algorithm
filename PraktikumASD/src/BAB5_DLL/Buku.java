package BAB5_DLL;

public class Buku {

    private String kategori;
    private String judul;
    private double hargaSewa;
    private double hargaDenda;
    public Buku(String ktgr, String jdl, double sewa, double denda) {
        this.kategori = ktgr;
        this.judul = jdl;
        this.hargaSewa = sewa;
        this.hargaDenda = denda;
    }
    Buku(String jdl) {
        this.judul = jdl;
    }
    public double getHargaSewa() {
        return hargaSewa;
    }
    public double getHargaDenda() {
        return hargaDenda;
    }
    public String getKategori() {
        return kategori;
    }
    public String getJudul() {
        return judul;
    }
    @Override
    public String toString() {
        return String.format("%-15s: %s\n%-15s: %s\n%-15s: %s\n%-15s: %s\n%s\n", "Kategori ", this.kategori, "Judul ", this.judul, "Harga Sewa ", this.hargaSewa, "Harga Denda ", this.hargaDenda, "-------------------------------------");
    }
}