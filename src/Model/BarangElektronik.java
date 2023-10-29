package Model;

public class BarangElektronik {
    private String namaBarang;
    private float kwhBarang;
    private float dayaBarang;
    private float lamaPemakaian;

    public BarangElektronik(String namaBarang, float dayaBarang, float lamaPemakaian) {
        this.namaBarang = namaBarang;
        this.dayaBarang = dayaBarang;
        this.lamaPemakaian = lamaPemakaian;
        this.kwhBarang = ((this.dayaBarang * this.lamaPemakaian) / 1000)*30;
    }

    public float getKwhBarang() {
        return kwhBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setKwhBarang(float kwhBarang) {
        this.kwhBarang = kwhBarang;
    }

    public void setDayaBarang(float dayaBarang) {
        this.dayaBarang = dayaBarang;
    }

    public void setLamaPemakaian(float lamaPemakaian) {
        this.lamaPemakaian = lamaPemakaian;
    }

    public String toString() {
        return "\nNama Barang\t: " + this.namaBarang + "\n" +
                "Daya Barang\t: " + this.dayaBarang + "\n" +
                "Lama Pemakaian\t: " + this.lamaPemakaian + "\n" +
                "kwhBarang\t: " + this.kwhBarang;
    }

}