import java.util.ArrayList;
import java.util.Scanner;

class Transaksi {
    String nama;
    String noHp;
    String layanan;
    double berat;
    double total;

    public Transaksi(String nama, String noHp, String layanan, double berat, double total) {
        this.nama = nama;
        this.noHp = noHp;
        this.layanan = layanan;
        this.berat = berat;
        this.total = total;
    }

    public void tampilkan() {
        System.out.println("===== STRUK LAUNDRY DEL =====");
        System.out.println("Nama     : " + nama);
        System.out.println("No HP    : " + noHp);
        System.out.println("Layanan  : " + layanan);
        System.out.println("Berat    : " + berat + " kg");
        System.out.println("Total    : Rp " + total);
        System.out.println("=============================");
    }
}

public class Driver3 {

    static final double REGULER = 7000;
    static final double EXPRESS = 10000;
    static final double DRYCLEAN = 15000;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Transaksi> daftar = new ArrayList<>();
        int menu;

        do {
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Transaksi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {
                System.out.print("Nama Pelanggan: ");
                String nama = input.nextLine();

                System.out.print("No HP: ");
                String noHp = input.nextLine();

                System.out.println("Pilih Layanan:");
                System.out.println("1. Reguler (7000/kg)");
                System.out.println("2. Express (10000/kg)");
                System.out.println("3. Dry Clean (15000/kg)");
                System.out.print("Pilihan: ");
                int pilih = input.nextInt();

                System.out.print("Berat (kg): ");
                double berat = input.nextDouble();

                String layanan = "";
                double harga = 0;

                switch (pilih) {
                    case 1:
                        layanan = "Reguler";
                        harga = REGULER;
                        break;
                    case 2:
                        layanan = "Express";
                        harga = EXPRESS;
                        break;
                    case 3:
                        layanan = "Dry Clean";
                        harga = DRYCLEAN;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        continue;
                }

                double total = berat * harga;

                Transaksi t = new Transaksi(nama, noHp, layanan, berat, total);
                daftar.add(t);

                t.tampilkan();

            } else if (menu == 2) {
                if (daftar.isEmpty()) {
                    System.out.println("Belum ada transaksi.");
                } else {
                    for (Transaksi t : daftar) {
                        t.tampilkan();
                    }
                }

            } else if (menu == 3) {
                System.out.println("Program selesai.");
            } else {
                System.out.println("Menu tidak tersedia.");
            }

        } while (menu != 3);

        input.close();
    }
}