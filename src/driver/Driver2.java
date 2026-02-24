import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 1. Input jumlah total data
        int N = input.nextInt();

        int[] nilai = new int[N];

        // 2. Input deret nilai
        for (int i = 0; i < N; i++) {
            nilai[i] = input.nextInt();
        }

        // 3. Input jumlah anggota per kelompok
        int anggotaPerKelompok = input.nextInt();

        // 4. Input kode kelompok
        int kodeKelompok = input.nextInt();

        // Hitung batas awal kelompok
        int start = (kodeKelompok - 1) * anggotaPerKelompok;
        int end = start + anggotaPerKelompok;

        int total = 0;

        // Jumlahkan nilai sesuai kelompok
        for (int i = start; i < end && i < N; i++) {
            total += nilai[i];
        }

        // Output hasil
        System.out.println(total);

        input.close();
    }
}
