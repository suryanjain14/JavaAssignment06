import org.w3c.dom.ls.LSOutput;
import java.util.Scanner;
import java.util.SortedMap;

class Account {
    double balance;

    Account() {
        balance = 100;
    }

    synchronized double withdraw(double amount) {
        if ((balance - amount) < 0) {
            System.out.println("Insufficient Balance");
            return 0;
        } else {
            balance = balance - amount;
            System.out.println("transaction successful");
            System.out.println(balance + "  left");
            return balance;
        }

    }

    synchronized double deposite(double amount) {
        balance = balance + amount;
        System.out.println("transaction successful");
        System.out.println("Available balance  " + balance);
        return balance;

    }

}

class Deposite implements Runnable {
    Account ac;
    Thread t;
    double amount;

    Deposite(Account ac, double amount) {
        this.ac = ac;
        t = new Thread(this);
        this.amount = amount;
        t.start();
    }

    @Override
    public void run() {
        ac.deposite(amount);
    }
}

class Withdraw implements Runnable {
    Account ac;
    Thread t;
    Account a = new Account();
    double amount;

    Withdraw(Account ac, double amount) {
        this.ac = ac;
        this.amount = amount;
        this.t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        ac.withdraw(amount);
    }
}

public class MyBank {

    public static void main(String[] args) {
        Account ac[] = new Account[5];


        int accindex = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank Here you can open upto 5 acc");
        System.out.println("under our new Customer Scheme you will get 100$ on every new account");
        int cc = 0;
        while (true) {

            System.out.println("press 1 for new acc ,2 if you already have an account,3 to exit");
            int i = sc.nextInt();
            switch (i) {
                case 1: {
                    if (accindex < 4) {
                        ac[accindex] = new Account();
                        System.out.println("Your Acc no is \"" + accindex + "\" Remember it");
                        accindex++;
                        System.out.println("processing Automatic login request");
                        cc = 1;
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Sorry you cannot open a  account");
                    }

                }
                case 2: {
                    int acc;
                    if (cc == 0) {
                        System.out.println("Enter Your Account");
                        acc = sc.nextInt();

                    } else {
                        acc = accindex - 1;
                        cc = 0;
                    }

                    if (acc >= accindex) {
                        System.out.println("wrong entry");
                        break;
                    }
                    boolean loggedin = true;
                    while (loggedin) {
                        System.out.println("welcome \"" + acc + "\"");
                        System.out.println("press 1 to deposit ,2 to withdraw,3 to logout");
                        int j = sc.nextInt();
                        double amount;
                        switch (j) {

                            case 1: {
                                System.out.println("Enter amount");
                                amount = sc.nextDouble();
                                new Deposite(ac[acc], amount);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;

                            }
                            case 2: {
                                System.out.println("Enter amount to withdraw");
                                amount = sc.nextDouble();
                                new Withdraw(ac[acc], amount);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 3: {
                                loggedin = false;
                                break;
                            }

                        }


                    }
                    break;
                }

                case 3: {
                    System.out.println("Bye Bye");
                    System.exit(1);
                }

            }


        }


    }
}


