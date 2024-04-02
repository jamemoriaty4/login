package business.design;

import business.entity.User;

public interface IUser extends IDesign<User>{
//    dang nhap
    void login();
//    dang ky
    void register();
//    thoat
    boolean existByUsername(String username);
}
