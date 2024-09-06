public class ThreadTest {

    static class MyThread extends Thread{

        @Override
        public void run() {
//            super.run();
            System.out.println("hello...");
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MyThread thread = new MyThread();
        thread.start();
    }
}
