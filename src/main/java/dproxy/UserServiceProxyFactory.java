package dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by whatisjava on 17-9-15.
 * 生成动态代理类的工厂
 */
public class UserServiceProxyFactory {

    public static UserService getProxy(){
        //1.还要有真正的业务实现类的对象
        UserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);

        //参数意义arg0－》被代理类的类加载器
        //arg1－》实现的所有的业务接口的Class对象
        //arg2－》要传一个InvocationHandler的实例
        //     －》它是定义了生成的动态代理类的一个执行规范
        //     －》也就是我用反射的api为某个被代理类生成的动态代理类的真正执行代码。
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                new Class[]{UserService.class},
                handler
        );
        return proxyService;
    }

}

class MyInvocationHandler implements InvocationHandler {

    private UserService userService;

    public MyInvocationHandler(UserService userService){
        this.userService = userService;
    }

    private void doBefore(){
        System.out.println("do before" + System.currentTimeMillis());
    }

    //arg0-->经过反射动态生成的动态代理类的对象
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        //核心的业务方法
        Object object = method.invoke(userService, args);
        doAfter();
        return object;
    }

    private void doAfter(){
        System.out.println("do after" + System.currentTimeMillis());
    }

}
