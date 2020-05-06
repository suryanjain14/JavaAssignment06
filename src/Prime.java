import java.lang.Math;
import java.util.Scanner;

public class Prime  {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no");
        double no=sc.nextDouble();
        System.out.println("Through runnable method");
        Process p=new Process(no);
        Thread.sleep(500);
        System.out.println("Through Thread class");
        Process2 p2 =new Process2(no);
        p2.start();
    }
}
class Process2 extends Thread {
    double no;

    Process2(double no) {
        this.no = no;
    }


    @Override
    public void run() {
        boolean prime = true;
        for (int i = 2; i < (int) Math.sqrt(no); i++) {
            if (no == 1) {
                break;
            }
            if (no % i == 0) {
                System.out.println("Not Prime");
                prime = false;
                break;
            }
        }
        if (prime) {
            System.out.println("Prime");
        }


    }
}

class Process implements Runnable{

    double no;

    Process(double no) {
        this.no = no;
        Thread t=new Thread(this ,"Runnable_thread");
        t.start();
    }


    @Override
    public void run() {
        boolean prime = true;
        for (int i = 2; i < (int) Math.sqrt(no); i++) {
            if(no==1){
                break;
            }
            if (no % i == 0) {
                System.out.println("Not Prime");
                prime=false;
                break;
            }
        }
        if(prime){
            System.out.println("Prime");
        }
    }
    }
