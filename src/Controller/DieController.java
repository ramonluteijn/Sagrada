package Controller;


import View.DieView;

public class DieController {

    private DieView dieView;

    //private  gameDieModel die;
        /*
        public DieController(gameDieModel die, DieView view){
        this.die = die;
        dieView = view;
        }
        */
    public void rollDice(int roundID) {
        //die.eyes = (int) (Math.random() * 6) + 1;
        //die.roundID = roundID;

        //UpdateDB(Die)
        // dieView.changeNumber(die.eyes);
    }

    public void addToRoundTrack(int round) {
        ///Update to DB
        //die.roundtrack = round;
        //UpdateDB();

        //Update RoundTrackView
        //addDiceToRound(round, die.color, die.number);
    }

    public void swapDiceSide() {
        //die.eyes = 7 - die.number
        //UpdateDB(die);
        //dieView.changeNumber(die.eyes);
    }

    private void UpdateDB() {
        //gameDie
    }
}
