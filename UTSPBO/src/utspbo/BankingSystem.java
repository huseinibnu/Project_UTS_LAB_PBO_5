package utspbo;


import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class BankingSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    public Scanner scanner = new Scanner(System.in);

    public void registerAccount() {
        String nama, alamat, nomor_telepon;
        int saldo;
        System.out.print("Masukkan nama anda                        : ");
        nama = scanner.nextLine();
        System.out.print("Masukkan alamat anda                      : ");
        alamat = scanner.nextLine();
        System.out.print("Masukkan nomor telepon anda               : ");
        nomor_telepon = scanner.nextLine();
        System.out.print("Masukkan saldo awal anda                  : Rp. ");
        
        try {
            saldo = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            System.out.println("Akun bank anda berhasil dibuat. \nSilahkan menikmati layanan yang kami sediakan");
            BankAccount account = new BankAccount(nama, alamat, nomor_telepon, saldo);
            accounts.add(account); 
        } catch (Exception e) {
            System.out.println("Input tidak valid. Jumlah uang harus berupa angka.\n");
            showMenu();
        }     
        
    }

    public void sendMoney() {
        System.out.print("Masukkan nomor akun pengirim : ");
        String nomor_akun_pengirim = scanner.nextLine(); 
        System.out.print("Masukkan nomor akun penerima : ");
        String nomor_akun_penerima = scanner.nextLine();
        System.out.print("Masukkan jumlah uang yang akan ditransfer : ");

        try {
            int amount = scanner.nextInt();
            scanner.nextLine(); // consume the newline character 
            BankAccount akunPengirim = findAccount(nomor_akun_pengirim);
            BankAccount akunPenerima = findAccount(nomor_akun_penerima);

            if (akunPengirim == null) {
                System.out.println("Akun pengirim tidak ditemukan.");
            } else if (akunPenerima == null) {
                System.out.println("Akun penerima tidak ditemukan.");
            } else if (akunPengirim.getSaldo() < amount) {
                System.out.println("Saldo anda tidak cukup.");
            } else {
                akunPengirim.Transfer(amount);
                akunPenerima.topUp(amount);
                System.out.println("\nTransaksi berhasil.");
                System.out.println("=======================================================");
                System.out.println(" Nomor akun pengirim : " + akunPengirim.getNomorAkun());
                System.out.println(" Nama akun pengirim  : " + akunPengirim.getNama());
                System.out.println();
                System.out.println(" Nomor akun penerima : " + akunPenerima.getNomorAkun());
                System.out.println(" Nama akun penerima  : " + akunPenerima.getNama());
                System.out.println(" Jumlah transfer     : Rp. " + amount);
                System.out.println(" Waktu transaksi     : " + LocalDateTime.now());
                System.out.println("======================================================");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Jumlah uang harus berupa angka.\n");
            showMenu();
        }
  
    }

    public void depositMoney() {
        System.out.print("Masukkan nomor akun anda : ");
        String Nomor_Akun = scanner.nextLine();
        System.out.print("Masukkan jumlah uang yang akan disimpan : Rp. ");
        
        try {
            int amount = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            BankAccount account = findAccount(Nomor_Akun);

            if (account == null) {
                System.out.println("Account not found.");
            } else {
                account.topUp(amount);
                System.out.println("\nDeposit successful.");
                System.out.println("=======================================================");
                System.out.println("Nomor akun      : " + account.getNomorAkun());
                System.out.println("Saldo anda      : Rp. " + account.getSaldo());
                System.out.println("Waktu transaksi : " + LocalDateTime.now());
                System.out.println("=======================================================");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Jumlah uang harus berupa angka.\n");
            showMenu();
        }   
        
    }
    
    public void descriptMyAccount(){
        System.out.print("Masukkan nomor akun anda : ");
        String Nomor_Akun = scanner.nextLine();
        BankAccount account = findAccount(Nomor_Akun);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.showDescription();
        }
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getNomorAkun().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void showMenu() {
        System.out.println("+-----------------------------------------+");
        System.out.println("| Selamat datang di sistem bank terserah !|");
        while (true) {
            System.out.println("+-----------------------------------------+");
            System.out.println("| Silahkan pilih program yang anda mau    |");
            System.out.println("| 1. Registrasi Akun Baru                 |");
            System.out.println("| 2. Mengirim Uang                        |");
            System.out.println("| 3. Menyimpan Uang                       |");
            System.out.println("| 4. Mengecek informasi rekening pribadi  |");
            System.out.println("| 5. Keluar                               |");
            System.out.println("+-----------------------------------------+");
            
            System.out.print("Kode anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    registerAccount();
                    break;
                case 2:
                    sendMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    descriptMyAccount();
                    break;
                case 5:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Sintaks tidak valid.");
            }

            System.out.println();
        }
    }
}
