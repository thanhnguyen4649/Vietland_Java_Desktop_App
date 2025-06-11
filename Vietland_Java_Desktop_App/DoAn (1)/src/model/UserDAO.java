/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import database.DatabaseUtils;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author Thanh
 */
public class UserDAO {

    /* List <User> ls = new ArrayList<> (); //danh sách chứa các đối tượng User. Mỗi User chứa thông tin như tên người dùng, mật khẩu.
    
    public UserDAO () { //hàm tạo của lớp UserDAO. Khi một đối tượng UserDAO mới được tạo, hàm tạo này sẽ được gọi. Trong hàm tạo này, nó thêm một số người dùng vào danh sách ls.
        ls.add(new User ("admin", "12345", true));
        ls.add(new User ("BinZ", "123", true));
        ls.add(new User ("Bray", "12345", true));
        ls.add(new User ("YoungH", "12345", true));
        ls.add(new User ("VDK", "12345", true));
    } */
    public User getUserByID(String username) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        User ee = new User();
        try {
            String sSQL = "select * from Users where username = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, username);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ee.setUsername(rs.getString(1));
                ee.setPassword(rs.getString(2));
                ee.setRole(rs.getBoolean(3));
                return ee;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {

            }
        }
        return null;
    }

    /*public boolean checkLogin (String username, String pass) { //hương thức kiểm tra đăng nhập. Nó nhận vào tên người dùng và mật khẩu, sau đó kiểm tra xem có người dùng nào trong danh sách ls có tên người dùng và mật khẩu khớp với các tham số đã cho hay không ?
        for(User u : ls) { //Nếu có, phương thức này trả về true, ngược lại, nó trả về false.
            if(u.getUsername().equals(username)&& u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
}
    
}*/
    public boolean checkLogin(String username, String pass) { //phương thức kiểm tra đăng nhập. Nó nhận vào tên người dùng và mật khẩu, sau đó kiểm tra xem có người dùng nào trong danh sách ls có tên người dùng và mật khẩu khớp với các tham số đã cho hay không ?
        User user = getUserByID(username);
        if (user != null) {
            //user tồn tại
            if (user.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
