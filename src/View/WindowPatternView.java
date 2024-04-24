package View;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class WindowPatternView extends GridPane{
	
	private static final int maxX = 5;
	private static final int maxY = 4;
	
	//numbers will be the same as the PatternCardFields on the Pattern
	private static final int WINDOWPATTERNVIEWFIELDHEIGHT = 169;
	private static final int WINDOWPATTERNVIEWFIELDWIDTH = 150;
	
	private Parent windowPatternViewArray[][];
	

	
	public WindowPatternView() {


		this.createButtons();
		
		//method addDieToWindow might be moved to controller
		this.addDieToWindow(2, 2, 6, Color.AQUA);
		
		
		//if a die is selected in GameView buttonsVisible = true
		//else = false
		this.buttonsVisible(true);
		
	}
	
	private void createButtons() {
		
		windowPatternViewArray = new Parent[maxX][maxY];

		for(int yCor = 0; yCor < maxY; yCor++) {
			for(int xCor = 0; xCor < maxX; xCor++) {
				if(windowPatternViewArray[xCor][yCor] == null) {
					Button buttonVar = new Button();
					
					buttonVar.setOnAction(e -> this.buttonClicked());
					windowPatternViewArray[xCor][yCor] = buttonVar;
					setButtons(windowPatternViewArray[xCor][yCor], xCor, yCor);
				}
			}
		}
	}
	
	private void removeButtons() {
		for(int yCor = 0; yCor < maxY; yCor++) {
			for(int xCor = 0; xCor < maxX; xCor++) {
				if(windowPatternViewArray[xCor][yCor] != null) {
					this.getChildren().remove(windowPatternViewArray[xCor][yCor]);
				}
			}
		}
	}
	
	private void setButtons(Parent _button, int x, int y) {
		Button button = (Button)_button;		
		button.setPrefSize(WINDOWPATTERNVIEWFIELDWIDTH, WINDOWPATTERNVIEWFIELDHEIGHT);
		button.setBackground(null);
		
		this.add(button,x+1,y+1);
	}
	
	public void buttonsVisible(boolean _boolean) {
		if(_boolean) {
			for(int yCor = 0; yCor < maxY; yCor++) {
				for(int xCor = 0; xCor < maxX; xCor++) {
					if(windowPatternViewArray[xCor][yCor] instanceof Button) {
						Button button = (Button)windowPatternViewArray[xCor][yCor];
						button.setDisable(false);
						button.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK)));
					}
				}
			}
		} else {
			for(int yCor = 0; yCor < maxY; yCor++) {
				for(int xCor = 0; xCor < maxX; xCor++) {
					if(windowPatternViewArray[xCor][yCor] instanceof Button) {
						Button button = (Button)windowPatternViewArray[xCor][yCor];
						button.setDisable(true);
						button.setBorder(null);
					}
				}
			}
		}
	}
	
	public void addDieToWindow(int x, int y, int dieNumber, Color dieColor) {
		this.removeButtons();
		
		PatternCardFieldView pcfv = new PatternCardFieldView(dieColor, dieNumber);
		windowPatternViewArray[x-1][y-1] = pcfv;
		pcfv.setPrefSize(WINDOWPATTERNVIEWFIELDWIDTH, WINDOWPATTERNVIEWFIELDHEIGHT);
		pcfv.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK)));
		
		for(int yCor = 0; yCor < maxY; yCor++) {
			for(int xCor = 0; xCor < maxX; xCor++) {
				this.add(windowPatternViewArray[xCor][yCor], xCor, yCor);

			}
		}
	}
	
	public void buttonClicked() {
		//for controller
	}
	
}
