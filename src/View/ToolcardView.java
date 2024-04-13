package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ToolcardView extends VBox {
    private int width = 175;

    public ToolcardView() {
        this.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN,null,null)));
        this.setPrefSize(width,width+50);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(getHeader(), getNumber(),getDescription());
    }

    private HBox getHeader() {
        HBox layout = new HBox();
        Rectangle color = new Rectangle();
        Label title = new Label("Running Pliers");
        title.setFont(Font.font("Arial", 14));
        title.setStyle("-fx-font-weight: bold");
        title.setWrapText(true);
        title.setMaxWidth(width);
        color.setFill(Color.RED);
        color.setWidth(25);
        color.setHeight(25);
        color.setStroke(Color.BLACK);
        layout.getChildren().addAll(color, title);
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER_LEFT);
        return layout;
    }
    private HBox getNumber() {
        HBox layout = new HBox();
        Label seqnr = new Label("0");
        Line line1 = new Line();
        Line line2 = new Line();
        line1.setStrokeWidth(1);
        line2.setStrokeWidth(1);
        line1.setStartX(0);
        line1.setEndX(width/2);
        line2.setStartX(width/2);
        line2.setEndX(width);
        layout.getChildren().addAll(line1,seqnr, line2);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(5);
        return layout;
    }

    private Pane getDescription() {
        Pane layout = new Pane();
        Label description = new Label("After drafting, return the die to the Dice Bag and pull 1 die from the bag. Choose a value and place the new die, obeying all placement restrictions, or return it to the Draft Pool.");
        description.setWrapText(true);
        description.setFont(Font.font("Arial", 14));
        description.setMaxWidth(width);
        layout.getChildren().addAll(description);
        description.maxHeight(width);
        return layout;
    }
}
