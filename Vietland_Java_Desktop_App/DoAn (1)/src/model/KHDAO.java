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
import model.KH;

public class KHDAO {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    List<KH> ls = new ArrayList<>();

    /* public KHDAO() {
        try {
            ls.add(new KH("K000001", "0123456789", "anh Tân", dateFormat.parse("15/03/2024"), true, "Cần bán nhà ở quận 1"));
            ls.add(new KH("K000002", "0123456788", "Nguyễn Văn A", dateFormat.parse("02/11/2020"), false, "Cần thuê nhà ở quận 7"));
            ls.add(new KH("K000003", "0123456787", "Trần Thị B", dateFormat.parse("21/09/2023"), true, "Cần bán căn hộ ở quận 3"));
            ls.add(new KH("K000004", "0123456786", "Lê Văn C", dateFormat.parse("11/06/2023"), true, "Cần thuê văn phòng ở quận 5"));
            ls.add(new KH("K000005", "0123456785", "Phạm Thị D", dateFormat.parse("16/01/2024"), false, "Cần bán đất nền ở quận 2"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    } */
    public int add(KH kh) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO KH (MaKH, SDT, TenKH, NgayDangKy, NhuCau, YeuCauKhachHang, MaNV) \n"
                    + "VALUES (?,?,?,?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, kh.getMaKH());
            sttm.setString(2, kh.getSdt());
            sttm.setString(3, kh.getTenKH());
            sttm.setString(4, dateFormat.format(kh.getNgayDangKy()));
            sttm.setBoolean(5, kh.isNhucau());
            sttm.setString(6, kh.getYeuCauKhachHang());
            sttm.setString(7, kh.getMaNV());

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
            } catch (Exception e) {

            }
        }
        return -1; // nếu thêm không thành công
    }

    public List<KH> getAllKH() {
        List<KH> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM KH";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                KH kh = new KH();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setSdt(rs.getString("SDT"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setNgayDangKy(rs.getDate("NgayDangKy"));
                kh.setNhucau(rs.getBoolean("NhuCau"));
                kh.setYeuCauKhachHang(rs.getString("YeuCauKhachHang"));
                kh.setMaNV(rs.getString("MaNV"));

                list.add(kh);
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

  public KH getOneKHByMaKH(String makh) {
    Connection conn = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;
    KH kh = null; // Khởi tạo đối tượng KH ở ngoài vòng lặp

    try {
        String sSQL = "SELECT MaKH, SDT, TenKH, NgayDangKy, NhuCau, YeuCauKhachHang FROM KH WHERE MaKH = ?";
        conn = DatabaseUtils.getDBConnect();
        sttm = conn.prepareStatement(sSQL);
        sttm.setString(1, makh);
        rs = sttm.executeQuery();

        // Kiểm tra xem kết quả trả về có trống không
        if (rs.next()) {
            kh = new KH();
            // Gán giá trị từ ResultSet vào đối tượng KH
            kh.setMaKH(rs.getString("MaKH"));
            kh.setSdt(rs.getString("SDT"));
            kh.setTenKH(rs.getString("TenKH"));
            kh.setNgayDangKy(rs.getDate("NgayDangKy"));
            kh.setNhucau(rs.getBoolean("NhuCau"));
            kh.setYeuCauKhachHang(rs.getString("YeuCauKhachHang"));
            kh.setMaNV(rs.getString("MaNV"));
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
    return kh;
}


    public int updateKH(KH kh) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE KH SET  SDT = ?, TenKH = ?, NgayDangKy = ?, NhuCau = ?, YeuCauKhachHang = ? WHERE MaKH = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(6, kh.getMaKH());
            sttm.setString(1, kh.getSdt());
            sttm.setString(2, kh.getTenKH());
            sttm.setString(3, dateFormat.format(kh.getNgayDangKy()));
            sttm.setBoolean(4, kh.isNhucau());
            sttm.setString(5, kh.getYeuCauKhachHang());
            sttm.setString(7, kh.getMaNV());

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
            } catch (Exception e) {

            }
        }
        return -1; // nếu thêm không thành công
    }

    public int delKH(String maKH) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete KH where MaKH = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maKH);

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
            } catch (Exception e) {

            }
        }
        return -1; // nếu thêm không thành công
    }

    public KH getAtPosition(int pos) {
        return ls.get(pos);
    }
}
