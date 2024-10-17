import java.lang.reflect.Method;

public class Test {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

//        synchronized (lock){
//            System.out.println(123);
//        }

        try {
            Class<?> test = ClassLoader.getSystemClassLoader().loadClass("Test");
            Test o = (Test)test.newInstance();
            o.sout("123");
            for (Method method : test.getDeclaredMethods()) {
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private void sout(String string){
        System.out.println(string);
    }
}
