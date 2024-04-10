package src;

import javafx.application.Application;
import javafx.stage.Stage;
import DBConn;
import MyScene;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
    }

//    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sagrada");
        stage.setScene(new MyScene());
        stage.setMaximized(true);
        stage.show();
    }
}



