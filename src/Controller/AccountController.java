package Controller;

import Database.AccountDB;
import Model.Account;
import java.awt.*;
import java.util.ArrayList;

public class AccountController {

    private AccountDB accountDB;

    public boolean authenticateUser(String username, String password) {
        String account = accountDB.getAccount(username, password);
        return account.equals("bestaat");
    }
    public boolean checkIfAccountExists(String username) {
        return accountDB.checkIfUserExists(username);
    }

    public boolean registerUser(String username, String password) {
        if(!checkIfAccountExists(username)) {
            accountDB.insertAccount(username, password);
            return true;
        } else {
            return false;
        }
    }

    public Account getStatistics(String username) {
        if(accountDB.checkIfUserExists(username)) {
            int winAmount = accountDB.getWinAmount(username);
            int lossAmount = accountDB.getLossAmount(username);
            int highScore = accountDB.getHighscore(username);
            int mostPlacedNumber = accountDB.getMostPlacedDieNumber(username);
            String mostPlacedColorAsStr = accountDB.getMostPlacedDieColor(username);
            Color mostPlacedColor = mostPlacedColorAsStr != null ? Color.decode(mostPlacedColorAsStr) : null;

            return new Account(username, winAmount, lossAmount, mostPlacedColor, highScore, mostPlacedNumber, 0 );
        }
        return null;
    }

    public ArrayList<Account> getResult(String input) {
        ArrayList<Account> results = new ArrayList<>();
        String userName = accountDB.getAccountsBySearch(input);


        if(userName != null && !userName.isEmpty()){
            Account account = getStatistics(userName);
            if(account != null){
                results.add(account);
            }
        }

        return results;
    }
}


