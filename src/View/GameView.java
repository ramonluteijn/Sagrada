package View;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameView extends Pane {
	
	public GameView() {
		
		Parent root = this.setupRoot();
		
		this.getChildren().add(root);
		
	}
	
	private Pane setupRoot() {
		BorderPane root = new BorderPane();
		//background colors = test
		
		Pane bottom = new Pane();
		bottom.setPrefSize(400, 100);
		bottom.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		Pane left = new Pane();
		left.setPrefSize(100, 400);
		left.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		Pane right = new Pane();
		right.setPrefSize(100, 400);
		right.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		Pane center = new Pane();
		center.setPrefSize(200, 200);
		center.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		Pane top = new Pane();
		top.setPrefSize(400, 100);
		top.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		
		//bottom
		//gamefooterview
		
		//left
		//favortokenview
		//cardsview
		
		//right
		//diceview
		
		//center
		//patterncard
		
		//top
		//scoreview
		//turnview
		
		//extra panes
		//chatview
		
		root.setTop(top);
		root.setLeft(left);
		root.setRight(right);
		root.setCenter(center);
		root.setBottom(bottom);
		
		return root;
	}
	
}
