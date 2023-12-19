/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler_class;

/**
 *
 * @author dzikr
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Peminjaman {

    public void loadTable(DefaultTableModel tableModel) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "select * from peminjaman ";
            ResultSet cari = state.executeQuery(sql);

            while (cari.next()) {
                String a = cari.getString(1);
                String b = cari.getString(2);
                String c = cari.getString(3);
                String d = cari.getString(4);
                String e = cari.getString(5);
                String f = cari.getString(6);
                String g = cari.getString(7);
                String h = cari.getString(8);
                String i = cari.getString(9);
                Object[] data = {a, b, c, d, e, f, g, h, i};
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Data Gak ada!");
        }
    }

    public void cariData(DefaultTableModel tableModel, String cariText) {
        tableModel.setRowCount(0); // Menghapus semua baris pada tabel

        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "select * from peminjaman WHERE kode_peminjaman LIKE '%" + cariText + "%' OR judul_buku LIKE '" + cariText + "'";
            ResultSet cari = state.executeQuery(sql);

            while (cari.next()) {
                String a = cari.getString(1);
                String b = cari.getString(2);
                String c = cari.getString(3);
                String d = cari.getString(4);
                String e = cari.getString(5);
                String f = cari.getString(6);
                String g = cari.getString(7);
                String h = cari.getString(8);
                String i = cari.getString(9);
                Object[] data = {a, b, c, d, e, f, g, h, i};
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Data Gak ada!");
        }
    }

    public void tambahData(String kodePeminjaman, String tanggalPinjam, String nis, String nama, String kelas,
                           String kodeBuku, String judulBuku, String jumlahBuku, String idPetugas) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "INSERT INTO peminjaman VALUES ('" + kodePeminjaman + "','" + tanggalPinjam + "','" + nis + "','" +
                    nama + "','" + kelas + "','" + kodeBuku + "','" + judulBuku + "','" + jumlahBuku + "','" + idPetugas + "')";
            state.executeUpdate(sql);

            String pilihan[] = {
                    "Print aja", "Nanti aja"
            };
            int tny = JOptionPane.showOptionDialog(null,
                    "Struk mau langsung di print?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
            if (tny == 0) {
                try {
                    struk();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
        }
    }

    public void hapusData(String kodePeminjaman) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "delete from peminjaman where kode_peminjaman= '" + kodePeminjaman + "'";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Dihapus");
        }
    }

    public void editData(String kodePeminjaman, String tanggalPinjam, String nis, String nama, String kelas,
                         String kodeBuku, String judulBuku, String jumlahBuku, String idPetugas) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "update peminjaman set tanggal_pinjam='" + tanggalPinjam + "',nis='" + nis + "',nama='" +
                    nama + "',kelas='" + kelas + "',kode_buku='" + kodeBuku + "',judul_buku='" + judulBuku + "',jumlah_buku='" +
                    jumlahBuku + "',id_petugas='" + idPetugas + "' where kode_peminjaman='" + kodePeminjaman + "'";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Di Edit");
        }
    }

    private void struk() {
        // Implementasi cetak struk
    }
}

