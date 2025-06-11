/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanh
 */
public class PriceDAO {

    List<Price> ls = new ArrayList<>();
    

//    public int add(Price d) {
//        ls.add(d);
//        return 1;
//    }
    public int add(Price p) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into Price(MaBDS, GiaChuNha, GiaKhach, GiaGDCu) values (?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, p.getBDS().getMaBDS());
            sttm.setLong(2, p.getGiaChuNha());
            sttm.setLong(3, p.getGiaKhach());
            sttm.setLong(4, p.getGiaGDCu());
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

//    public List<Price> getAllPrice() {
//        return ls;
//    }
    public List<Price> getAllPrice() {
        List<Price> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT dbo.Price.MaBDS, dbo.BDS.SDT, dbo.Price.GiaChuNha, dbo.Price.GiaKhach, dbo.Price.GiaGDCu FROM dbo.Price INNER JOIN dbo.BDS ON dbo.Price.MaBDS = dbo.BDS.MaBDS";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Price p = new Price();
                p.setBDS(new BDS(rs.getString(1), rs.getString(2)));
                p.setGiaChuNha(rs.getLong(3));
                p.setGiaKhach(rs.getLong(4));
                p.setGiaGDCu(rs.getLong(5));
                
                list.add(p);
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
//
//    public Price getOnePriceByMaBDS(String mabds) {
//        for (Price d : ls) {
//            if (d.getBDS().getMaBDS().equalsIgnoreCase(mabds)) {
//                return d;
//            }
//        }
//        return null;
//    }

    public Price getOnePriceByMaBDS(String mabds) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Price bds = new Price();
        try {
            String sSQL = "SELECT dbo.Price.MaBDS, dbo.BDS.SDT, dbo.Price.GiaChuNha, dbo.Price.GiaKhach, dbo.Price.GiaGDCu \n"
                    + "FROM dbo.Price \n"
                    + "INNER JOIN dbo.BDS ON dbo.Price.MaBDS = dbo.BDS.MaBDS \n"
                    + "WHERE dbo.Price.MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, mabds);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Price p = new Price();
                p.setBDS(new BDS(rs.getString(1), rs.getString(2)));
                p.setGiaChuNha(rs.getLong(3));
                p.setGiaKhach(rs.getLong(4));
                p.setGiaGDCu(rs.getLong(5));
                return p;
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

//    public int updatePrice(Price dNew) {
//        for (Price d : ls) {
//            if (d.getBDS().getMaBDS().equalsIgnoreCase(dNew.getBDS().getMaBDS())) {
//                d.setGiaChuNha(dNew.getGiaChuNha());
//                d.setGiaKhach(dNew.getGiaKhach());
//                d.setGiaGDCu(dNew.getGiaGDCu());
//                return 1;
//            }
//        }
//        return -1;
//    }
    public int updatePrice(Price p) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Price set GiaChuNha = ?, GiaKhach = ?, GiaGDCu = ? where MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(4, p.getBDS().getMaBDS());
            sttm.setLong(1, p.getGiaChuNha());
            sttm.setLong(2, p.getGiaKhach());
            sttm.setLong(3, p.getGiaGDCu());
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

//    public int delPrice(String mabds) {
//        Price d = getOnePriceByMaBDS(mabds);
//        if (d != null) {
//            ls.remove(d);
//            return 1;
//        }
//        return -1;
//    }
    public int delPrice(String maBDS) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete Price where MaBDS = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maBDS);

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
    

    public Price getAtPosition(int pos) {
        return ls.get(pos);
    }
}
