package View;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    private Pane root;
    public MyScene() {
        super(new Pane());
        root = new Pane();
        root.getChildren().add(new LoginView(this));
        this.setRoot(root);
    }

    public void goToLobby() {
        root.getChildren().set(0, new LobbyView());
        root.getChildren().add(new MenuBarView(this));
    }

    public void openLoginView() {
        root.getChildren().remove(1);
        root.getChildren().set(0,new LoginView(this));
    }
}
