package View;

import Controller.AccountController;
import Database.AccountDB;
import Database.DBConn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class LoginView extends BorderPane {
    private MyScene scene;
    private TextField username;
    private TextField password;
    private Button login;
    private Button register;
    private Label failedLabel;
    private AccountController accountController;

    public LoginView(MyScene scene) {
        this.accountController = new AccountController();
        this.scene = scene;
        this.setCenter(getForm());
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);
    }

    private TextField createTextField(String name) {
        TextField textField = new TextField();
        textField.setPadding(new Insets(5));
        textField.setPromptText(name);
        return textField;
    }

    private Label createLabel(String name,Double size ,Color color) {
        Label label = new Label(name);
        label.setAlignment(Pos.CENTER);
        label.setTextFill(color);
        label.setFont(Font.font("Arial", size));
        label.setMaxWidth(Double.MAX_VALUE);
        return label;
    }

    private Button createButton(String name) {
        Button button = new Button(name);
        button.setPadding(new Insets(10,30,10,30));
        button.setFont(Font.font("Arial", 16));
        if(name.equals("Login")) {
            button.setOnAction(e -> loginUser());
        }
        else {
            button.setOnAction(e -> registerUser());
        }
        return button;
    }

    private VBox getForm() {
        VBox form = new VBox();
        username = createTextField("Gebruikersnaam");
        password = createTextField("Wachtwoord");
        Label banner = createLabel("SAGRADA", 24.0,Color.BLACK);
        failedLabel = createLabel(" Log in om door te gaan.",12.0 ,Color.RED);

        form.setSpacing(15);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(30,30,30,30));
        form.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
        form.setMaxSize(400,400);
        form.getChildren().addAll(banner, username, password, getButtons(), failedLabel);
        return form;
    }

    private HBox getButtons() {
        HBox buttons = new HBox();
        login = createButton("Login");
        register = createButton("Register");

        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.getChildren().addAll(login, register);
        return buttons;
    }

//todo
    // length check
    // ^ controller

    public void loginUser() {
        //veranderen dmv controller etc
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
        AccountDB acc = new AccountDB(conn);
        String check = acc.getAccount(username.getText(), password.getText());
        if (check.equals("bestaat")) {
            scene.goToLobby();
        }
        else {
            failedLabel.setText("Inloggen mislukt, kijk of de juiste gegevens zijn ingevoerd.");
        }

    }
//todo
    //check if exist fucked up
    // via controller en dan melding teruggeven.
    public void registerUser() {
        //veranderen dmv controller etc
        DBConn conn = new DBConn("com.mysql.cj.jdbc.Driver");
        AccountDB acc = new AccountDB(conn);

        if(!acc.checkIfUserExists(username.getText())) {
            acc.insertAccount(username.getText(), password.getText());
            scene.goToLobby();
        }
        else {
            failedLabel.setText("Deze gebruiker bestaat al, kies een andere naam.");
        }
    }
}