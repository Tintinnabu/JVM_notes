package chapter8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxy
 * @Description
 * @Author Tinn
 * @Date 2020/4/16 14:56
 */
interface IHello {
    void sayHello();
}

class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}

class DynamicProxy implements InvocationHandler {

    Object originalObj;

    Object bind(Object originalObj) {
        this.originalObj = originalObj;
        return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("welcome");
        return method.invoke(originalObj, args);
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        hello.toString();
    }
}
