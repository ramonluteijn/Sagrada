package View;

import Controller.ObjectiveCardController;
import Controller.ToolcardController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CardView extends HBox {
    private int amountOfCrads = 3;
    private ToolcardController toolcardController;
    private ObjectiveCardController objectiveCardController;

    public CardView() {
        this.objectiveCardController = new ObjectiveCardController();
        this.toolcardController = new ToolcardController();
        VBox toolCardsBox = toolcardsList();
        VBox poCardsBox = pocardsList();
        this.getChildren().addAll(toolCardsBox, poCardsBox);
        this.setSpacing(20);
    }

    private VBox toolcardsList() {
        VBox toolCardsList = new VBox();
        for (int i = 0; i < amountOfCrads; i++) {
            toolCardsList.setSpacing(10);

            toolCardsList.getChildren().add(new ToolcardView());
        }
        return toolCardsList;
    }

    private VBox pocardsList() {
        VBox poCardsList = new VBox();
        for (int i = 0; i < amountOfCrads; i++) {
            poCardsList.setSpacing(10);
            poCardsList.getChildren().add(new PublicObjectivecardView());
        }
        return poCardsList;
    }

}
