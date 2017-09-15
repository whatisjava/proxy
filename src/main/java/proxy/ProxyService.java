package proxy;

/**
 * Created by whatisjava on 17-9-15.
 * //代理类
 */
public class ProxyService implements AnyService {

    //拥有一个真正的业务实现类
    private AnyServiceImpl anyService;

    public ProxyService(AnyServiceImpl anyService) {
        this.anyService = anyService;
    }

    private void doBefore(){
        System.out.println("give me 1000.");
    }

    public void doSomething() {
        doBefore();
        anyService.doSomething();
        doAfter();
    }

    private void doAfter(){
        System.out.println("give me 2000.");
    }

}
