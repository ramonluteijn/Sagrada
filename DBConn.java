import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConn {
    private Connection conn;

    public boolean loadDataBaseDriver(String driverName)
    {
        try
        {
            // Load the JDBC driver
            Class.forName(driverName);
        } catch (ClassNotFoundException e)
        {
            // Could not find the database driver
            System.out.println("ClassNotFoundException : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean makeConnection()
    {
        try
        {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/outerspace?user=root&password=");
            System.out.println("So far, so good...");
        } catch (SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
        return true;
    }

    public void query(String query)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                String name = rs.getString("objectnaam");
                String satOf = rs.getString(2);
                System.out.println(" - " + name + ", satellite of " + satOf
                        + ".");
            }
            stmt.close();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}


