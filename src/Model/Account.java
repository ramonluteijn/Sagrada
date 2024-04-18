package Model;

import java.awt.Color;

public class Account {
    private String username;
    private String password;
    private int winAmount;
    private int lossAmount;
    private Color mostPlacedColor;
    private int highscore;
    private int mostPlacedNumber;
    private int opponents;


    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getWins() {
        return winAmount;
    }

    public int getLosses() {
        return lossAmount;
    }

    public Color getMostPlacedColor() {
        return mostPlacedColor;
    }

    public int getHighscore() {
        return highscore;
    }

    public int getMostPlacedNumber() {
        return mostPlacedNumber;
    }

    public int getOpponents() {
        return opponents;
    }

    public Account(String username, int winAmount, int lossAmount, Color mostPlacedColor, int highscore, int mostPlacedNumber, int opponents) {
        this.username = username;
        this.winAmount = winAmount;
        this.lossAmount = lossAmount;
        this.mostPlacedColor = mostPlacedColor;
        this.highscore = highscore;
        this.mostPlacedNumber = mostPlacedNumber;
        this.opponents = opponents;
    }
}