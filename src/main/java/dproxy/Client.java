package dproxy;

/**
 * Created by whatisjava on 17-9-15.
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = UserServiceProxyFactory.getProxy();
        System.out.println(userService.getClass().getName());
        userService.addUser();
        userService.delUser();
    }
}
