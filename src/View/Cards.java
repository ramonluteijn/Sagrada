package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.List;

public abstract class Cards extends BorderPane {
    private int width = 175;

    public Cards() {
        this.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        this.setPrefSize(width, width + 75);
        this.setPadding(new Insets(10));
        this.setTop(getHeader());
        this.setCenter(getDescription());
        this.setBottom(getFooter());
    }

    public VBox getHeader() {
        VBox header = new VBox();
        HBox layout = new HBox();
        Label title = createLabel(null, 14.0);

        layout.getChildren().add(title);
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setMinHeight(30);

        header.getChildren().addAll(layout, getNumber());
        return header;
    }

    public Label createLabel(String name, Double size) {
        Label label = new Label(name);
        label.setFont(Font.font("Arial", size));
        label.setWrapText(true);
        label.setMaxWidth(width - 20);
        return label;
    }

    public Button createButton(String name, int width) {
        Button button = new Button(name);
        button.setPadding(new Insets(5, 10, 5, 10));
        button.setFont(Font.font("Arial", 12));
        button.setPrefWidth(width);
        switch (name) {
            case "Bekijken":
                button.setOnAction(e -> inspectCard());
                break;
            case "Kopen":
                button.setOnAction(e -> buyCard());
                break;
            case "Terugdraaien":
                button.setOnAction(e -> turnBack());
                break;
        }
        return button;
    }

    public HBox getNumber() {
        HBox layout = new HBox();
        Label seqnr = createLabel(null, 8.0);
        Line line1 = new Line();
        Line line2 = new Line();

        line1.setStrokeWidth(1);
        line2.setStrokeWidth(1);
        line1.setEndX(60);
        line2.setStartX(60);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(5);
        layout.getChildren().addAll(line1, seqnr, line2);
        return layout;
    }

    public HBox getDescription() {
        HBox layout = new HBox();
        Label description = createLabel(null, 14.0);
        layout.getChildren().add(description);
        return layout;
    }

    // check if it is toolcard or public objective card //todo
    public HBox getFooter() {
        HBox layout = new HBox();
        Button inspect = createButton("Bekijken", 75);
        Button buy = createButton("Kopen", 75);
        layout.getChildren().addAll(inspect, buy);
        layout.setSpacing(5);
        return layout;
    }

    public GridPane getInfo() {
        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(5);
        //vb arrays //todo
        List<String> names = Arrays.asList("Name1", "Name2", "Name3");
        List<Integer> tokens = Arrays.asList(5, 10, 15);

        layout.add(createLabel("Naam", 14.0), 0, 0);
        layout.add(createLabel("Tokens", 14.0), 1, 0);
        for (int i = 0; i < names.size(); i++) {
            Label name = createLabel(names.get(i), 14.0);
            Label token = createLabel(String.valueOf(tokens.get(i)), 14.0);
            token.setAlignment(Pos.CENTER);
            layout.add(name, 0, i + 1);
            layout.add(token, 1, i + 1);
        }
        return layout;
    }

    public HBox getFrontSide() {
        HBox layout = new HBox();
        Button turnBack = createButton("Terugdraaien", width);
        layout.getChildren().add(turnBack);
        layout.setSpacing(5);
        return layout;
    }

    public void turnBack() {
        this.setCenter(getDescription());
        this.setBottom(getFooter());
    }

    public void inspectCard() {
        this.setCenter(getInfo());
        this.setBottom(getFrontSide());
    }

    public void buyCard() {
    }
}
