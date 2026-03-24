package ex.banco.bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank santander = new Bank("0001");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("O que deseja fazer? D= acessar conta E= Sair");
            String a = scanner.nextLine();
            if (a.equals("D")) {
                System.out.println(santander.getAccounts());
                System.out.println("Digite seu nome");
                String name = scanner.nextLine();
                Login Account = santander.generatAccount(name);
                santander.insertAccount(Account);
                System.out.println(Account);
                operateAccount(Account);
            } else if (a.equals("E")) {
                System.out.println("Caso queira sair digete E novamente");
                String b = scanner.nextLine();
                if (b.equals("E")) {
                    break;
                } else {
                    System.out.println("Comando invalido, tente novamente");
                }
            }
        }
        List<Login> accountList = santander.getAccounts();
        for (Login cc: accountList){
            System.out.println(cc);
        }
        santander.outputtotal();
    }

    static void operateAccount(Login Account) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Qual operação deseja fazer? D=DEPOSITO, S=SAQUE, E=SAIR DA CONTA");
            String op = scanner.nextLine();
            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                Account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                Account.withDraw(value);
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
        scanner = new Scanner(System.in);
    }
}

