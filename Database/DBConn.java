package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConn {
    private Connection conn;

    public DBConn(String conn) {
        loadDataBaseDriver(conn);
        makeConnection();
    }

    public boolean loadDataBaseDriver(String driverName)
    {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean makeConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/2023_sagrada?user=root&password=");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
        return true;
    }

    public Connection getConn() {
        return conn;
    }
}


