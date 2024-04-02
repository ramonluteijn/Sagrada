import Database.AccountDB;
import Database.DBConn;
import Database.PlayerDB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
//        launch(args);
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
//        PlayerDB chat = new PlayerDB(conn);
//        System.out.println(chat.getDieList());
        AccountDB acc = new AccountDB(conn);
        acc.getAccount("ramon2", "123452");

    }

//    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sagrada");
        stage.setScene(new Scene(new Pane()));
        stage.show();
    }
}



