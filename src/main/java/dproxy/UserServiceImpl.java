package dproxy;

/**
 * Created by whatisjava on 17-9-15.
 * 真正的业务实现类（被代理类）
 */
public class UserServiceImpl implements UserService {

    public void addUser() {
        System.out.println("add user action...");
    }

    public void delUser() {
        System.out.println("delete user action...");
    }

}
