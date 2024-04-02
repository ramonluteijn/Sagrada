package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatDB {
    private DBConn conn;

    public ChatDB(DBConn conn){
        this.conn = conn;
    }

    //voorbeeld!!!!
    public void getDieList() {
        if (conn.makeConnection()) {
            String query = "select * from die";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    //doormiddel van kolomnaam
                    String name = rs.getString("color");
                    String number = rs.getString("number");

                    //doormiddel van kolomnummer
                    //String satOf = rs.getString(1);
                    System.out.println(number+ " - " + name + ", satellite of ");
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
