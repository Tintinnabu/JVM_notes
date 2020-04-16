package OutOfMemoryError;

/**
 * @ClassName JavaVmStackOOM
 * @Description
 * @Author Tinn
 * @Date 2020/4/14 11:23
 */
public class JavaVmStackOOM {
    private void dontStop(){
        while (true){

        }
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }
}
