/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuanthanhnguyen
 */
import java.util.Date;

public class KH {

    private String maKH;
    private String sdt;
    private String tenKH;
    private Date ngayDangKy;
    private boolean nhucau;
    private String yeuCauKhachHang;
    private String maNV; // Thêm trường maNV
    
      //hàm tạo với sáu tham số, cho phép khởi tạo một đối tượng BDS với tất cả các thông tin cụ thể.
    /*public KH(String maKH, String sdt, String tenKH, Date ngayDangKy, boolean nhucau, String yeuCauKhachHang) {
        this(maKH, sdt, tenKH, ngayDangKy, nhucau, yeuCauKhachHang);
        
    }*/

    //hàm tạo với sáu tham số, cho phép khởi tạo một đối tượng BDS với tất cả các thông tin cụ thể.
    public KH(String maKH, String sdt, String tenKH, Date ngayDangKy, boolean nhucau, String yeuCauKhachHang, String maNV) {
        this.maKH = maKH;
        this.sdt = sdt;
        this.tenKH = tenKH;
        this.ngayDangKy = ngayDangKy;
        this.nhucau = nhucau;
        this.yeuCauKhachHang = yeuCauKhachHang;
        this.maNV = maNV;
    }

    //Hàm tạo với hai tham số, cho phép khởi tạo một đối tượng BDS với mã BDS và số điện thoại cụ thể.
    public KH(String maKH, String sdt) {
        this.maKH = maKH;
        this.sdt = sdt;
    }

    //Hàm tạo không tham số, khởi tạo một đối tượng BDS với các giá trị mặc định.
    public KH() {
        this.maKH = "";
        this.sdt = "";
        this.tenKH = "";
        this.ngayDangKy = new Date(); // Ngày hiện tại
        this.nhucau = false;
        this.yeuCauKhachHang = "";
    }
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isNhucau() {
        return nhucau;
    }

    public void setNhucau(boolean nhucau) {
        this.nhucau = nhucau;
    }

    public String getYeuCauKhachHang() {
        return yeuCauKhachHang;
    }

    public void setYeuCauKhachHang(String yeuCauKhachHang) {
        this.yeuCauKhachHang = yeuCauKhachHang;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}