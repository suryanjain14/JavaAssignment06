public class Timer {
    public static void main(String[] args) {
        System.out.println("Welcome to 1000 sec timer");
        ClockWork c=new ClockWork("TimerThread");
    }
}

class ClockWork implements Runnable {
    Thread t;

    ClockWork(String name) {
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            System.out.println("Time left :" + (1000 - i)+" sec");
            try {
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}