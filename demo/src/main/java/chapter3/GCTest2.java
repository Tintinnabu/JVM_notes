package chapter3;

/**
 * @ClassName GCTest2
 * @Description
 * @Author Tinn
 * @Date 2020/4/14 16:54
 */
public class GCTest2 {
    private static final int _1MB = 1024 * 1024;

    /**

     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:PretenureSizeThreshold=3145728(3MB)
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        GCTest2.testPretenureSizeThreshold();
    }
}
