package OutOfMemoryError;

/**
 * @ClassName JavaVmStackSOF
 * @Description -verbose:gc -Xss128k -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author Tinn
 * @Date 2020/4/14 11:17
 */
public class JavaVmStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println(oom.stackLength);
            throw e;
        }
    }
}
