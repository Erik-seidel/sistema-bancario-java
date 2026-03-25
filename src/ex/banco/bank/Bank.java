package ex.banco.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private List<Account> accounts;
    private int lastAccount = 1;

    public void insertAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }
    public Account generatAccount(String name){
        Account Account = new Account(ag, "" + lastAccount, name);
        lastAccount++;
        return Account;
    }

    public Account findAccountByCc(String cc) {
        for (Account account : accounts) {
            if (account.getCc().equals(cc)) {
                return account;
            }
        }
        return null;
    }
    public Account findAccountbyAc(String ac){
        for (Account account : accounts){
            if (account.getAc().equals(ac)) {
                return account;
            }
        }
        return null;
    }
    public void outputtotal(){
        double total = 0;
        for (Account account : accounts){
            double balance = account.getBalance();
            total += balance;
        }
        System.out.println("O BANCO AGORA POSSUI O VALOR DE R$" + total);
    }
}
