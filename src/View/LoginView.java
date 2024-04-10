package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import AccountDB;
import DBConn;


public class LoginView extends HBox {
    private MyScene scene;
    private TextField username;
    private TextField password;
    public LoginView(MyScene scene) {
        this.scene = scene;
        Button login = new Button("Login");
        Button register = new Button("Register");
        username = new TextField();
        password = new TextField();
        VBox layoutY = new VBox();
        HBox layoutX = new HBox();
        VBox formPos = new VBox();
        VBox form = new VBox();
        HBox buttons = new HBox();
        Label banner = new Label("SAGRADA");
        Label forUsername = new Label("Username:");
        Label forPassword = new Label("Password:");

        layoutY.getChildren().add(layoutX);
        layoutX.getChildren().addAll(formPos);
        formPos.getChildren().addAll(banner, form);
        form.getChildren().addAll(forUsername,username,forPassword,password,buttons);
        buttons.getChildren().addAll(login, register);

        layoutY.setAlignment(Pos.CENTER);
        layoutX.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);

        form.setPadding(new Insets(30,30,30,30));
        login.setPadding(new Insets(10,30,10,30));
        register.setPadding(new Insets(10,30,10,30));
        username.setPadding(new Insets(5));
        password.setPadding(new Insets(5));

        username.setPromptText("Username");
        password.setPromptText("Password");

        form.setSpacing(5);
        buttons.setSpacing(20);
        banner.setMaxWidth(Double.MAX_VALUE);
        banner.setAlignment(Pos.CENTER);
        banner.setPadding(new Insets(10,0,10,0));
        banner.setTextFill(Color.WHITE);
        banner.setFont(Font.font("Arial", 24));
        banner.setStyle("-fx-font-weight: bold");

        banner.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        formPos.setBackground(new Background(new BackgroundFill(Color.BISQUE,null,null)));

        layoutY.setPrefSize(800,600);

        this.getChildren().add(layoutY);

        login.setOnAction(e -> loginUser());
        register.setOnAction(e -> registerUser());
    }

    public void loginUser() {
        System.out.println(username.getText() + password.getText());
        System.out.println("login");

        //veranderen dmv main
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
        AccountDB acc = new AccountDB(conn);
        acc.getAccount(username.getText(), password.getText());
    }

    public void registerUser() {
        System.out.println(username.getText() + password.getText());
        System.out.println("regis");

        //veranderen dmv main

        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
        AccountDB acc = new AccountDB(conn);
        acc.insertAccount(username.getText(), password.getText());
    }
}