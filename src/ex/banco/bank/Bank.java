package ex.banco.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private List<Login> accounts;
    private int lastAccount = 1;

    public void insertAccount(Login account){
        accounts.add(account);
    }

    public List<Login> getAccounts() {
        return accounts;
    }

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }
    public Login generatAccount(String name){
        Login Account = new Login(ag, "" + lastAccount, name);
        lastAccount++;
        return Account;
    }
    public void outputtotal(){
        double total = 0;
        for (Login account : accounts){
            double balance = account.getBalance();
            total += balance;
        }
        System.out.println("O BANCO AGORA POSSUI O VALOR DE R$" + total);
    }
}
