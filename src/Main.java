import Database.DBConn;
import View.MyScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
    }

//    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sagrada");
        stage.setMaximized(true);
        stage.setScene(new MyScene());
        stage.show();
    }
}