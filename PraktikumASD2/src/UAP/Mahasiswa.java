package UAP;

class Mahasiswa {

    private String Nama;
    private String Nim;
    private String programStudi;

    public Mahasiswa() {

    }

    public Mahasiswa(String Nama, String Nim, String programStudi) {
        this.Nama = Nama;
        this.Nim = Nim;
        this.programStudi = programStudi;
    }

    public String getNama() {
        return Nama;
    }

    public String getNim() {
        return Nim;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public String toString() {
        return String.format("%s\n%-15s: %s\n%-15s: %s\n%-15s: %s\n", "------------------------------------------", "Nama ", this.Nama, "NIM ", this.Nim, "Program Studi ", this.programStudi);
    }

}