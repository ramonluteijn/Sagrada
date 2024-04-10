package View;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    private Pane root;
    public MyScene() {
        super(new Pane());
        root = new SelectPatternView();
//        root = new LoginView(this);

        this.setRoot(root);
    }
}
