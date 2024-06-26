package Database;

import Model.ToolcardModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ToolcardDB {
    private DBConn conn;

    public ToolcardDB(DBConn conn){
        this.conn = conn;
    }

    public ToolcardModel getGameToolcard(int gameId) {
        ToolcardModel toolcardModel = null;
        if (conn.makeConnection()) {
            String query = "select * from gametoolcard inner join toolcard on gametoolcard.idtoolcard = toolcard.idtoolcard where idgame = '"+gameId+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    int id = rs.getInt("idtoolcard");
                    int seqnr = rs.getInt("seqnr");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    toolcardModel = new ToolcardModel(id,seqnr,name,description);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return toolcardModel;
    }

    public void insertGameToolcard(int gameId, int toolcardId) {
        if (conn.makeConnection()) {
            String query = "insert into gametoolcard (idtoolcard, idgame) VALUES ('"+toolcardId+"','"+gameId+"');";
            try {
                if(!checkIfGameToolcardExists(toolcardId, gameId)) {
                    Statement stmt = conn.getConn().createStatement();
                    stmt.executeUpdate(query);
                    stmt.close();
                    System.out.println("nieuw");
                }
                else {
                    System.out.println("bestaat");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkIfGameToolcardExists(int toolcardId, int gameId) {
        boolean exist = false;
        if (conn.makeConnection()) {
            String query = "select * from gameToolcard where idtoolcard='"+toolcardId+"' AND idgame='"+gameId+"';";
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
}