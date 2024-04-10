package View;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class MenuBarView extends HBox {

    public MenuBarView(MyScene scene) {
        Button homeButton = new Button("Home");
        Button logOutButton = new Button("Log Out");
        Button settingsButton = new Button("Settings");
        Button statsButton = new Button("Stats");

        homeButton.setOnAction(e -> homeButton(scene));
        logOutButton.setOnAction(e -> logOutButton(scene));
        settingsButton.setOnAction(e -> settingsButton(scene));
        statsButton.setOnAction(e -> statsButton(scene));

        homeButton.setPadding(new Insets(10,10,10,10));
        logOutButton.setPadding(new Insets(10,10,10,10));
        settingsButton.setPadding(new Insets(10,10,10,10));
        statsButton.setPadding(new Insets(10,10,10,10));
        this.getChildren().addAll(homeButton, statsButton, settingsButton, logOutButton);
    }

    private void homeButton(MyScene scene){
        //scene.openHomeView();
    }

    private void statsButton(MyScene scene){
        //scene.openStatsView();
    }

    private void settingsButton(MyScene scene){
        //scene.openSettingsView();
    }

    private void logOutButton(MyScene scene){
        //scene.openLoginView();
        //accountController.logOut();
    }
}
