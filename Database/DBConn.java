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

//    public void query(String query)
//    {
//        try
//        {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next())
//            {
//                //doormiddel van kolomnaam
//                String name = rs.getString("color");
//                String number = rs.getString("number");
//
//                //doormiddel van kolomnaam
////                String satOf = rs.getString(1);
//                System.out.println(number+ " - " + name + ", satellite of ");
//            }
//            stmt.close();
//        } catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }

//    public void query(String query, String... columns)
//    {
//        try
//        {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next())
//            {
//                for(int i=0; i<columns.length; i++) {
//                    String name = rs.getString(columns[i]);
//                    if (i == 0){
//                        System.out.print(name + "");
//                    } else if (i %2==0) {
//                        System.out.println(name);
//                    } else {
//                        System.out.print(name + "");
//                    }
//
//                }
//
//
//                //doormiddel van kolomnaam
////                String name = rs.getString("color");
////                String number = rs.getString("number");
//
//                //doormiddel van kolomnaam
////                String satOf = rs.getString(1);
////                System.out.println(number+ " - " + name + ", satellite of ");
//            }
//            stmt.close();
//        } catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
}


