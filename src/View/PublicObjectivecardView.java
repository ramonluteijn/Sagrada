package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class PublicObjectivecardView extends Cards {

    public PublicObjectivecardView() {
        super();
    }

    //create header
    @Override
    public VBox getHeader() {
        VBox layout = super.getHeader();
        Label title = createLabel("Row Shade Variety", 14.0);
        ((HBox) layout.getChildren().get(0)).getChildren().set(0, title);//node is being cast to HBox
        layout.setAlignment(Pos.CENTER);
        return layout;
    }

    //create card number
    @Override
    public HBox getNumber() {
        HBox layout = super.getNumber();
        Label seqnr = new Label("01");
        layout.getChildren().set(1, seqnr);
        return layout;
    }

    //create card description
    @Override
    public HBox getDescription() {
        HBox layout = super.getDescription();
        Label description = createLabel("Sets of one of each shade anywhere", 14.0);
        layout.getChildren().set(0, description);
        return layout;
    }
}
