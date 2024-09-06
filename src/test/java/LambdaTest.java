public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.test(()->{
            System.out.println("hello");
        });
    }


    private void test(Runnable runnable){
        System.out.println("hello...");
        runnable.run();
    }
}
