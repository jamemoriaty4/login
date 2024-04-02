package presentation.run;

import business.design.IUser;
import business.designImplement.UserImplement;
import business.entity.User;
import business.util.InputMethods;
import business.util.ShopMessage;

public class Main {

    public static IUser userImplement = new UserImplement();
    public static User userLogin = null;

    public static void main(String[] args) {

        while (true) {
            System.out.println("--------------Main---------------");
            System.out.println("1. Xem shop");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Đăng kí");
            System.out.println("4. Thóat");
            System.out.println("Nhap lưa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    userImplement.login();
                    break;
                case 3:
                    System.out.println("========Dang ki tai khoản===========");
                    userImplement.register();
                    break;
                case 4:
                    break;
                default:
                    System.err.println(ShopMessage.ERROR_ALERT);
            }
        }

    }
}
