package View;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CardView extends HBox {
    private int amountOfCrads = 3;

    public CardView() {
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
            Rectangle card = card(Color.rgb(i * 30, i * 40, i * 50)); // Different color for PO cards
            poCardsList.getChildren().add(card);
        }

        return poCardsList;
    }

    private Rectangle card(Color color) {
        Rectangle rect = new Rectangle(100, 100); // Width and height of the rectangle
        rect.setFill(color);
        return rect;
    }
}
