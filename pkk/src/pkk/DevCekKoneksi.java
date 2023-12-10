/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkk;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author dzikr
 */
public class DevCekKoneksi {
    public static void main(String[] args) {
        try {
            // Panggil metode konek dari kelas Koneksi untuk mendapatkan Koneksi
            Connection connection = Koneksi.konek();

            // Lakukan operasi database atau tindakan lainnya menggunakan Koneksi

            // Jangan lupa untuk menutup Koneksi setelah selesai menggunakan
            if (connection != null) {
                connection.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
