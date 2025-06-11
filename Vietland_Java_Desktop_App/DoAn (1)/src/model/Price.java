/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thanh
 */
public class Price {
   private int id;
   private BDS bds;
   private long giaChuNha, giaKhach, giaGDCu;

    public Price() {
    }

    public Price(int id, BDS bds, long giaChuNha, long giaKhach, long giaGDCu) {
        this.id = id;
        this.bds = bds;
        this.giaChuNha = giaChuNha;
        this.giaKhach = giaKhach;
        this.giaGDCu = giaGDCu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BDS getBDS() {
        return bds;
    }

    public void setBDS(BDS bds) {
        this.bds = bds;
    }

    public long getGiaChuNha() {
        return giaChuNha;
    }

    public void setGiaChuNha(long giaChuNha) {
        this.giaChuNha = giaChuNha;
    }

    public long getGiaKhach() {
        return giaKhach;
    }

    public void setGiaKhach(long giaKhach) {
        this.giaKhach = giaKhach;
    }

    public long getGiaGDCu() {
        return giaGDCu;
    }

    public void setGiaGDCu(long giaGDCu) {
        this.giaGDCu = giaGDCu;
    }
   
   public long getGiaMucTieu () {
       return (getGiaChuNha()+ getGiaKhach()+ getGiaGDCu())/3;
   }
   
   public String getTiemNang() {
    String tn = "";
    long gmt = getGiaMucTieu();
    if (gmt > giaKhach) {
        tn = "Ít tiềm năng";
    } else if (gmt < giaKhach) {
        tn = "Nhiều tiềm năng";
    } else if (gmt == giaKhach) {
        tn = "Tiềm năng trung bình";
    }

    if (gmt > giaChuNha) {
        tn += ", tiềm năng kém so với giá chủ nhà";
    } else if (gmt < giaChuNha) {
        tn += ", tiềm năng cao so với giá chủ nhà";
    } else if (gmt == giaChuNha) {
        tn += ", tiềm năng trung bình so với giá chủ nhà";
    }

    if (gmt > giaGDCu) {
        tn += ", có thể thương lượng được";
    } else if (gmt < giaGDCu) {
        tn += ", khó có thể thương lượng";
    } else if (gmt == giaGDCu) {
        tn += ", có thể thương lượng được";
    }

    return tn;
}

}
