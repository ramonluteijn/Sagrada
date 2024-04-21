package View;

import Controller.AccountController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {
    private Pane root;
    private AccountController accountController;

    public MyScene() {
        super(new Pane());
        root = new Pane();
        this.setRoot(root);

        // Maak een AccountController-object
        accountController = new AccountController();

        root.getChildren().add(new LoginView(this, accountController)); // Pass the accountController instance to LoginView constructor
    }

    public void goToLobby() {
        root.getChildren().add(new MenuBarView(this));
        root.getChildren().set(0, new LobbyView());
    }

    public void openLoginView() {
        root.getChildren().remove(1);
        root.getChildren().set(0,new LoginView(this, accountController)); // Pass the accountController instance to LoginView constructor
    }
}
