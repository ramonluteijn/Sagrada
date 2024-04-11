package View;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    private Pane root;
    public MyScene() {
        super(new Pane());
        root = new Pane();
        root.getChildren().add(new SearchAccountView(this));

        this.setRoot(root);
    }
}