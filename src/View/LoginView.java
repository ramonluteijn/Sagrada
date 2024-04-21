package View;

import Controller.AccountController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginView extends BorderPane {
    private MyScene scene;
    private TextField username;
    private TextField password;
    private Button login;
    private Button register;
    private Label failedLabel;
    private AccountController account;

    public LoginView(MyScene scene, AccountController accountController) {
        this.scene = scene;
        this.account = accountController; // <-- Toegevoegd
        this.setCenter(getForm());
        this.setPrefSize(500,500);
    }

    private VBox getForm() {
        VBox form = new VBox();
        username = new TextField();
        password = new TextField();
        Label banner = new Label("SAGRADA");
        failedLabel = new Label();

        failedLabel.setMaxWidth(Double.MAX_VALUE);
        failedLabel.setAlignment(Pos.CENTER);
        failedLabel.setTextFill(Color.RED);
        failedLabel.setFont(Font.font("Arial", 12));
        failedLabel.setStyle("-fx-font-weight: bold");

        banner.setMaxWidth(Double.MAX_VALUE);
        banner.setAlignment(Pos.CENTER);
        banner.setTextFill(Color.BLACK);
        banner.setFont(Font.font("Arial", 24));
        banner.setStyle("-fx-font-weight: bold");

        username.setPadding(new Insets(5));
        password.setPadding(new Insets(5));
        username.setPromptText("Username");
        password.setPromptText("Password");

        form.setSpacing(15);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(30,30,30,30));
        form.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));

        form.getChildren().addAll(banner, username, password, getButtons(), failedLabel);
        return form;
    }

    private HBox getButtons() {
        HBox buttons = new HBox();
        login = new Button("Login");
        register = new Button("Register");

        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.getChildren().addAll(login, register);


        login.setPadding(new Insets(10,30,10,30));
        register.setPadding(new Insets(10,30,10,30));
        login.setFont(Font.font("Arial", 16));
        register.setFont(Font.font("Arial", 16));
        login.setOnAction(e -> loginUser());
        register.setOnAction(e -> registerUser());

        return buttons;
    }

    public void loginUser() {
        if (account.authenticateUser(username.getText(), password.getText())) {
            scene.goToLobby();
        }
        else {
            failedLabel.setText("login failed, check your username and password.");
        }
    }

    public void registerUser() {
                if(account.registerUser(username.getText(), password.getText())) {
            scene.goToLobby();
        }
        else {
            failedLabel.setText("this username already exists, choose another one.");
        }
    }
}