package presentation.user;

import business.util.InputMethods;
import presentation.run.Main;

public class HomePageView {
    public  static  void showHomePage(){
        System.out.println("HOME PAGE");
        System.out.printf("Chaof mưng ban %s den vơi trang web\n", Main.userLogin.getFullName());
        InputMethods.pressAnyKey();

    }
}
