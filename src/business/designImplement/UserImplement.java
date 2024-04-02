package business.designImplement;

import business.design.IDesign;
import business.design.IUser;
import business.entity.Status;
import business.entity.User;
import business.util.*;
import org.mindrot.jbcrypt.BCrypt;
import presentation.admin.DashBoardView;
import presentation.run.Main;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserImplement implements IUser {
    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayAll() {

    }

    @Override
    public User inputData() {
        User user = new User();
        user.setUserId(getNewId());
        System.out.println("UserId : " + user.getUserId());
        System.out.println("nhập userName: ");
        while (true) {
            String userName = InputMethods.getString();
            if (ShopValidate.checkUserNameIsValid(userName)) {
//                kiem tra loi ton tai
                if (!existByUsername(userName)) {
                    user.setUsername(userName);
                    break;
                }
                System.err.println(ShopMessage.ERROR_USERNAME_EXIST);
            } else {
                System.err.println(ShopMessage.ERROR_USERNAME_INVALID);
            }
        }

        System.out.println("nhap mat khau");
        String pass = InputMethods.getString();
        user.setPassword(BCrypt.hashpw(pass,BCrypt.gensalt(5))); // mã hóa pass
        System.out.println("nhap vao vai tro cua nguoi dung");
        user.setRole(InputMethods.getBoolean());
        System.out.println("nhap vào tên day du");
        user.setFullName(InputMethods.getString());
        System.out.println("nhap vao trang thai nguoi dung");
        user.setStatus(Status.ACTIVE);
//        switch (user.getStatus()){
//            case ACTIVE :
//                break;
//            case BLOCK:
//                break;
//        }
        System.out.println("nhap vao dia chi");
        user.setAddress(InputMethods.getString());
        System.out.println("nhao vao sdt");
        user.setPhone(InputMethods.getString());
        System.out.println("nhap vào email");
        user.setEmail(InputMethods.getString());
        System.out.println("nhap vao thoi gian duoc tao");
        user.setCreatedAt(new Date());
        System.out.println("nhap vao thoi gian cap nhat");
        user.setUpdatedAt(new Date());

        return user;
    }

    @Override
    public void displayData() {

    }

    @Override
    public int getNewId() {
        List<User> userList = IOFile.readFromFile(ShopConstants.USER_PATH);
        int idMax = 0;
        for (User k : userList) {
            if (k.getUserId() > idMax) {
                idMax = k.getUserId();
            }
        }
        return idMax + 1;
    }

    @Override
    public void login() {
        System.out.println("nhập userName: ");
        String username = InputMethods.getString();
        System.out.println("nhập password: " );
        String password = InputMethods.getString();
        List<User> userList = IOFile.readFromFile(ShopConstants.USER_PATH);
        User userLogin = userList.stream().filter(u-> Objects.equals(u.getUsername(), username) &&BCrypt.checkpw(password,u.getPassword())).findFirst().orElse(null);

        if(userLogin==null){
            System.err.println(ShopMessage.ERROR_ACCOUNT_NOTFOUND);
            System.out.println("Bạn có muốn nhập lại không ? (Y,N)");
            if(InputMethods.getChar()=='Y'){
                login();
            }

        }else{
            if(!userLogin.isRole()){
                Main.userLogin = userLogin;


            }else{
                Main.userLogin= userLogin;
                DashBoardView.showDashBoardView();
            }
        }

    }

    @Override
    public void register() {
        User user = inputData();
        List<User> userList = IOFile.readFromFile(ShopConstants.USER_PATH);
        userList.add(user);
        IOFile.writeToFile(ShopConstants.USER_PATH, userList);
        System.out.println("dang ky thanh cong !!!!");
        login();

    }

    @Override
    public boolean existByUsername(String username) {
        List<User> userList = IOFile.readFromFile(ShopConstants.USER_PATH);

        return userList.stream().anyMatch(t -> Objects.equals(t.getUsername(), username));
    }
}
