package OOP;

public class Buku {

    private String Judul;
    private String Jenis;
    private int Sewa;
    private int Denda;
    int Lama_Peminjaman, Telat_Pengembalian;

    public Buku(String jdl, String jns, int sewa, int denda) {
        this.Judul = jdl;
        this.Jenis = jns;
        this.Sewa = sewa;
        this.Denda = denda;
    }

    public void setLamaPeminjaman(int hari) {
        this.Lama_Peminjaman = hari;
    }

    public void setTelatPengembalian(int telat) {
        this.Telat_Pengembalian = telat;
    }

    public int getSewa() {
        return Sewa * Lama_Peminjaman;
    }

    public int getDenda() {
        return Denda * Telat_Pengembalian;
    }

    public void getBuku() {
        System.out.println("Judul Buku  : " + this.Judul);
        System.out.println("Jenis Buku  : " + this.Jenis);
        System.out.println("Biaya Sewa  : Rp " + this.Sewa);
        System.out.println("Biaya Denda : Rp  " + this.Denda);
    }

    public void DisplayMessage() {
        System.out.println("Judul Buku         : " + this.Judul);
        System.out.println("Jenis Buku         : " + this.Jenis);
        System.out.println("Lama Peminjaman    : " + Lama_Peminjaman + " hari");
        System.out.println("Biaya Sewa         : Rp " + getSewa());
        System.out.println("Telat Pengembalian : " + Telat_Pengembalian + " hari");
        System.out.println("Biaya Denda        : Rp " + getDenda());
        System.out.println("Total Pembayaran buku " + this.Judul + " : Rp " + (getSewa() + getDenda()));
    }
}