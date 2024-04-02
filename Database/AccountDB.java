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
                    stmt.close();
                    System.out.println("nieuw");
                }
                else {
                    System.out.println("bestaat");
                }
            } catch (SQLException e) {
                 e.getMessage();
            }
        }
    }

    public boolean checkIfUserExists(String username) {
        boolean exist = true;
        if (conn.makeConnection()) {
            String query = "select * from account where username='"+username+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()) {
                    exist = true;
                }
                else {
                    exist = false;
                }
                stmt.close();
            } catch (SQLException e) {
                e.getMessage();
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
                    System.out.println(account = name + pw);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return account;
    }
}
