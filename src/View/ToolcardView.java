package View;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ToolcardView extends Cards {


    public ToolcardView() {
        super();
    }

    @Override
    public VBox getHeader() {
        VBox layout = super.getHeader();
        Label title = createLabel("Cork-backed Straightedge",14.0);
        ((HBox) layout.getChildren().get(0)).getChildren().set(1, title);//node is being cast to HBox
        return layout;
    }

    @Override
    public HBox getNumber() {
        HBox layout = super.getNumber();
        Label seqnr = new Label("10");
        layout.getChildren().set(1,seqnr);
        return layout;
    }

    @Override
    public HBox getDescription() {
        HBox layout = super.getDescription();
        Label description = createLabel("After drafting, return the die to the Dice Bag and pull 1 die from the bag. Choose a value and place the new die, obeying all placement restrictions, or return it to the Draft Pool.", 14.0);
        layout.getChildren().set(0,description);
        return layout;
    }
}
