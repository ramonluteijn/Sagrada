package src.View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.geometry.Pos;


public class LobbyView extends HBox {
    public LobbyView(){

        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        double buttonWidth = screenWidth / 4;
        double buttonHeight = screenHeight / 4;

        setPrefSize(screenWidth, screenHeight);

        setupButtons(buttonWidth, buttonHeight);
        setAlignment(Pos.CENTER);
        setSpacing(50);
    }

    private void setupButtons(double buttonWidth, double buttonHeight) {
        Button hostGameButton = new Button("Host game");
        Button challengesButton = new Button("Challenges");

        hostGameButton.setOnAction(e -> hostButton());
        challengesButton.setOnAction(e -> challengesButton());
        hostGameButton.setPrefSize(buttonWidth, buttonHeight);
        challengesButton.setPrefSize(buttonWidth, buttonHeight);

        getChildren().addAll(hostGameButton, challengesButton);
    }

    private void hostButton(){
        //scene.hostView();
    }

    private void challengesButton(){
        //scene.challengesView();
    }
}
