package View;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ToolcardView extends GameCardsView {


    public ToolcardView() {
        super();
        this.setBottom(getFooter());
    }

    //create header + color
    @Override
    public VBox getHeader() {
        VBox layout = super.getHeader();
        Rectangle color = new Rectangle();
        color.setFill(Color.RED);
        color.setWidth(25);
        color.setHeight(25);
        color.setStroke(Color.BLACK);
        Label title = createLabel("Cork-backed Straightedge", 14.0);
        HBox titleContainer = (HBox) layout.getChildren().get(0);//node is being cast to HBox, check if first node is HBox
        titleContainer.getChildren().set(0, color);//title place is being replaced by color
        titleContainer.getChildren().add(title);
        return layout;
    }

    //create card number
    @Override
    public HBox getNumber() {
        HBox layout = super.getNumber();
        Label seqnr = new Label("10");
        layout.getChildren().set(1, seqnr);
        return layout;
    }

    //create card description
    @Override
    public HBox getDescription() {
        HBox layout = super.getDescription();
        Label description = createLabel("After drafting, return the die to the Dice Bag and pull 1 die from the bag. Choose a value and place the new die, obeying all placement restrictions, or return it to the Draft Pool.", 14.0);
        layout.getChildren().set(0, description);
        return layout;
    }
}
