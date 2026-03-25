package ex.banco.bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Bank bank = new Bank("0001");

        while (true) {
            System.out.println("O que deseja fazer? C=criar conta A=acessar conta E=sair");
            String a = scanner.nextLine();
            if (a.equalsIgnoreCase("C")) {
                System.out.println("Digite seu nome");
                String name = scanner.nextLine();
                Account Account = bank.generatAccount(name);
                bank.insertAccount(Account);
                System.out.println(Account);
                operateAccount(Account);
            } else if (a.equalsIgnoreCase("A")) {
                System.out.println("Digite o nome ou numero da conta (CC)");
                String input = scanner.nextLine();
                Account account = bank.findAccountByCc(input);
                if (account == null) {
                    account = bank.findAccountbyAc(input);
                }
                if (account == null) {
                    System.out.println("Conta nao encontrada.");
                } else {
                    System.out.println(account);
                    operateAccount(account);
                }
            } else if (a.equalsIgnoreCase("E")) {
                System.out.println("Caso queira sair digete E novamente");
                String b = scanner.nextLine();
                if (b.equalsIgnoreCase("E")) {
                    break;
                } else {
                    System.out.println("Comando invalido, tente novamente");
                }
            }else {
                System.out.println("Comando invalido, tente novamente");}
        }
        List<Account> accountList = bank.getAccounts();
        for (Account cc: accountList){
            System.out.println(cc);
        }
        bank.outputtotal();
    }

    static void operateAccount(Account Account) {
        while (true) {
            System.out.println("Qual operação deseja fazer? D=DEPOSITO, S=SAQUE, H=HISTORICO DA CONTA, E=SAIR DA CONTA");
            String op = scanner.nextLine();
            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                scanner.nextLine(); // consome o \n pendente
                Account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                scanner.nextLine(); // consome o \n pendente
                Account.withDraw(value);
            } else if(op.equals("H")){
                Account.gethis();
            } else if (op.equals("E")) {
                System.out.println("Para sair de sua conta digite E novamente");
                String out = scanner.nextLine();
                if (out.equals("E")) {
                    break;
                }
            } else {
                System.out.println("Comando invalido, tente novamente");
            }
        }
    }
}

