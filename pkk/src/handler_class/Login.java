package handler_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login {

    public static boolean performLogin(String username, String password) {
        if (!isValidInput(username) || !isValidInput(password)) {
            JOptionPane.showMessageDialog(null, "Input contains invalid characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.equals("") || username.equals("")) {
            JOptionPane.showMessageDialog(null, "Username or Password not filled");
            return false;
        }

        try {
            Connection connection = Koneksi.konek();

            String sql = "SELECT * FROM petugas WHERE username = ? AND password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String userLevel = resultSet.getString("level");
                        JOptionPane.showMessageDialog(null, "Login Berhasil");

                        if ("superadmin".equals(userLevel)) {
                            new menu_superadmin.menu_utama_superadmin().setVisible(true);
                        } else if ("admin".equals(userLevel)) {
                            new menu_main.Menu_utama().setVisible(true);
                        }

                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        return false;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Validation method
    private static boolean isValidInput(String input) {
        String regex = "^[a-zA-Z0-9]+$";
        return input.matches(regex);
    }
}
