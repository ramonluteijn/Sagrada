import Database.AccountDB;
import Database.DBConn;
import Database.PlayerDB;
import View.MyScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
    }

//    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("jow");
        stage.setScene(new MyScene());
        stage.show();
    }
}



