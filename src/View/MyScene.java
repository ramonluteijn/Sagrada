package View;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    private Pane root;
    public MyScene() {
        super(new Pane());
        
        FavorTokensView tokens = new FavorTokensView();
        
        root = new Pane();
        root.getChildren().add(tokens);
 
        tokens.createFavortoken(1);
        tokens.drawFavortokens();
        
        this.setRoot(root);
    }
}
