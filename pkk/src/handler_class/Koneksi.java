package handler_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection konek;

    public static Connection konek() throws SQLException, ClassNotFoundException {
        try {
            if (konek == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/pkk", "root", "");
                System.out.println("Koneksi berhasil!");
            }
            return konek;
        } catch (SQLException e) {
            System.err.println("Error: Koneksi tidak berhasil! " + e.getMessage());
            throw e; // lempar kembali eksepsi untuk penanganan lebih lanjut
        }
    }
}
