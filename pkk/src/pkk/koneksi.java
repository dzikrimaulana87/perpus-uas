
package pkk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static Connection konek;
    public static Connection konek()throws SQLException, ClassNotFoundException{
        if(konek==null){
            Class.forName("com.mysql.jdbc.Driver");
            konek = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pkk","root","");
        }
        return konek;
    }
}
