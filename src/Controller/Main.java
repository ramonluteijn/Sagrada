package Controller;

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

        MainController mainController = new MainController();

        stage.setTitle("Sagrada");
        stage.setScene(new MyScene());
        stage.show();

    }
}