package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDieDB {
    private final DBConn conn;

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
                    int gameID = rs.getInt("idgane");
                    int dieNumber = rs.getInt("dienumber");
                    String dieColor = rs.getString("diecolor");
                    int eyes = rs.getInt("eyes");
                    int roundtrack = rs.getInt("roundtrack");
                    int roundID = rs.getInt("roundID");
                    System.out.println(gameID + " - " + dieNumber + " - " + dieColor + " - " + eyes + " - " + roundtrack + " - " + roundID);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getGameDie(int gameId, int dieNumber, String dieColor) {
        if (conn.makeConnection()) {
            String query = "select * from gamedie where idgame = '"+gameId+"' AND dieumber = '"+dieNumber+"' AND diecolor = '"+dieColor+"'";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                    int idgame = rs.getInt("idgane");
                    int number = rs.getInt("dienumber");
                    String color = rs.getString("diecolor");
                    int eyes = rs.getInt("eyes");
                    int roundtrack = rs.getInt("roundtrack");
                    int roundID = rs.getInt("roundID");
                    System.out.println(idgame + " - " + number + " - " + color + " - " + eyes + " - " + roundtrack + " - " + roundID);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertGameDie(int gameId, int dieNumber, String dieColor, int eyes, int roundtrack, int roundID) {
        if (conn.makeConnection()) {
            String query =
                    "insert into gamedie (idgame, dienumber, diecolor, eyes, roundtrack, roundID)" +
                            "VALUES ('"+gameId+"','"+dieNumber+"','"+dieColor+"','"+eyes+"','"+roundtrack+"','"+roundID+"');";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateGameDie(int gameId, int dieNumber, String dieColor, int eyes, int roundtrack, int roundID) {
        if (conn.makeConnection()) {
            String query = "update gamedie set eyes = '"+eyes+"', roundtrack = '"+roundtrack+"', roundID = '"+roundID+"' where idgame = '"+gameId+"' AND dienumber = '"+dieNumber+"' AND diecolor = '"+dieColor+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                System.out.println("geupdate");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}