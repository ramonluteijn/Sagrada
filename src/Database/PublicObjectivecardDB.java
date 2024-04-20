package Database;

import Model.Toolcard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PublicObjectivecardDB {
    private DBConn conn;

    public PublicObjectivecardDB(DBConn conn){
        this.conn = conn;
    }

    public void getPublicObjectiveList() {
        if (conn.makeConnection()) {
            String query = "select * from public_objectivecard;";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    String id = rs.getString("idpublic_objectivecard");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String points = rs.getString("points");
                    System.out.println(id + " - " + name + " - " + description + " - " + points);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Toolcard getGamePublicObjectivecard(int gameId) {
        Toolcard toolcard = null;
        if (conn.makeConnection()) {
            String query = "select * from gameobjectivecard_public inner join public_objectivecard on gameobjectivecard_public.idpublic_objectivecard = public_objectivecard.idpublic_objectivecard where idgame = '"+gameId+"';";
            try {
                Statement stmt = conn.getConn().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    int id = rs.getInt("idpublic_objectivecard");
                    int points = rs.getInt("points");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    toolcard = new Toolcard(id,points,name,description);
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return toolcard;
    }

    public void insertGamePublicObjectivecard(int gameId, int publicObjectivecardId) {
        if (conn.makeConnection()) {
            String query = "insert into gameobjectivecard_public (idpublic_objectivecard, idgame) VALUES ('"+publicObjectivecardId+"','"+gameId+"');";
            try {
                if(!checkIfGamePublicObjetivecardExists(publicObjectivecardId, gameId)) {
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

    public boolean checkIfGamePublicObjetivecardExists(int publicObjectivecardId, int gameId) {
        boolean exist = false;
        if (conn.makeConnection()) {
            String query = "select * from gameobjectivecard_public where idpublic_objectivecard='"+publicObjectivecardId+"' AND idgame='"+gameId+"';";
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
