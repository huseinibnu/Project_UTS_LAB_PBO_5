/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utspbo;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class BankAccount {
    private String nama, alamat, nomor_telepon, nomor_akun;
    private int saldo;
    private LocalDateTime tanggal_registrasi;

    public BankAccount(String nama, String alamat, String nomor_telepon, int saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomor_telepon = nomor_telepon;
        this.nomor_akun = generateNomorAkun();
        this.saldo = saldo;
        this.tanggal_registrasi = LocalDateTime.now();
        showDescription();
    }

    public String getNomorAkun() {
        return nomor_akun;
    }
    
    public String getNama() {
        return nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public void topUp(int jumlahTopUp) {
        saldo += jumlahTopUp;
    }

    public void Transfer(int jumlahTransfer) {
        saldo -= jumlahTransfer;
    }

    public String generateNomorAkun(){
        Random rand = new Random();
        String nomorAkunHasil = "";
        for (int i = 0; i < 6; i++) {
            nomorAkunHasil += rand.nextInt(10);
        }
        return nomorAkunHasil;
    }
    
    public void showDescription(){
        System.out.println("\nBerikut data registrasi anda \n");
        System.out.println("=======================================================");
        System.out.println("Nama \t\t\t: " + nama);
        System.out.println("Alamat \t\t\t: " + alamat);
        System.out.println("Nomor HP \t\t: " + nomor_telepon);
        System.out.println("Nomor akun \t\t: " + nomor_akun);
        System.out.println("Saldo \t\t\t: Rp. " + saldo);
        System.out.println("Tanggal registrasi \t: " + tanggal_registrasi);
        System.out.println("=======================================================");
        System.out.println();
    }
}
