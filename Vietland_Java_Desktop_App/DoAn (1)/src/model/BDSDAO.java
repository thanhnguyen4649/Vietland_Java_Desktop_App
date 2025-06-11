/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import database.DatabaseUtils;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 *
 * @author Thanh
 */

//Lớp này đại diện cho một Data Access Object (DAO) cho BDS. DAO là mẫu thiết kế được sử dụng để tách rời các thao tác truy cập dữ liệu cụ thể từ phần còn lại của mã nguồn.
//các lớp DAO (Data Access Object). Cung cấp các phương thức để thao tác với dữ liệu liên quan đến các đối tượng mà chúng đại diện. Ví dụ, BDSDAO có các phương thức để thêm, xóa, cập nhật, và lấy các đối tượng BDS.
public class BDSDAO {

    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd");
    //anh sách tĩnh chứa các đối tượng BDS. Mỗi BDS có thể chứa thông tin như mã BDS, số điện thoại, ngày đăng ký, loại BDS, địa chỉ, hình ảnh,
    public static List<BDS> ls = new ArrayList<>();

   //Phương thức này thêm một đối tượng BDS vào danh sách ls và trả về 1 để biểu thị thao tác thành công.
//    public int add(BDS bds) {
//        ls.add(bds);
//        return 1;
//    }
    

    public int add(BDS bds) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into BDS(MaBDS, SDT, NgayDangKy, LoaiBDS, DiaChi, HinhAnh) values (?,?,?,?,?,?) ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(1, bds.getMaBDS());
            sttm.setString(2, bds.getSDT());
            sttm.setString(3, format_date.format(bds.getNgayDangKy()));//ngay sinh
            sttm.setBoolean(4, bds.isLoaiBDS());
            sttm.setString(5, bds.getDiaChi());
            sttm.setString(6, bds.getHinhAnh());
            
           
            if (sttm.executeUpdate() > 0) {
                System.out.println("add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {              
                    conn.close();                             
                    sttm.close();
                }
             catch (Exception e) {
              
            }
        }
        return -1; // nếu thêm không thành công
    }




    //Phương thức này trả về toàn bộ danh sách ls, chứa tất cả các đối tượng BDS.
//    public List<BDS> getAllBDS() {
//        return ls;
//    }
    
    public List<BDS> getAllBDS() {
    List<BDS> list = new ArrayList<>();
    Connection conn = null;
    Statement sttm = null;
    ResultSet rs = null;
    try {
        String sSQL = "select * from BDS";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.createStatement();
        rs = sttm.executeQuery(sSQL);
        while (rs.next()) {
            BDS bds = new BDS();
           bds.setMaBDS(rs.getString(1));
           bds.setSDT(rs.getString(2));
           bds.setNgayDangKy(rs.getDate(3));
           bds.setLoaiBDS(rs.getBoolean(4));
           bds.setDiaChi(rs.getString(5));
           bds.setHinhAnh(rs.getString(6));
            list.add(bds);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.toString());
    } finally {
        try {
                rs.close();
                sttm.close();
                conn.close();

        } catch (Exception e) {

        }
    }
    return list;
}


    //Phương thức này xóa một đối tượng BDS khỏi danh sách ls dựa trên mã BDS. Nếu xóa thành công, nó trả về 1, nếu không tìm thấy mã BDS trong danh sách, nó trả về -1.
//    public int delBDSbyID(String ma) {
//        for (BDS bds : ls) {
//            if (bds.getMaBDS().equalsIgnoreCase(ma)) { //.equalsIgnoreCase(String anotherString) trong Java được sử dụng để so sánh hai chuỗi, bỏ qua việc phân biệt chữ hoa và chữ thường. Nó trả về true nếu và chỉ nếu độ dài của hai chuỗi bằng nhau, và các ký tự tương ứng trong hai chuỗi bằng nhau, bỏ qua việc phân biệt chữ hoa và chữ thường.
//                ls.remove(bds);
//                return 1;
//            }
//        }
//        return -1;
//    }
//
//    //Phương thức này tìm kiếm và trả về một đối tượng BDS từ danh sách ls dựa trên mã BDS. Nếu không tìm thấy, nó trả về null.
//    public BDS getBDSByID(String id) {
//        for (BDS bds : ls) {
//            if ((bds.getMaBDS().equalsIgnoreCase(id))) {
//                return bds;
//            }
//        }
//        return null;
//    }
    
     public int delBDSbyID (String mabds) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete BDS where MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);           
            sttm.setString(1, mabds); 
            if (sttm.executeUpdate() > 0) {
                System.out.println("xoá thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {              
                    conn.close();                             
                    sttm.close();
                }
             catch (Exception e) {
              
            }
        }
        return -1; // nếu thêm không thành công
    }

    
    
    //Phương thức này cập nhật thông tin của một đối tượng BDS trong danh sách ls dựa trên mã BDS. Nếu cập nhật thành công, nó trả về 1, nếu không tìm thấy mã BDS trong danh sách, nó trả về -1.
//    public int updateBDSByID(BDS bdsNew){
//    for (int i = 0; i < ls.size(); i++) {
//        if(ls.get(i).getMaBDS().equalsIgnoreCase(bdsNew.getMaBDS())) { //Trong mỗi lần lặp, kiểm tra xem mã BDS (getMaBDS()) của đối tượng BDS tại vị trí i trong danh sách ls có giống với mã BDS của đối tượng bdsNew hay không. 
//            ls.set(i, bdsNew); //Nếu mã BDS của đối tượng BDS tại vị trí i trong danh sách ls giống với mã BDS của bdsNew, thì đối tượng BDS tại vị trí i trong danh sách ls sẽ được thay thế bằng bdsNew.
//            return 1;
//        }
//    }
//    return -1;
//}
    
    public int updateBDSByID(BDS bds) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update BDS set SDT = ?, NgayDangKy = ?, LoaiBDS = ?, DiaChi = ?, HinhAnh = ? where MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(6, bds.getMaBDS());
            sttm.setString(1, bds.getSDT());
            sttm.setString(2, format_date.format(bds.getNgayDangKy()));//ngay sinh
            sttm.setBoolean(3, bds.isLoaiBDS());
            sttm.setString(4, bds.getDiaChi());
            sttm.setString(5, bds.getHinhAnh());
            
           
            if (sttm.executeUpdate() > 0) {
                System.out.println("add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {              
                    conn.close();                             
                    sttm.close();
                }
             catch (Exception e) {
              
            }
        }
        return -1; // nếu thêm không thành công
    }

  
    
    public BDS getBDSByID(String mabds) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        BDS bds = new BDS();
        try {
            String sSQL = "select * from BDS where MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, mabds);
            rs = sttm.executeQuery();
            while (rs.next()) {
                bds.setMaBDS(rs.getString(1));
                bds.setSDT(rs.getString(2));
                bds.setNgayDangKy(rs.getDate(3));
                bds.setLoaiBDS(rs.getBoolean(4));
                bds.setDiaChi(rs.getString(5));
                bds.setHinhAnh(rs.getString(6));
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
        return bds;
    }

    
    public BDS getAtPosition(int pos) {
        return ls.get(pos);
    }

}
