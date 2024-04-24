package Controller;

import Database.AccountDB;
import Database.DBConn;
import Model.AccountModel;
import java.awt.*;
import java.util.ArrayList;

public class AccountController {

    private final AccountDB accountDB;

    public AccountController() {
        // Create a DBConn instance.
        DBConn dbConn = new DBConn("com.mysql.cj.jdbc.Driver");

        // Pass DBConn to the constructor of AccountDB
        this.accountDB = new AccountDB(dbConn);
    }

    public boolean authenticateUser(String username, String password) {
        AccountModel account = accountDB.getAccount(username, password);
        return account != null;
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

    public AccountModel getStatistics(String username) {
        if(accountDB.checkIfUserExists(username)) {
            int winAmount = accountDB.getWinAmount(username);
            int lossAmount = accountDB.getLossAmount(username);
            int highScore = accountDB.getHighscore(username);
            int mostPlacedNumber = accountDB.getMostPlacedDieNumber(username);
            String mostPlacedColorAsStr = accountDB.getMostPlacedDieColor(username);
            Color mostPlacedColor = mostPlacedColorAsStr != null ? Color.decode(mostPlacedColorAsStr) : null;

            return new AccountModel();
        }
        return null;
    }

    public ArrayList<AccountModel> getResult(String input) {
        ArrayList<AccountModel> results = new ArrayList<>();
        String userName = accountDB.getAccountsBySearch(input);

        if(userName != null && !userName.isEmpty()){
            AccountModel account = getStatistics(userName);
            if(account != null){
                results.add(account);
            }
        }

        return results;
    }
}