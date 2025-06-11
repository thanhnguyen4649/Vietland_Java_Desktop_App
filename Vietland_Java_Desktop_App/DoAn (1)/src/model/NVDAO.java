/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuanthanhnguyen
 */

import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.NV;

public class NVDAO {

    List<NV> ls = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /* public NVDAO() {
        try {
            ls.add(new NV("NV000001", "0123456789", "anh Tân", dateFormat.parse("15/03/2024"), true, "Cần bán nhà ở quận 1"));
            ls.add(new NV("NV000002", "0123456788", "Nguyễn Văn A", dateFormat.parse("02/11/2020"), false, "Cần thuê nhà ở quận 7"));
            ls.add(new NV("NV000003", "0123456787", "Trần Thị B", dateFormat.parse("21/09/2023"), true, "Cần bán căn hộ ở quận 3"));
            ls.add(new NV("NV000004", "0123456786", "Lê Văn C", dateFormat.parse("11/06/2023"), true, "Cần thuê văn phòng ở quận 5"));
            ls.add(new NV("NV000005", "0123456785", "Phạm Thị D", dateFormat.parse("16/01/2024"), false, "Cần bán đất nền ở quận 2"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    } */        

    
      public int add(NV nv) {
    Connection conn = null;
    PreparedStatement sttm = null;
    try {
        String sSQL = "INSERT INTO NV (MaNV, TenNV, LuongCB, Thuong, NgayDangKy, PhongBan, BaoCaoNhanVien, MaKH) \n"
                + "VALUES (?,?,?,?,?,?,?,?)";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL);

        sttm.setString(1, nv.getMaNV());
        sttm.setString(2, nv.getTenNV());
        sttm.setLong(3, nv.getLuongCB());
        sttm.setLong(4, nv.getThuong());
        
        // Kiểm tra giá trị null trước khi đặt giá trị
        if (nv.getNgayDangKy() != null) {
            sttm.setString(5, dateFormat.format(nv.getNgayDangKy()));
        } 
        
        sttm.setBoolean(6, nv.isPhongBan());
        sttm.setString(7, nv.getBaoCaoNhanVien());
        sttm.setString(8, nv.getMaKH()); //// Set MaKH cho bảng NV

        if (sttm.executeUpdate() > 0) {
            System.out.println("Thêm thành công");
            return 1;
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.toString());
    } finally {
        try {
            conn.close();
            sttm.close();
        } catch (Exception e) {
            // Xử lý exception khi đóng connection và statement
        }
    }
    return -1; // nếu thêm không thành công
}


    
    
    public List<NV> getAllNV() {
        List<NV> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM NV";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
               NV nv = new NV();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setLuongCB(rs.getLong("LuongCB"));
                nv.setThuong(rs.getLong("Thuong"));
                nv.setNgayDangKy(rs.getDate("NgayDangKy"));
                nv.setPhongBan(rs.getBoolean("PhongBan"));
                nv.setBaoCaoNhanVien(rs.getString("BaoCaoNhanVien"));
                nv.setMaKH(rs.getString("MaKH"));


                list.add(nv);
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

    public NV getOneNVByMaNV(String manv) {
    Connection conn = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;
    NV nv = null; // Khởi tạo đối tượng NV ở ngoài vòng lặp

    try {
        String sSQL = "SELECT MaNV, TenNV, LuongCB, Thuong, NgayDangKy, PhongBan, BaoCaoNhanVien, MaKH FROM NV WHERE MaNV = ?";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL);
        sttm.setString(1, manv);
        rs = sttm.executeQuery();

        // Kiểm tra xem kết quả trả về có trống không
        if (rs.next()) {
            nv = new NV();
            // Gán giá trị từ ResultSet vào đối tượng NV
            nv.setMaNV(rs.getString("MaNV"));
            nv.setTenNV(rs.getString("TenNV"));
            nv.setLuongCB(rs.getLong("LuongCB"));
            nv.setThuong(rs.getLong("Thuong"));
            nv.setNgayDangKy(rs.getDate("NgayDangKy"));
            nv.setPhongBan(rs.getBoolean("PhongBan"));
            nv.setBaoCaoNhanVien(rs.getString("BaoCaoNhanVien"));
            nv.setMaKH(rs.getString("MaKH"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.toString());
    } finally {
        try {
            // Đóng các đối tượng kết nối và tài nguyên
            if (rs != null) rs.close();
            if (sttm != null) sttm.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            System.out.println("Error closing resources: " + e.toString());
        }
    }
    return nv;
}

    
    
    


    public int updateNV(NV nv) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE NV SET TenNV = ?, LuongCB = ?, Thuong = ?, NgayDangKy = ?, PhongBan = ?, BaoCaoNhanVien = ?, MaKH = ? WHERE MaNV = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(8, nv.getMaNV());
            sttm.setString(1, nv.getTenNV());
            sttm.setLong(2, nv.getLuongCB());
            sttm.setLong(3, nv.getThuong());
            sttm.setString(4, dateFormat.format(nv.getNgayDangKy()));
            sttm.setBoolean(5, nv.isPhongBan());
            sttm.setString(6, nv.getBaoCaoNhanVien());
            sttm.setString(7, nv.getMaKH());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Sửa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {

            }
        }
        return -1; // nếu thêm không thành công
    }

    public int delNV(String maNV) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete NV where MaNV = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maNV);

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
            } catch (Exception e) {

            }
        }
        return -1; // nếu xoá không thành công
    }
    
    

    public NV getAtPosition(int pos) {
        return ls.get(pos);
    }
    
    
}

