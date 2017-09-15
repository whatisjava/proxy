package ddproxy;

import dproxy.AdminService;
import dproxy.UserService;

/**
 * Created by whatisjava on 17-9-15.
 */
public class Client {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        UserService userService = (UserService) ServiceProxyFactory.getProxy("dproxy.UserServiceImpl");
        System.out.println("---------------");
        userService.delUser();
        System.out.println("------------------------");
        AdminService as = (AdminService) ServiceProxyFactory.getProxy("dproxy.AdminServiceImpl");
        System.out.println("---------------");
        as.addAdmin();
    }

}
