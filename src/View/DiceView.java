package View;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class DiceView extends TilePane {

	private ObjectProperty<DieView> selectedDie = new SimpleObjectProperty<>();

	public DiceView() {
		DieView die1 = new DieView(1, Color.RED);
		DieView die2 = new DieView(2, Color.ORANGE);
		DieView die3 = new DieView(3, Color.GREEN);
		DieView die4 = new DieView(4, Color.BLUE);
		DieView die5 = new DieView(5, Color.PURPLE);
		DieView die6 = new DieView(6, Color.YELLOW);

		this.setPrefTileHeight(200);
		this.setPrefTileWidth(200);
		this.getChildren().addAll(die1, die2, die3, die4, die5, die6);

		selectedDie.addListener((obs, oldVal, newVal) -> {
			if (oldVal != null) {
				oldVal.setSelected(false);
			}
			if (newVal != null) {
				newVal.setSelected(true);
			}
		});

		die1.setOnMouseReleased(e -> setSelectedDie(die1));
		die2.setOnMouseReleased(e -> setSelectedDie(die2));
		die3.setOnMouseReleased(e -> setSelectedDie(die3));
		die4.setOnMouseReleased(e -> setSelectedDie(die4));
		die5.setOnMouseReleased(e -> setSelectedDie(die5));
		die6.setOnMouseReleased(e -> setSelectedDie(die6));
		//This can be removed later^
	}

	public void setSelectedDie(DieView die) {
		selectedDie.set(die);
	}

	public DieView getSelectedDie() {
		return selectedDie.get();
	}
}