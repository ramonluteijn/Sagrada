package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ToolcardDB {
    private DBConn conn;

    public ToolcardDB(DBConn conn){
        this.conn = conn;
    }

    public void getToolcardList() {
        if (conn.makeConnection()) {
            String query = "select * from toolcard";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String name = rs.getString("name");
                    String seqnr = rs.getString("seqnr");
                    System.out.println(seqnr+ " - " + name);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
