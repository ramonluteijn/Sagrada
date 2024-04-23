package View;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

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

        addDiceToRound(1, Color.BLUE);
        addDiceToRound(1, Color.GREEN);
        addDiceToRound(1, Color.BLUE);
        addDiceToRound(1, Color.GREEN);
        addDiceToRound(2, Color.RED);
        addDiceToRound(2, Color.YELLOW);
        addDiceToRound(3, Color.GREEN);
        addDiceToRound(3, Color.RED);
        addDiceToRound(3, Color.YELLOW);
    }

    public void addDiceToRound(int round, Color color) {
        DieView dice = new DieView(3, color);

        double diceWidth = rounds.get(round - 1).getPrefWidth() / 2 - 10;
        double diceHeight = rounds.get(round - 1).getPrefHeight() / 5;

        dice.setPrefSize(diceWidth, diceHeight);

        TilePane currentRoundPane = rounds.get(round - 1);

        currentRoundPane.getChildren().add(dice);

    }
}
