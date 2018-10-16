package dao;

import Entity.NhanVien;
import common.ConnectToProperties;

import java.sql.*;
import java.util.*;

public class NhanVienDAO {
    public List<NhanVien> selectNV(){
        List<NhanVien> listNV =  new ArrayList<NhanVien>();
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()))) {
            ResultSet result = connection.prepareCall("{call SelectNhanVien()}").executeQuery();
            while ( result.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(result.getInt("maNV"));
                nv.setTen(result.getString("ten"));
                nv.setCa(result.getBoolean("ca"));
                nv.setSdt(result.getString("sdt"));
                nv.setLuong(result.getInt("luong"));
                nv.setThuong(result.getInt("thuong"));
                listNV.add(nv);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listNV;
    }
    public void insertNV(NhanVien nv){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call themNhanVien(?,?,?,?,?)}")
        ) {
            pre.setString(1,nv.getTen());
            pre.setBoolean(2, nv.getCa());
            pre.setString(3, nv.getSdt());
            pre.setInt(4, nv.getLuong());
            pre.setInt(5, nv.getThuong());
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void suaNV(NhanVien nv){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call suaNhanVien(?,?,?,?,?,?)}")
        ) {
            pre.setInt(1,nv.getMaNV());
            pre.setString(2,nv.getTen());
            pre.setBoolean(3, nv.getCa());
            pre.setString(4, nv.getSdt());
            pre.setInt(5, nv.getLuong());
            pre.setInt(6, nv.getThuong());
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteNV(int maNV){
        try(Connection connection =
                    DriverManager.getConnection((ConnectToProperties.getConnectionUrl()));
            PreparedStatement pre = connection.prepareCall("{call xoaNV(?)}")
        ) {
            pre.setInt(1,maNV);
            pre.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
