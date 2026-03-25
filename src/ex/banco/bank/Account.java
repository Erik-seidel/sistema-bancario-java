package ex.banco.bank;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final int MAX_LENGTH = 12;
    private String agen;
    private String cc;
    private String ac;
    private double balance;
    private Log logger;
    private List<String> his = new ArrayList<>();


    public Account(String agen, String cc, String ac) {
        this.agen = agen;
        this.cc = cc;
        setname(ac);
        logger = new Log();
    }

    public void setname(String ac) {
        if (ac.length() > MAX_LENGTH) {
            this.ac = ac.substring(0, MAX_LENGTH);
        } else {
            this.ac = ac;
        }
    }

    public void deposit(double value){
         balance += value;
         logger.out("DEPOSITO DE R$" +value+ " - Valor depositado, sua conta agora é R$" + balance);
         his.add("DEPOSITO DE R$" +value+ " - Valor depositado, sua conta agora é R$" + balance);
    }

    public boolean withDraw(double value) {
        if (balance < value) {
            logger.out("SAQUE - Seu saldo é de R$" + balance);
            return false;
        } else {
            balance -= value;
            logger.out("Saque de " +value+ " efetuado, sua conta agora é R$" + balance);
            his.add("Saque de " +value+ " efetuado, sua conta agora é R$" + balance);
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getCc() {
        return cc;
    }

    public String getAc() {
        return ac;
    }

    @Override
    public String toString() {
        return "A conta de " + this.ac + " " + this.agen + "/" + this.cc + " " + "Possui um total de R$" + this.balance;
    }
    public void gethis(){
        for (String item : his){
            System.out.println(item);
        }
    }
}
