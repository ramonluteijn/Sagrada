package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GameDB {
    private DBConn conn;

    public GameDB(DBConn conn){
        this.conn = conn;
    }

    public void insertGame(int playerId) {
        if (conn.makeConnection()) {
            String query =
                    "insert into game (turn_idplayer, current_roundID, creationdate) " +
                    "VALUES ('"+playerId+"',(select roundID from round where roundID = 1),'"+ LocalDateTime.now()+"');";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateGame(int playerId, int roundid) {
        if (conn.makeConnection()) {
            String query =
                    "update game set turn_idplayer = '"+playerId+"', roundID = '"+roundid+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getGame(int gameId) {
        String game = "";
        if (conn.makeConnection()) {
            String query = "select * from game where idgame='"+gameId+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    int turn_idplayer = rs.getInt("turn_idplayer");
                    int roundID = rs.getInt("roundID");
                    Timestamp creationdate = rs.getTimestamp("creationdate");
                    System.out.println(game = gameId + " - " + turn_idplayer + " - " + roundID + " - " + creationdate);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return game;
    }

    // set standard sorting to do descending within view (newest games first), change with button.
    public void getOrderGameslist(String username, String sorting) {
        if (conn.makeConnection()) {
            String query = "select * from game inner join Payer on game.idgame = player.idgame where player.username = '"+username+" order by creationdate "+sorting+"'";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    int turn_idplayer = rs.getInt("turn_idplayer");
                    int roundID = rs.getInt("roundID");
                    Timestamp creationdate = rs.getTimestamp("creationdate");
                    System.out.println(turn_idplayer + " - " + roundID + " - " + creationdate);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
