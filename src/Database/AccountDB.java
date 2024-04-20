package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDB {
    private DBConn conn;

    public AccountDB(DBConn conn){
        this.conn = conn;
    }

    public void insertAccount(String username, String password) {
        if (conn.makeConnection()) {
            String query = "insert into account (username, password) VALUES ('"+username+"','"+password+"');";
            try {
                if(!checkIfUserExists(username)) {
                    Statement stmt = conn.getConn().createStatement();
                    stmt.executeUpdate(query);
                    System.out.println("nieuw");
                    stmt.close();
                }
                else {
                    System.out.println("bestaat");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean checkIfUserExists(String username) {
        boolean exist = false;
        if (conn.makeConnection()) {
            String query = "select * from account where username='"+username+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()) {
                    exist = true;
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return exist;
    }

    public String getAccount(String username, String password) {
        String account = "";
        if (conn.makeConnection()) {
            String query = "select * from account where username='"+username+"' AND password='"+password+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("username");
                    String pw = rs.getString("password");
                    account = name + pw;
                }
                if (!account.equals("")){
                    account = "bestaat";
                } else {
                    account = "bestaat niet";
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                account = "bestaat niet";
            }
        }
        return account;
    }


    public String getAccountsBySearch(String username) {
        String account = "";
        if (conn.makeConnection()) {
            String query = "select * from account where username like '%"+username+"%';";
            System.out.println(query);
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("username");
                    System.out.println(account = name);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return account;
    }

    public int getWinAmount(String username) {
        int win = 0;
        if (conn.makeConnection()) {
            String query =
                    "select count(p1.idgame) as wins from player as p1 " +
                    "inner join game on p1.idgame = game.idgame " +
                    "inner join player as p2 on game.idgame = p2.idplayer " +
                    "where p1.username name='"+username+"'order by p2.score desc";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    win = rs.getInt("wins");
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return win;
    }

    public int getLossAmount(String username) {
        int loss = 0;
        if (conn.makeConnection()) {
            String query =
                    "select count(player.idgame) from player " +
                    "where username='"+username+"' order by player.score desc;";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("username");
                    String pw = rs.getString("password");
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return loss;
    }

    public int getHighscore(String username) {
        int highscore = 0;
        if (conn.makeConnection()) {
            String query =
                    "select max(player.score) as highscore " +
                    "from player " +
                    "where username='"+username+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                highscore = rs.getInt("highscore");
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return highscore;
    }

    public String getMostPlacedDieColor(String username) {
        String dieColor = "";
        if (conn.makeConnection()) {
            String query =
                    "select count(playerframefield.diecolor) as color from player" +
                    "inner join playerframefield on playerframefield.idplayer = player.idplayer" +
                    "where username='"+username+"'group by playerframefield.diecolor order by count(playerframefield.diecolor) desc limit 1;";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                dieColor = rs.getString("color");
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return dieColor;
    }

    public int getMostPlacedDieNumber(String username) {
        int dieNumber = 0;
        if (conn.makeConnection()) {
            String query =
                    "select count(playerframefield.dienumber) as number from player" +
                    "inner join playerframefield on playerframefield.idplayer = player.idplayer" +
                    "where username='"+username+"'group by playerframefield.dienumber order by count(playerframefield.dienumber) desc limit 1;";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                dieNumber = rs.getInt("number");
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return dieNumber;
    }
}
