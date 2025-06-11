/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Thanh
 */

//lớp BDS này cung cấp một cách để lưu trữ và thao tác với thông tin về một Bất Động Sản. 
//lớp BDS trong gói model. Lớp này định nghĩa một đối tượng BDS với các thuộc tính sau:
public class BDS {
    private String maBDS;
    private String sdt;
    private Date ngayDangKy;
    private boolean loaiBDS;
    private String diaChi;
    private String hinhAnh;  

    //hàm tạo với sáu tham số, cho phép khởi tạo một đối tượng BDS với tất cả các thông tin cụ thể.
    public BDS(String maBDS, String sdt, Date ngayDangKy, boolean loaiBDS, String diaChi, String hinhAnh) {
        this.maBDS = maBDS;
        this.sdt = sdt;
        this.ngayDangKy = ngayDangKy;
        this.loaiBDS = loaiBDS;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    //Hàm tạo với hai tham số, cho phép khởi tạo một đối tượng BDS với mã BDS và số điện thoại cụ thể.
    public BDS(String maBDS, String sdt) {
        this.maBDS = maBDS;
        this.sdt = sdt;
    }
    
    //Hàm tạo không tham số, khởi tạo một đối tượng BDS với các giá trị mặc định.
    public BDS() {
    this.maBDS = "";
    this.sdt = "";
    this.ngayDangKy = new Date(); // Ngày hiện tại
    this.loaiBDS = false;
    this.diaChi = "";
    this.hinhAnh = "";
}


    //các phương thức getter và setter cho mỗi thuộc tính, cho phép truy cập và thay đổi giá trị của các thuộc tính. Ví dụ, getMaBDS() trả về giá trị của maBDS, và setMaBDS(String maBDS) thiết lập giá trị mới cho maBDS.
    public String getMaBDS() {
        return maBDS;
    }

    public void setMaBDS(String maBDS) {
        this.maBDS = maBDS;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String SDT) {
        this.sdt = SDT;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isLoaiBDS(boolean loaibds) {
        return loaiBDS;
    }

    public void setLoaiBDS(boolean loaiBDS) {
        this.loaiBDS = loaiBDS;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public boolean isLoaiBDS() {
        return loaiBDS;
    }

}


