package View;

import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class WindowPatternView extends FlowPane{
	
	private final int maxX = 5;
	private final int maxY = 4;
	
	private Button buttons[][];
//	private DieView dieOnWindow[][];
	
	public WindowPatternView() {
		//flowpane tijdelijk
		this.createButtons();
		
	}
	
	private void createButtons() {
		
		buttons = new Button[maxX][maxY];

		for(int yCor = 0; yCor < maxY; yCor++) {
			for(int xCor = 0; xCor < maxX; xCor++) {
				if(buttons[xCor][yCor] == null) {
					buttons[xCor][yCor] = new Button();
					setButtons(buttons[xCor][yCor]);
//					System.out.println(buttons[xCor][yCor] + String.valueOf(xCor) + String.valueOf(yCor));
				}
			}
		}
	}
	
	private void setButtons(Button button) {
		//nummers tijdelijk
		button.setPrefSize(50, 50);
//		button.setBackground(null);
		button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.getChildren().add(button);
	}
	
	public void buttonsOnOff() {
		for(int yCor = 0; yCor < maxY; yCor++) {
			for(int xCor = 0; xCor < maxX; xCor++) {
				if(buttons[xCor][yCor].isDisable() == false) {
					buttons[xCor][yCor].setDisable(true);
					buttons[xCor][yCor].setVisible(false);
				} else {
					buttons[xCor][yCor].setDisable(false);
					buttons[xCor][yCor].setVisible(true);
				}
			}
		}
	}
	
	
	
	
}
