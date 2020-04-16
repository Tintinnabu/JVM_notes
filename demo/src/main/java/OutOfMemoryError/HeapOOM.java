package OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Description -verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Author Tinn
 * @Date 2020/4/14 11:04
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
