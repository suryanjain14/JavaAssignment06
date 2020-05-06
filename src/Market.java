public class Market {
    public static void main(String[] args) {
        Fruits f=new Fruits();
        Farmer p=new Farmer(f);
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("sold 1 apple from"+apple);
        apple--;
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(apple==0){
            notify();
        }
        System.out.println("added 1 apple total:"+apple);
        apple++;
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

class Seller implements Runnable {

    @Override
    public void run() {

    }
}
