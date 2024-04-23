package Controller;

public class MainController {
	
	public final AccountController accountController = new AccountController();
	public final ChallengeController challengeController = new ChallengeController();
	public final ChatController chatController = new ChatController();
	public final DiceController diceController = new DiceController();
	public final GameController gameController = new GameController();
	public final ObjectiveCardController objectiveCardController = new ObjectiveCardController();
	
	public final PlayerController playerController = new PlayerController();
	public final ToolcardController toolcardController = new ToolcardController();
	public static final ColorBlindController colorblindController = new ColorBlindController();
	
	public static PatternCardController getPatternCardController(){
		return new PatternCardController(colorblindController);
		// make sure all patterncardControllers are unique. so that 1 player doesn't get the same card twice
	}
	
	
	
}
