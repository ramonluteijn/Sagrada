package View;

import Controller.AccountController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;


public class LoginView extends BorderPane {
    private final MyScene scene;
    private TextField username;
    private PasswordField password;
    private Label failedLabel;
    private AccountController accountController;
    private AccountController account; // <-- Toegevoegd

    // constructor for the login view
    public LoginView(MyScene scene , AccountController accountController) {
        this.accountController = new AccountController();
        this.scene = scene;
        this.account = accountController; // <-- Toegevoegd
        this.setCenter(getForm());
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);
    }

    // create a textfield for the username and password
    private TextInputControl createField(String name) {
        TextInputControl field;
        if (name.equals("Wachtwoord")) {
            field = new PasswordField();
        } else {
            field = new TextField();
        }
        field.setPadding(new Insets(5));
        field.setPromptText(name);
        return field;
    }

    // create a label with a specific name, size and color
    private Label createLabel(String name, Double size, Color color) {
        Label label = new Label(name);
        label.setAlignment(Pos.CENTER);
        label.setTextFill(color);
        label.setFont(Font.font("Arial", size));
        label.setMaxWidth(Double.MAX_VALUE);
        return label;
    }

    // create a button with a specific name
    private Button createButton(String name) {
        Button button = new Button(name);
        button.setPadding(new Insets(10, 30, 10, 30));
        button.setFont(Font.font("Arial", 16));
        if (name.equals("Login")) {
            button.setOnAction(e -> loginUser());
        } else {
            button.setOnAction(e -> registerUser());
        }
        return button;
    }

    // create the form for the login view
    private VBox getForm() {
        VBox form = new VBox();
        username = (TextField) createField("Gebruikersnaam");
        password = (PasswordField) createField("Wachtwoord");
        Label banner = createLabel("SAGRADA", 24.0, Color.BLACK);
        failedLabel = createLabel(" Log in om door te gaan.", 12.0, Color.RED);

        form.setSpacing(15);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(30, 30, 30, 30));
        form.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
        form.setMaxSize(400, 400);
        form.getChildren().addAll(banner, username, password, getButtons(), failedLabel);
        return form;
    }

    // create the buttons for the login view
    private HBox getButtons() {
        HBox buttons = new HBox();
        Button login = createButton("Login");
        Button register = createButton("Register");

        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.getChildren().addAll(login, register);
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