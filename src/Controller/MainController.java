package Controller;

public class MainController {
	private ViewController viewController;

	public MainController(){
		AccountController accountController = new AccountController();
		ChallengeController challengeController = new ChallengeController();
		ChatController chatController = new ChatController();
		DiceController diceController = new DiceController();
		GameController gameController = new GameController();
		ObjectiveCardController objectiveCardController = new ObjectiveCardController();
		PatternCardController patternCardController = new PatternCardController();
		PlayerController playerController = new PlayerController();
		ToolcardController toolcardController = new ToolcardController();
		
		viewController = new ViewController(
				accountController, 
				challengeController, 
				chatController, 
				diceController, 
				gameController, 
				objectiveCardController, 
				patternCardController, 
				playerController, 
				toolcardController);
	}
	
	ViewController getViewController(){
		return viewController;
	}

}
