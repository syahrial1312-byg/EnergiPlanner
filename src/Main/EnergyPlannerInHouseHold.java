package Main;

import Model.BarangElektronik;
import Model.User;

public class EnergyPlannerInHouseHold {
    public static void main(String[] args) {
        User u1 = new User("anita", "01", "1234", 450,36f);
        BarangElektronik b1 = new BarangElektronik("Lampu depan", 10, 12);
        BarangElektronik b2 = new BarangElektronik("Kulkas", 130, 24);
        BarangElektronik b3 = new BarangElektronik("Mejikon", 150, 4);
        BarangElektronik b4 = new BarangElektronik("TV", 85, 3);
        BarangElektronik b5 = new BarangElektronik("Kipas Angin", 55, 24);
        BarangElektronik b6 = new BarangElektronik("Lampu kamar", 10, 6);
        BarangElektronik b7 = new BarangElektronik("Setrika", 210, 3);
        BarangElektronik b8 = new BarangElektronik("Lampu tengah", 10, 6);
        BarangElektronik b9 = new BarangElektronik("Lampu kamar mandi", 10, 4);
        BarangElektronik b10 = new BarangElektronik("Kipas angiin ", 55, 3);

        u1.tambahBarang(b1);
        u1.tambahBarang(b2);
        u1.tambahBarang(b3);
        u1.tambahBarang(b4);
        u1.tambahBarang(b5);
        u1.tambahBarang(b6);
        u1.tambahBarang(b7);
        u1.tambahBarang(b8);
        u1.tambahBarang(b9);
        u1.tambahBarang(b10);
        u1.updateBarang(3,"Lampu",10,6);
        u1.deleteBarang(2);
        u1.setTotalBiaya();
        u1.setTotalKwh();

        u1.tampilanDataUser();
        u1.tampilkanBarang();

    }
}