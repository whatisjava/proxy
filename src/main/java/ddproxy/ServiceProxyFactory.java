package ddproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by whatisjava on 17-9-15.
 */
public class ServiceProxyFactory {

    public static Object getProxy(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1.得到业务实现类的对象
        Class c = Class.forName(className);
        Object realService = c.newInstance();

        //2.获得业务实现类的对象的所有的业务接口
        Class[] interfaces = c.getInterfaces();

        //3.自己定义规则
        MyInvocationHandler h = new MyInvocationHandler(realService);
        System.out.println("djkfjdkslfjkl");
        Object proxy = (Object) Proxy.newProxyInstance(c.getClassLoader(), interfaces, h);
        System.out.println("**" + proxy.toString());

        return proxy;
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object realService;

    public MyInvocationHandler(Object realService) {
        this.realService = realService;
        System.out.println("****");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**********");
        Object o = method.invoke(realService, args);
        System.out.println("***********");
        return o;
    }

}