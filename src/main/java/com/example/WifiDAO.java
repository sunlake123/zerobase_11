package com.example;

import com.example.DTO.ShowWifiDTO;
import com.example.api.API;
import com.example.DTO.WifiDTO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiDAO {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement psmt;
    private Statement stmt;
    private String url = "jdbc:sqlite:C:\\Users\\KWY\\IdeaProjects\\Mission_1\\wifi.db";

    public void createTable() {
        System.out.println("createTable()");

    }
    public int insert() throws IOException {
        System.out.println("insert()");
        API api = new API();
        int row;
        int totalCount = 0;
        for (int i = 0; i <= 22; i++) {
            row = (i == 22)? 82 : 1000;
            WifiDTO wifiDTO = api.takeWifi(i * 1000 + 1, i * 1000 + row);
            try {

                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);

                stmt = con.createStatement();
                stmt.executeUpdate("drop table wifi");

                stmt.executeUpdate("create table if not exists wifi (\n" +
                        "    xSwifiMgrNo,\n" +
                        "    xSwifiWrdofc,\n" +
                        "    xSwifiMainNm,\n" +
                        "    xSwifiAdres1,\n" +
                        "    xSwifiAdres2,\n" +
                        "    xSwifiInstlFloor,\n" +
                        "    xSwifiInstlTy,\n" +
                        "    xSwifiInstlMby,\n" +
                        "    xSwifiSvcSe,\n" +
                        "    xSwifiCmcwr,\n" +
                        "    xSwifiCnstcYear,\n" +
                        "    xSwifiInoutDoor,\n" +
                        "    xSwifiRemars3,\n" +
                        "    lat,\n" +
                        "    lnt,\n" +
                        "    workDttm\n" +
                        "    )");
                stmt.close();

                String sql = "INSERT INTO wifi VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


                for (int j = 0; j < row; j++) {
                    psmt = con.prepareStatement(sql);
                    psmt.setString(1, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiMgrNo());
                    psmt.setString(2, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiWrdofc());
                    psmt.setString(3, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiMainNm());
                    psmt.setString(4, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiAdres1());
                    psmt.setString(5, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiAdres2());
                    psmt.setString(6, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiInstlFloor());
                    psmt.setString(7, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiInstlTy());
                    psmt.setString(8, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiInstlMby());
                    psmt.setString(9, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiSvcSe());
                    psmt.setString(10, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiCmcwr());
                    psmt.setString(11, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiCnstcYear());
                    psmt.setString(12, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiInoutDoor());
                    psmt.setString(13, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getXSwifiRemars3());
                    psmt.setString(14, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getLat());
                    psmt.setString(15, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getLnt());
                    psmt.setString(16, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getWorkDttm());

                    psmt.executeUpdate();
                    System.out.println("왔니?");
                }

                psmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if (i == 0) totalCount = wifiDTO.getTbPublicWifiInfo().getListTotalCount();
        }
        return totalCount;
    }

    public List<ShowWifiDTO> selectAll() {
        List<ShowWifiDTO> list = new ArrayList<ShowWifiDTO>();
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);


            String sql = "SELECT * FROM wifi";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ShowWifiDTO showWifiDTO = new ShowWifiDTO();
                showWifiDTO.setXSwifiMgrNo(rs.getString(1));
                showWifiDTO.setXSwifiWrdofc(rs.getString(2));
                showWifiDTO.setXSwifiMainNm(rs.getString(3));
                showWifiDTO.setXSwifiAdres1(rs.getString(4));
                showWifiDTO.setXSwifiAdres2(rs.getString(5));
                showWifiDTO.setXSwifiInstlFloor(rs.getString(6));
                showWifiDTO.setXSwifiInstlTy(rs.getString(7));
                showWifiDTO.setXSwifiInstlMby(rs.getString(8));
                showWifiDTO.setXSwifiSvcSe(rs.getString(9));
                showWifiDTO.setXSwifiCmcwr(rs.getString(10));
                showWifiDTO.setXSwifiCnstcYear(rs.getString(11));
                showWifiDTO.setXSwifiInoutDoor(rs.getString(12));
                showWifiDTO.setXSwifiRemars3(rs.getString(13));
                showWifiDTO.setLat(Double.parseDouble(rs.getString(14)));
                showWifiDTO.setLnt(Double.parseDouble(rs.getString(15)));
                showWifiDTO.setWorkDttm(rs.getString(16));
                list.add(showWifiDTO);
            }
            rs.close();
            psmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
