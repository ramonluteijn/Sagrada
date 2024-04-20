package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDieDB {
    private DBConn conn;
    public GameDieDB(DBConn conn){
        this.conn = conn;
    }

    public void getGameDieList() {
        if (conn.makeConnection()) {
            String query = "select * from gamedie";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    int gameId = rs.getInt("idgane");
                    int dieNumber = rs.getInt("dienumber");
                    String dieColor = rs.getString("diecolor");
                    int eyes = rs.getInt("eyes");
                    int roundtrack = rs.getInt("roundtrack");
                    int roundID = rs.getInt("roundID");
                    System.out.println(gameId + " - " + dieNumber + " - " + dieColor + " - " + eyes + " - " + roundtrack + " - " + roundID);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
