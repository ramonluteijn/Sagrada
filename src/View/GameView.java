package View;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class GameView extends BorderPane {
	
	private BorderPane centerpane;
	
	public GameView() {
		
		this.setupBorderPane();
		
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        this.setPrefSize(screenWidth, screenHeight);
	}
	
	private void setupBorderPane() {
		//background colors = test
		
		Pane bottompane = this.getBottomPane();
		VBox leftpane = this.getLeftPane();
		VBox rightpane = this.getRightPane();
		centerpane = this.getCenterPane();
		Pane top = new Pane();
		top.setPrefHeight(75);
		



		
		
		
		//extra panes
		//chatview
		
	//	this.setTop(top);
		this.setLeft(leftpane);
		this.setRight(rightpane);
		this.setCenter(centerpane);
		this.setBottom(bottompane);
		
	}
	
	private Pane getBottomPane() {
		Pane bottom = new Pane();
		bottom.setPrefSize(600, 100);
		bottom.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
		return bottom;
		//gamefooterview
	}
	
	private VBox getLeftPane() {
		VBox left = new VBox();
		left.setPrefSize(600, 600);
		left.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		
		CardView cardview = new CardView();
		
		left.getChildren().add(cardview);
		
		return left;
		//favortokenview

	}
	private VBox getRightPane() {
		VBox right = new VBox();
		right.setPrefSize(600, 600);
		right.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		
		DiceView diceview = new DiceView();
		
		
		right.getChildren().add(diceview);
		
		return right;
		//scoreview
	}
	
	private BorderPane getCenterPane() {
		BorderPane center = new BorderPane();
		center.setPrefSize(400, 400);
		center.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		
		PatternView patternview = new PatternView(new SelectPatternView());
		patternview.setPrefSize(720, 700);
		WindowPatternView windowpatternview = new WindowPatternView();
		windowpatternview.setPrefSize(720, 700);
		
		Pane pattern = new Pane();
		pattern.getChildren().addAll(patternview, windowpatternview);
		
		center.setCenter(pattern);
		
		return center;
	
		//turnview
	}
	
}
