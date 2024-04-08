import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        DBConn conn = new DBConn();
        if (conn.loadDataBaseDriver("com.mysql.cj.jdbc.Driver")
                && (conn.makeConnection()))
        {
            conn.query("select * from hemelobject");
        }
    }

//    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sagrada");
        stage.setScene(new Scene(new Pane()));
        stage.show();
        // halllo
    }
}



