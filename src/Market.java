public class Market {
    public static void main(String[] args) {
        Fruits f=new Fruits();
        Farmer p=new Farmer(f);
        Seller c=new Seller(f);
    }
}
class Fruits{
    int apple, orange, grape, watermelon;
    int capacity=10;
    synchronized public int getApple(){
        while(apple<=0){
            try {
                System.out.println("apples finished waiting for farmer");
                wait();
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(apple==10){

            System.out.println("sold 1 apple from"+apple);
            apple--;
            notify();
        }
        else {

            System.out.println("sold 1 apple from"+apple);
            apple--;

        }

        System.out.println("apples left" +apple);
        return apple;
    }
//    synchronized public int getGrape() {
//        while(grape<=0){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("sold 1 Grape from"+grape);
//        grape--;
//        System.out.println("Grape left" +grape);
//
//        return grape;
//    }
//    synchronized public int getOrange() {
//        while(orange<=0){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("sold 1 Orange from"+orange);
//        orange--;
//        System.out.println("Orange left" +orange);
//
//        return orange;
//    }
//    synchronized public int getWatermelon() {
//        while(watermelon<=0){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("sold 1 apple from"+watermelon);
//        watermelon--;
//        System.out.println("apples left" +watermelon);
//
//        return watermelon;
//    }
    synchronized public void putApple(){
        while(apple==capacity){
            try {
                System.out.println("capacity full");
                wait();
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(apple==0){

            System.out.println("added 1 apple total:"+apple);
            apple++;
            notify();
        }
        else {
            System.out.println("added 1 apple total:"+apple);
            apple++;

        }


    }
//    synchronized public void putGrape(){
//        while (Grape==capacity){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        if(Grape==0){
//            notify();
//        }
//        Grape++;
//    }

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
        for (int i = 1; i < 10; i++) {
            if(i==9){
                System.out.println("production halted\n Good Bye");
                System.exit(1);
            }
            try {
                f.putApple();
                t.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}


class Seller implements Runnable {

    Thread t;
    Fruits f;
    Seller(Fruits f){
        this.f=f;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            try {
                f.getApple();
                t.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
