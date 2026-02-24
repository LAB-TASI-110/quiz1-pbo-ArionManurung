import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String kode;
        int porsiButet;
        int porsiUcok;
        int totalPorsi;
        int harga = 0;
        int subtotal;
        int totalBelanja = 0;

        System.out.printf("%-20s %-10s %-10s %-10s\n", 
                "Menu", "Porsi", "Harga", "Total");
        System.out.println("======================================================");

        while (true) {

            kode = input.nextLine();

            if (kode.equals("END")) {
                break;
            }

            porsiButet = Integer.parseInt(input.nextLine());

            // Perbandingan berat 100kg : 50kg = 2 : 1
            porsiUcok = 2 * porsiButet;
            totalPorsi = porsiButet + porsiUcok;

            String namaMenu = "";

            switch (kode) {
                case "NGS":
                    namaMenu = "Nasi Goreng Spesial";
                    harga = 15000;
                    break;
                case "AP":
                    namaMenu = "Ayam Penyet";
                    harga = 20000;
                    break;
                case "SA":
                    namaMenu = "Sate Ayam";
                    harga = 25000;
                    break;
                case "BU":
                    namaMenu = "Bakso Urat";
                    harga = 18000;
                    break;
                case "MAP":
                    namaMenu = "Mie Ayam Pangsit";
                    harga = 15000;
                    break;
                case "GG":
                    namaMenu = "Gado-Gado";
                    harga = 15000;
                    break;
                case "SAM":
                    namaMenu = "Soto Ayam";
                    harga = 17000;
                    break;
                case "RD":
                    namaMenu = "Rendang Daging";
                    harga = 25000;
                    break;
                case "IB":
                    namaMenu = "Ikan Bakar";
                    harga = 35000;
                    break;
                case "NUK":
                    namaMenu = "Nasi Uduk Komplit";
                    harga = 20000;
                    break;
                default:
                    continue;
            }

            subtotal = totalPorsi * harga;
            totalBelanja += subtotal;

            System.out.printf("%-20s %-10d %-10d %-10d\n",
                    namaMenu, totalPorsi, harga, subtotal);
        }

        System.out.println("======================================================");

        // HITUNG KUPON
        double diskon = 0;
        String kupon = "Tidak Ada";

        int level = totalBelanja / 100000;

        if (level >= 5) {
            diskon = 0.25;
            kupon = "Kupon Hitam";
        } else if (level == 4) {
            diskon = 0.20;
            kupon = "Kupon Hijau";
        } else if (level == 3) {
            diskon = 0.15;
            kupon = "Kupon Merah";
        } else if (level == 2) {
            diskon = 0.10;
            kupon = "Kupon Kuning";
        } else if (level == 1) {
            diskon = 0.05;
            kupon = "Kupon Biru";
        }

        double potongan = totalBelanja * diskon;
        double totalBayar = totalBelanja - potongan;

        System.out.println("Total Belanja      : " + totalBelanja);
        System.out.println("Kupon              : " + kupon);
        System.out.println("Diskon             : " + (int) potongan);
        System.out.println("Total Pembayaran   : " + (int) totalBayar);

        input.close();
    }
}