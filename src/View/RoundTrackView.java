package View;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class RoundTrackView extends HBox {

    private List<TilePane> rounds;

    public RoundTrackView() {

        setPrefSize(2000, 400);
        setPadding(new Insets(0));

        rounds = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TilePane roundPane = new TilePane();
            roundPane.setPrefSize(getPrefWidth() / 10, getPrefHeight());
            roundPane.setPrefColumns(2);
            roundPane.setPadding(new Insets(0));
            roundPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    BorderStroke.THIN)));
            rounds.add(roundPane);
        }

        this.getChildren().addAll(rounds);

    }

    public void addDiceToRound(int round, Color color, int numberRolled) {
        DieView dice = new DieView(numberRolled, color);

        double diceWidth = rounds.get(round - 1).getPrefWidth() / 2 - 10;
        double diceHeight = rounds.get(round - 1).getPrefHeight() / 5;

        dice.setPrefSize(diceWidth, diceHeight);

        TilePane currentRoundPane = rounds.get(round - 1);

        currentRoundPane.getChildren().add(dice);

    }
}
