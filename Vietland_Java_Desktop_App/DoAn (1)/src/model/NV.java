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

/**
 *
 * @author xuanthanhnguyen
 */
public class NV {

    private String maNV;
    private String tenNV;
    private long luongCB;
    private long thuong;
    private Date ngayDangKy;
    private boolean phongBan;
    private String baoCaoNhanVien;
    private String maKH;


    public NV() {
    }

    public NV(String maNV, String tenNV, long luongCB, long thuong, Date ngayDangKy, boolean phongBan, String baoCaoNhanVien, String maKH) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luongCB = luongCB;
        this.thuong = thuong;
        this.ngayDangKy = ngayDangKy;
        this.phongBan = phongBan;
        this.baoCaoNhanVien = baoCaoNhanVien;
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public long getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(long luongCB) {
        this.luongCB = luongCB;
    }

    public long getThuong() {
        return thuong;
    }

    public void setThuong(long thuong) {
        this.thuong = thuong;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isPhongBan() {
        return phongBan;
    }

    public void setPhongBan(boolean phongBan) {
        this.phongBan = phongBan;
    }

    public String getBaoCaoNhanVien() {
        return baoCaoNhanVien;
    }

    public void setBaoCaoNhanVien(String baoCaoNhanVien) {
        this.baoCaoNhanVien = baoCaoNhanVien;
    }
    
    public long getTongLuong() {
    long tongLuong = getLuongCB() + getThuong();
    return tongLuong;
}

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

}
