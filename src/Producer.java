public class Producer {
    public static void main(String[] args) {

    }
}

class Farmer implements Runnable {
    Thread t;
    Fruits f;
    Farmer(Fruits f){
        this.f=f;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            try {
                f.putApple();
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
