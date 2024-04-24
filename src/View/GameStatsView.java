package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class GameStatsView extends BorderPane{

	BorderPane root;
	
	public GameStatsView() {
        super();
        this.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
        
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);
        
        this.setupRoot(this);
        
    }
	
	private void setupRoot(BorderPane root) {
		
		//main container with all the contents
	    VBox container = new VBox();
	    container.setPrefSize(500, 600);
        container.setSpacing(100);
        container.setPadding(new Insets(0,100,0,100));
        container.setAlignment(Pos.CENTER);
        root.setCenter(container);
        
        
        //add sorting button 
        Button sortButton = new Button("Sorteer op datum");
        sortButton.setPrefWidth(1720);
        sortButton.setOnAction(e -> { });
        container.getChildren().add(sortButton);
       
        
        //add the button to a HBox for aligning.
        HBox topContainer = new HBox(sortButton);
        topContainer.setAlignment(Pos.CENTER);
        topContainer.setSpacing(100);
	    topContainer.setPadding(new Insets(50,0,0,0));
        root.setTop(topContainer);

        
        
        
        //add VBox for all the rows of results
        VBox results = new VBox();
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setContent(results);
        scrollpane.setFitToWidth(true);
        
        
        container.getChildren().add(scrollpane);
        VBox.setMargin(results, new Insets(0,100,100,100));
        results.setBackground(new Background(new BackgroundFill(Color.HOTPINK,null,null)));
        
        
        
       	//add all the HBoxes with borders to the "results" VBox.
        for (int i = 0; i < 30; i++) {
			
        AnchorPane content = new AnchorPane();
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

        results.getChildren().add(content);
        content.setBorder(border);
        
        
        //add gameID labels
        Label gameID = new Label("GameID");
        gameID.setPadding(new Insets(20,20,20,20));
        content.getChildren().add(gameID);
        
        //add resume game buttons
        Button resumeGame = new Button("Hervat spel");
        resumeGame.setPadding(new Insets(20,20,20,20));
        content.getChildren().add(resumeGame);
        
        //set the alignment for the content
        AnchorPane.setLeftAnchor(gameID, 0.0);
        AnchorPane.setRightAnchor(resumeGame, 0.0);

        }
        
                
	}

}
