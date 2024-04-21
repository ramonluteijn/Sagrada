package View;

import Controller.ChallengeController;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ChallengesView extends HBox {
    private VBox accountBox;
    
    

    public ChallengesView(ChallengeController challengecontroller) {
    	accountBox = new VBox();
        
    	this.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
    	this.getChildren().add(accountBox);
    }
/*
    public void setInvites(List<Account> accounts) {
        int buttonHeight = 30;
        int buttonWidth = 80;
        for (Account account : accounts) {
            HBox nameAndButton = new HBox();

            Button nameButton = new Button(account.getName());
            nameButton.setPrefWidth(150);
            nameButton.setMinHeight(buttonHeight);

            Button acceptButton = new Button("Accept");
            acceptButton.setPrefWidth(buttonWidth);
            acceptButton.setMinHeight(buttonHeight);

            Button rejectButton = new Button("Reject");
            rejectButton.setPrefWidth(buttonWidth);
            rejectButton.setMinHeight(buttonHeight);

            nameButton.setOnAction(c -> openAccountDetails(account));
            acceptButton.setOnAction(c -> setInviteStatus(true, nameAndButton));
            rejectButton.setOnAction(c -> setInviteStatus(false, nameAndButton));

            nameAndButton.getChildren().addAll(nameButton, acceptButton, rejectButton);

            accountBox.getChildren().add(nameAndButton);
        }
    }


    private void openAccountDetails(Account account) {
    }
*/
    private void setInviteStatus(boolean status, HBox ref) {
        accountBox.getChildren().remove(ref);
        //Reference to Controller to connect to DB to update invite status?


    }
}
