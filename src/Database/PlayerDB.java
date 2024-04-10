package src.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDB {


    private DBConn conn;

    public PlayerDB(DBConn conn){
        this.conn = conn;
    }

    public void insertPlayer(String username, int gameId, String playstatus, int seqnr, String po_color, int patterncardId, int score) {
        if (conn.makeConnection()) {
            String query =
                    "insert into player (username, idgame, playstatus, seqnr, private_objective_color, idpatterncard, score) " +
                    "VALUES ('"+username+"','"+gameId+"','"+playstatus+"','"+seqnr+"','"+po_color+"','"+patterncardId+"','"+score+"');";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updatePlayer(int playerId, String playstatus, int score) {
        if (conn.makeConnection()) {
            String query = "update player set playstatus = '"+playstatus+"', score = '"+ score+"'where idplayer = '"+playerId+"';";
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

    public String getPlayer(String username, int gameId) {
        String player = "";
        if (conn.makeConnection()) {
            String query = "select * from player where username='"+username+"' AND idgame='"+gameId+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("username");
                    String playstatus = rs.getString("playstatus");
                    String seqnr = rs.getString("seqnr");
                    String po_color = rs.getString("private_objective_color");
                    String patterncardId = rs.getString("idpatterncard");
                    String score = rs.getString("score");
                    System.out.println(player = name + playstatus + seqnr + po_color + patterncardId + score);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return player;
    }

    public ArrayList<String> getPlayersInGame(int gameId) {
        ArrayList<String>players = new ArrayList<String>();
        if (conn.makeConnection()) {
            String query = "select * from player where idgame='"+gameId+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("username");
                    String seqnr = rs.getString("seqnr");
                    String patterncardId = rs.getString("idpatterncard");
                    String score = rs.getString("score");
                    System.out.println(players.add(name + seqnr + patterncardId + score));
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return players;
    }
}
