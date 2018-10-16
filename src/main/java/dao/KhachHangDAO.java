package dao;

import Entity.KhachHang;
import common.ConnectToProperties;

import java.sql.*;
import java.util.*;

public class KhachHangDAO {
    public List<KhachHang> selectKH(){
        List<KhachHang> list =  new ArrayList<KhachHang>();
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()))) {
            ResultSet result = connection.prepareCall("{call SelectKH()}").executeQuery();
            while ( result.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(result.getInt("maKhachHang"));
                kh.setSdt(result.getString("sdt"));
                kh.setDiem(result.getInt("diem"));
                list.add(kh);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertKH(KhachHang kh){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call themKH(?,?)}")
        ) {
            pre.setString(1, kh.getSdt());
            pre.setInt(2, kh.getDiem());
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void suaKH(KhachHang kh){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call suaKH(?,?,?)}")
        ) {
            pre.setInt(1, kh.getMaKhachHang());
            pre.setString(2, kh.getSdt());
            pre.setInt(3, kh.getDiem());
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void xoaKH(int maKH){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call xoaKH(?)}")
        ) {
            pre.setInt(1,maKH);
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
