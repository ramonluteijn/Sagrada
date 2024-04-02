package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDB {
    private DBConn conn;

    public PlayerDB(DBConn conn){
        this.conn = conn;
    }
    public String getDieList() {
        String text = "";
        if (conn.makeConnection()) {
            String query = "select * from playstatus";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("playstatus");
                    text += name + "\n";
                }
                stmt.close();
            } catch (SQLException e) {
                text = e.getMessage();
            }
        }
        return text;
    }
}
