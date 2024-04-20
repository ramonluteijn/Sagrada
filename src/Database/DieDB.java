package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DieDB {
    private DBConn conn;

    public DieDB(DBConn conn) {
        this.conn = conn;
    }

    public void getDieList() {
        if (conn.makeConnection()) {
            String query = "select * from die";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String number = rs.getString("number");
                    String color = rs.getString("color");
                    System.out.println(number + " - " + color);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //color is string or color? //todo
    public void getDie(int dieNumber, String dieColor) {
        if (conn.makeConnection()) {
            String query = "select * from die where number = '" + dieNumber + "' AND color = '"+dieColor+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String number = rs.getString("number");
                    String color = rs.getString("color");
                    System.out.println(number + " - " + color);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
