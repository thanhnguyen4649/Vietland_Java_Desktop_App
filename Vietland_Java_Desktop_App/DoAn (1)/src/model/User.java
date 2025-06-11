/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thanh
 */

//định nghĩa một đối tượng User với ba thuộc tính: username, password và role.
public class User {
    //khai báo là private, nghĩa là chúng chỉ có thể được truy cập trực tiếp từ bên trong lớp User.
    private String username;
    private String password;
    private boolean role;

    //àm tạo không tham số. Cho phép tạo một đối tượng User mà không cần cung cấp bất kỳ thông tin nào.
    public User() {
    }

    //hàm tạo có tham số. Cho phép tạo một đối tượng User với tên người dùng, mật khẩu và vai trò cụ thể.
    public User(String username, String password, boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //các phương thức getter và setter. Cho phép truy cập (get) và thay đổi (set) giá trị của các thuộc tính private.
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
    
    
    
}
