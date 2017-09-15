package proxy;

/**
 * Created by whatisjava on 17-9-15.
 */
public class Client {

    public static void main(String[] args) {
        AnyServiceImpl anyService = new AnyServiceImpl();
        ProxyService proxyService = new ProxyService(anyService);
        proxyService.doSomething();
    }

}
