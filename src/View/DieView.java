package View;


import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class DieView extends PaneWithEyes {

	public DieView(int number, Color color) {
		super(number); // sets the eyes of the die

		setBorder(new Border(new BorderStroke(Color.ALICEBLUE,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));

		setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setOnMouseReleased(e -> setSelected(true));
	}

	public void setSelected(boolean selected) {
		if (selected) {
			setBorder(new Border(new BorderStroke(Color.BLACK,
					BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THICK)));
		} else {
			setBorder(new Border(new BorderStroke(Color.ALICEBLUE,
					BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
		}
	}

	/**
	 * Changes the amount of eyes.
	 */
	public void changeNumber(int number) {
		this.getChildren().clear(); // getting rid of the original eyes
		this.addEyes(number);
	}
}