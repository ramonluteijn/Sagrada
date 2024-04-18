package View;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ToolcardView extends Cards {


    public ToolcardView() {
        super();
    }

    @Override
    public VBox getHeader() {
        VBox layout = super.getHeader();
        Rectangle color = new Rectangle();
        color.setFill(Color.RED);
        color.setWidth(25);
        color.setHeight(25);
        color.setStroke(Color.BLACK);
        Label title = createLabel("Cork-backed Straightedge", 14.0);
        ((HBox) layout.getChildren().get(0)).getChildren().set(0, color);//node is being cast to HBox, title place is being replaced by color
        ((HBox) layout.getChildren().get(0)).getChildren().add(title);//node is being cast to HBox, title is being added to the end of the list
        return layout;
    }

    @Override
    public HBox getNumber() {
        HBox layout = super.getNumber();
        Label seqnr = new Label("10");
        layout.getChildren().set(1, seqnr);
        return layout;
    }

    @Override
    public HBox getDescription() {
        HBox layout = super.getDescription();
        Label description = createLabel("After drafting, return the die to the Dice Bag and pull 1 die from the bag. Choose a value and place the new die, obeying all placement restrictions, or return it to the Draft Pool.", 14.0);
        layout.getChildren().set(0, description);
        return layout;
    }
}
