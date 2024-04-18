package View;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    private Pane root;
    public MyScene() {
        super(new Pane());
        //root = new SelectPatternView();
        root = new LoginView(this);
        this.setRoot(root);
    }

    public void goToLobby() {
        root.getChildren().add(new MenuBarView(this));
        root.getChildren().set(0, new LobbyView());
    }

    public void openLoginView() {
        root.getChildren().remove(1);
        root.getChildren().set(0,new LoginView(this));
    }
}