import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class salsaMarket {

    // Method untuk mencetak tanggal dan waktu saat ini
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

    // Method untuk menghasilkan captcha sederhana
    public static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }

    // Method untuk login
    public static boolean login(String username, String password, String inputCaptcha, String generatedCaptcha) {
        return username.equals("salsayeyeye") && password.equals("salsaokeokeoke") && inputCaptcha.equals(generatedCaptcha);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        // Loop untuk login
        while (!isLoggedIn) {
            System.out.println("+-----------------------------------------------------+");
            System.out.println("LOG IN   ");
            System.out.print("Username          : ");
            String username = scanner.nextLine();
            System.out.print("Password          : ");
            String password = scanner.nextLine();

            String captcha = generateCaptcha();
            System.out.println("Captcha           : " + captcha);
            System.out.print("Masukkan Captcha  : "); 
            String inputCaptcha = scanner.nextLine();
            System.out.println();
            

            if (login(username, password, inputCaptcha, captcha)) {
                System.out.println("Selamat, kamu berhasil login");
                isLoggedIn = true; // Keluar dari loop jika login berhasil
                System.out.println();
            } else {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
            System.out.println("+-----------------------------------------------------+");
        }

        // Bagian Transaksi
        System.out.println("Selamat Datang di Salsa Market");
        System.out.println("Tanggal dan Waktu : " + getCurrentDateTime());
        System.out.println("+-----------------------------------------------------+");

        System.out.print("No. Faktur        : ");
        String noFaktur = scanner.nextLine();
        System.out.print("Kode Barang       : ");
        String kodeBarang = scanner.nextLine();
        System.out.print("Nama Barang       : ");
        String namaBarang = scanner.nextLine();
        System.out.print("Harga Barang      : ");
        double hargaBarang = scanner.nextDouble();
        System.out.print("Jumlah Beli       : ");
        int jumlahBeli = scanner.nextInt();

        double total = hargaBarang * jumlahBeli;

        System.out.println("+-----------------------------------------------------+");
        System.out.printf("TOTAL             : %.2f%n", total);
        System.out.println("+-----------------------------------------------------+");

        scanner.nextLine(); // Clear buffer
        System.out.print("Kasir : ");
        String namaKasir = scanner.nextLine();
        System.out.println("+-----------------------------------------------------+");

        // Tampilkan ringkasan transaksi
        System.out.println("Ringkasan Transaksi:");
        System.out.println("No. Faktur           : " + noFaktur);
        System.out.println("Kode Barang          : " + kodeBarang);
        System.out.println("Nama Barang          : " + namaBarang);
        System.out.printf("Harga Barang       : %.2f%n", hargaBarang);
        System.out.println("Jumlah Beli          : " + jumlahBeli);
        System.out.printf("TOTAL              : %.2f%n", total);
        System.out.println("Kasir                : " + namaKasir);
    }
}
