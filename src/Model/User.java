package Model;

public class User {
    private String namaUser;
    private String idUser;
    private String passwordUser;

    private float luasTanahBangunan;

    private int dayaMeteran;
    private float tarifPerKwh;

    private BarangElektronik[] barang = new BarangElektronik[10];
    private int jumlahBarang;
    private float[] tarifBarang = new float[10];

    private float totalKwh;
    private float totalBiaya;

    public User(String namaUser, String idUser, String passwordUser, int dayaMeteran,float luasTanahBangunan) {
        this.namaUser = namaUser;
        this.idUser = idUser;
        this.passwordUser = passwordUser;
        this.dayaMeteran = dayaMeteran;
        this.luasTanahBangunan = luasTanahBangunan;

        if (this.dayaMeteran == 450) {
            this.tarifPerKwh = (float) 1352.00;
        } else if (this.dayaMeteran == 900) {
            this.tarifPerKwh = (float) 1352.00;
        } else if (this.dayaMeteran == 1300) {
            this.tarifPerKwh =  (float) 1444.70;
        } else if (this.dayaMeteran == 2200) {
            this.tarifPerKwh = (float) 1444.70;
        } else if (this.dayaMeteran == 3500) {
            this.tarifPerKwh = (float) 1699.53;
        } else if (this.dayaMeteran == 6600) {
            this.tarifPerKwh = (float) 1699.53;
        }
    }

    public void tambahBarang(BarangElektronik barang){
        this.barang[jumlahBarang] = barang;
        this.tarifBarang[jumlahBarang] = this.barang[jumlahBarang].getKwhBarang() * this.tarifPerKwh;
        jumlahBarang++;
    }

    //setter
    public void setTotalBiaya(){
        for (int i = 0; i < jumlahBarang; i++) {
            this.totalBiaya = this.totalBiaya + this.tarifBarang[i];
        }
    }

    public void setTotalKwh(){
        for (int i = 0; i < jumlahBarang; i++) {
            this.totalKwh = this.totalKwh + this.barang[i].getKwhBarang();
        }
    }
    //getter
    public float getTotalBiaya() {
        return totalBiaya;
    }
    public int getDayaMeteran() {
        return dayaMeteran;
    }
    public int getJumlahBarang() {
        return jumlahBarang;
    }
    public float getTotalKwh() {
        return totalKwh;
    }
    public float getTarifPerKwh() {
        return tarifPerKwh;
    }

    public float getLuasTanahBangunan(){
        return luasTanahBangunan;
    }

    public void updateBarang(int idBarang,String name,float dayaBarang,float lamaPemakaian){
        if (idBarang>=0 && idBarang <=jumlahBarang){
            this.barang[idBarang].setNamaBarang(name);
            this.barang[idBarang].setDayaBarang(dayaBarang);
            this.barang[idBarang].setLamaPemakaian(lamaPemakaian);
            this.barang[idBarang].setKwhBarang((dayaBarang*lamaPemakaian/1000)*30);
            this.tarifBarang[idBarang]=this.barang[idBarang].getKwhBarang()*this.tarifPerKwh;
            setTotalBiaya();
            setTotalKwh();
        }else {
            System.out.println("Barang Tidak Ada");
        }
    }

    public void deleteBarang(int idBarang){
        if (idBarang>=0&&idBarang<=jumlahBarang){
            for (int index=idBarang;index<jumlahBarang;index++){
                barang[index]=barang[index+1];
                tarifBarang[index]=tarifBarang[index+1];
            }
            jumlahBarang--;
            setTotalBiaya();
            setTotalKwh();
        }else {
            System.out.println("Id Barang tidak ada");
        }
    }
    public void tampilanDataUser(){
        System.out.println("=========== Informasi User ============");
        System.out.println("ID\t\t\t: " + idUser);
        System.out.println("Nama\t\t\t: " + namaUser);
        System.out.println("Password\t\t: " + passwordUser);
        System.out.println("Daya dalam KiloWatt\t: " + getDayaMeteran());
        System.out.println("Tarif per KwH\t\t: " + getTarifPerKwh());
        System.out.println("Luas Bangunan Tanah:"+ getLuasTanahBangunan());
        System.out.println("\n");
    }

    public void tampilkanBarang() {
        System.out.println("====== Tampilan Barang Elektronik ======");
        System.out.println("Jumlah Barang\t: " + getJumlahBarang());
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println(barang[i]);
            System.out.println(this.barang[i].getNamaBarang() + "\t\t: " + this.tarifBarang[i]);
        }
        System.out.println("\nTotal KwH keseluruhan\t\t: " + getTotalKwh());
        System.out.println("Total Biaya keseluruhan\t: " + getTotalBiaya());
        validationEficiencyEnergy();
    }

    public void validationEficiencyEnergy(){
        float energyPerMeter = this.getTotalKwh()/getLuasTanahBangunan();
        if (energyPerMeter<=7.92&& energyPerMeter<=12.08){
            System.out.println("Intensity Consumings Energy(IKE):"+energyPerMeter+" kWh/m^2/month");
            System.out.println("Efficiency Valid");
        }
        else {
            System.out.println("Intensity Consumings Energy(IKE):"+energyPerMeter+" kWh/m^2/month");
            System.out.println("Efficiency not Valid");
        }
    }
}
