package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ChatDB {
    private DBConn conn;

    public ChatDB(DBConn conn){
        this.conn = conn;
    }

    public String getChat() {
        String chat = "";

        if (conn.makeConnection()) {
            String query = "select * from chatline";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String playerid = rs.getString("idplayer");
                    Timestamp time = rs.getTimestamp("time");
                    String message = rs.getString("message");
                    System.out.println(chat = playerid + time + message);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return chat;
    }

    public void insertChat(int playerId, Timestamp time, String message) {
        if (conn.makeConnection()) {
            String query =
                    "insert into chatline (idplayer, time, message)" +
                            "VALUES ('"+playerId+"','"+time+"','"+message+"');";
            try {
                Statement stmt = conn.getConn().createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
