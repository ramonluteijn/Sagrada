package View;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SelectPatternView extends BorderPane{
	private PatternView selectedPatternCard = null;
	private Button selectButton = new Button("Continue");;
	
	public SelectPatternView(){

		this.setTop(getMenuBar());
		this.setCenter(getChooseCardsPane());
		this.setBottom(getFooter());
		this.setMinSize(400,  400);
		this.setPrefSize(1000, 800);
		this.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
		
		
	}

	private HBox getFooter() {
		HBox footer = new HBox();
		footer.setAlignment(Pos.CENTER);
		footer.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		
		

		
		selectButton.setPrefSize(150, 90);
		selectButton.setDisable(true);
		selectButton.setOnAction(e -> selected());
//		selectButton.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		
		Text selectText = new Text("Select a patterncard    ");
		
		
		footer.getChildren().addAll(selectText, selectButton);
		
		return footer;
	}

	private void selected() {
		System.out.println("going to game with this patternview, " + selectedPatternCard);
	}

	private GridPane getChooseCardsPane() {
		GridPane cards = new GridPane();


		cards.setHgap(20);
		cards.setVgap(20);
		cards.setAlignment(Pos.TOP_CENTER);
		cards.setPadding(new Insets(10, 10, 10, 10));
		System.out.println(this.prefHeightProperty());
		
		cards.add(new PatternView(this), 0, 0);
		cards.add(new PatternView(this), 1, 0);
		cards.add(new PatternView(this), 0, 1);
		cards.add(new PatternView(this), 1, 1);
		
		return cards;
	}
	
	private MenuBar getMenuBar() {
		MenuBar menubar = new MenuBar();
		Menu file = new Menu("file");
		MenuItem save = new MenuItem("save");
		file.getItems().add(save);
		menubar.getMenus().add(file);
		
		
		return menubar;
	}

	public void setSelectedPatternCard(PatternView patternCard) {
		if (this.selectedPatternCard != null) {  // resets the bordercolor of the unselected patternCard. but only if it exists
			this.selectedPatternCard.setBorder(new Border(new BorderStroke(Color.BISQUE, // color is the same as the background color
		            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK))); 
		}
		

		this.selectedPatternCard = patternCard;
		this.selectedPatternCard.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK))); // sets a border when selected.
		selectButton.setDisable(false);
	}
}
