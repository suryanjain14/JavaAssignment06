import java.util.Scanner;

class Account{
    double balance;
    String name;
    Account(){
        balance=100;
    }

    synchronized void withdraw(double amount){
        if((balance-amount)<0){
            System.out.println("Insufficient Balance");
        }
        else{
            balance=balance-amount;
            System.out.println("transaction successful");
            System.out.println(balance+" left");
        }

    }

    synchronized void deposite(double amount){
        balance=balance+amount;
        System.out.println("transaction successful");
        System.out.println( "Available balance"+amount );
    }

}

class Deposite implements Runnable{
    Account ac;
    Thread t;
    private double amount;
    Deposite(Account ac,double amount){
        this.ac=ac;
        t=new Thread();
        t.start();
        amount=amount;
    }

    @Override
    public void run() {
        ac.deposite(amount);
    }
}
class Withdraw implements Runnable{
    Account ac;
    Thread t;
    private double amount;
    Withdraw(Account ac,double amount){
        this.ac=ac;
        this.t= new Thread();
        this.t.start();
        this.amount=amount;
    }

    @Override
    public void run() {
        ac.withdraw(amount);
    }
}

public class MyBank {

    public static void main(String[] args) {
        Account ac[]= new Account[5];
        int accindex=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank Here you can open upto 5 acc");
        System.out.println("under our new Customer Scheme you will get 100$ on every new account");
        while (true){

            System.out.println("press 1 for new acc ,2 if you already have an account,3 to exit");
            int i = sc.nextInt();
            switch (i){
                case 1:{
                    if(accindex<4){
                        ac[accindex]=new Account();
                        System.out.println("Your Acc no is "+accindex+"Remember it");
                    }
                    else{
                        System.out.println("Sorry you cannot open a  account");
                    }


                }
            }


        }


    }
}


