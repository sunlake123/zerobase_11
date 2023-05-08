package com.example;

import com.example.DTO.*;
import com.example.api.API;

import java.awt.print.Book;
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
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            stmt.executeUpdate("drop table if exists wifi");
            stmt.executeUpdate("create table if not exists wifi (\n" +
                    "    xSwifiMgrNo primary key,\n" +
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
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert() throws IOException {
        System.out.println("insert()");
        API api = new API();
        int row;
        int totalCount = 0;
        for (int i = 0; i <= 0; i++) {
            row = (i == 22) ? 82 : 1000;
            WifiDTO wifiDTO = api.takeWifi(i * 1000 + 1, i * 1000 + row);
            try {

                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);

                String sql = "INSERT INTO wifi VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                for (int j = 0; j < row; j++) {
                    psmt = con.prepareStatement(sql);

                    String tmp = wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiMgrNo();
                    while ('-' == tmp.charAt(0)) {
                        tmp = tmp.substring(1);
                    }
                    psmt.setString(1, tmp);
                    psmt.setString(2, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiWrdofc());
                    psmt.setString(3, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiMainNm());
                    psmt.setString(4, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiAdres1());
                    psmt.setString(5, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiAdres2());
                    psmt.setString(6, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiInstlFloor());
                    psmt.setString(7, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiInstlTy());
                    psmt.setString(8, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiInstlMby());
                    psmt.setString(9, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiSvcSe());
                    psmt.setString(10, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiCmcwr());
                    psmt.setString(11, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiCnstcYear());
                    psmt.setString(12, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiInoutDoor());
                    psmt.setString(13, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getxSwifiRemars3());
                    psmt.setString(14, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getLnt());
                    psmt.setString(15, wifiDTO.getTbPublicWifiInfo().getRow().get(j).getLat());
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
        List<ShowWifiDTO> list = new ArrayList<>();
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);


            String sql = "SELECT * FROM wifi";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ShowWifiDTO showWifiDTO = new ShowWifiDTO();
                showWifiDTO.setxSwifiMgrNo(rs.getString(1));
                showWifiDTO.setxSwifiWrdofc(rs.getString(2));
                showWifiDTO.setxSwifiMainNm(rs.getString(3));
                showWifiDTO.setxSwifiAdres1(rs.getString(4));
                showWifiDTO.setxSwifiAdres2(rs.getString(5));
                showWifiDTO.setxSwifiInstlFloor(rs.getString(6));
                showWifiDTO.setxSwifiInstlTy(rs.getString(7));
                showWifiDTO.setxSwifiInstlMby(rs.getString(8));
                showWifiDTO.setxSwifiSvcSe(rs.getString(9));
                showWifiDTO.setxSwifiCmcwr(rs.getString(10));
                showWifiDTO.setxSwifiCnstcYear(rs.getString(11));
                showWifiDTO.setxSwifiInoutDoor(rs.getString(12));
                showWifiDTO.setxSwifiRemars3(rs.getString(13));
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

    public Row selectOne(String xSwifiMgrNo) {
        Row row = new Row();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);

            String sql = "select * from wifi where xSwifiMgrNo = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, xSwifiMgrNo);

            rs = psmt.executeQuery();
            row.setxSwifiMgrNo(rs.getString(1));
            row.setxSwifiWrdofc(rs.getString(2));
            row.setxSwifiMainNm(rs.getString(3));
            row.setxSwifiAdres1(rs.getString(4));
            row.setxSwifiAdres2(rs.getString(5));
            row.setxSwifiInstlFloor(rs.getString(6));
            row.setxSwifiInstlTy(rs.getString(7));
            row.setxSwifiInstlMby(rs.getString(8));
            row.setxSwifiSvcSe(rs.getString(9));
            row.setxSwifiCmcwr(rs.getString(10));
            row.setxSwifiCnstcYear(rs.getString(11));
            row.setxSwifiInoutDoor(rs.getString(12));
            row.setxSwifiRemars3(rs.getString(13));
            row.setLat(rs.getString(14));
            row.setLnt(rs.getString(15));
            row.setWorkDttm(rs.getString(16));

            rs.close();
            psmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public void addGroup(String bookmarkName) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "INSERT INTO bookmark (bookmark_name, bookmark_regDate) VALUES(?, datetime('now','localtime'));)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmarkName);
            psmt.executeUpdate();
            psmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BookmarkGroupDTO> selectGroups() {
        System.out.println("selectGroups()");
        List<BookmarkGroupDTO> bookmarkDTOS = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists bookmark (\n" +
                    "          bookmark_no integer primary key autoincrement,\n" +
                    "          bookmark_name,\n" +
                    "          bookmark_regDate,\n" +
                    "          bookmark_editDate\n" +
                    "      )");
            stmt.executeUpdate("create table if not exists wifi_bookmark (\n" +
                    "    bookmark_no integer primary key autoincrement,\n" +
                    "    bookmark_name,\n" +
                    "    wifi_name,\n" +
                    "    bookmark_regDate, \n" +
                    "    constraint fk_bookmark_no foreign key(bookmark_no) references bookmark(bookmark_no) on delete cascade\n" +
                    ")");
            stmt.close();
            String sql = "select * from bookmark";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                BookmarkGroupDTO bookmarkDTO = new BookmarkGroupDTO();
                bookmarkDTO.setBookmark_no(Integer.parseInt(rs.getString(1)));
                bookmarkDTO.setBookmark_name(rs.getString(2));
                bookmarkDTO.setBookmark_regDate(rs.getString(3));
                bookmarkDTO.setBookmark_editDate(rs.getString(4));
                bookmarkDTOS.add(bookmarkDTO);
            }
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return bookmarkDTOS;
    }

    public void editGroup(String bookmark_no, String bookmark_name) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "UPDATE bookmark SET bookmark_name = ?, bookmark_editDate = datetime('now','localtime') WHERE bookmark_no = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmark_name);
            psmt.setString(2, bookmark_no);
            psmt.executeUpdate();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BookmarkGroupDTO selectGroup(String bookmarkNo) {
        BookmarkGroupDTO bookmarkDTO = new BookmarkGroupDTO();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "select * from bookmark where bookmark_no = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmarkNo);
            rs = psmt.executeQuery();
            bookmarkDTO.setBookmark_no(Integer.parseInt(rs.getString(1)));
            bookmarkDTO.setBookmark_name(rs.getString(2));
            bookmarkDTO.setBookmark_regDate(rs.getString(3));
            bookmarkDTO.setBookmark_editDate(rs.getString(4));
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return bookmarkDTO;
    }

    public void deleteGroup(String bookmarkNo) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "delete from bookmark where bookmark_no = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmarkNo);
            psmt.executeUpdate();

            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBookmark(String wifi_name, String bookmark_name) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "insert into wifi_bookmark (bookmark_name, wifi_name, bookmark_regDate) values(?, ?, datetime('now','localtime'))";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmark_name);
            psmt.setString(2, wifi_name);
            psmt.executeUpdate();

            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BookmarkDTO> selectBookmarks() {
        List<BookmarkDTO> bookmarkDTOS = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "select * from wifi_bookmark";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                BookmarkDTO bookmarkDTO = new BookmarkDTO();
                bookmarkDTO.setBookmark_no(rs.getString(1));
                bookmarkDTO.setBookmark_name(rs.getString(2));
                bookmarkDTO.setWifi_name(rs.getString(3));
                bookmarkDTO.setBookmark_regDate(rs.getString(4));
                bookmarkDTOS.add(bookmarkDTO);
            }
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return bookmarkDTOS;
    }

    public BookmarkDTO selectBookmark(String bookmark_no) {
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "select * from wifi_bookmark where bookmark_no = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmark_no);
            rs = psmt.executeQuery();
            bookmarkDTO.setBookmark_no(rs.getString(1));
            bookmarkDTO.setBookmark_name(rs.getString(2));
            bookmarkDTO.setWifi_name(rs.getString(3));
            bookmarkDTO.setBookmark_regDate(rs.getString(4));
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return bookmarkDTO;
    }

    public void deleteBookmark(String bookmarkNo) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "delete from wifi_bookmark where bookmark_no = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, bookmarkNo);
            psmt.executeUpdate();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHistory(String lat, String lnt) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists history (" +
                    "history_id integer primary key autoincrement," +
                    "history_lat," +
                    "history_lnt," +
                    "history_regDate" +
                    ")");
            stmt.close();

            String sql = "insert into history (history_lat, history_lnt, history_regDate) values (?, ?, datetime('now','localtime'))";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, lat);
            psmt.setString(2, lnt);
            psmt.executeUpdate();

            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HistoryDTO> selectAllHistory() {
        List<HistoryDTO> historyDTOS = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "select * from history";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                HistoryDTO historyDTO = new HistoryDTO();
                historyDTO.setHistory_id(rs.getString(1));
                historyDTO.setHistory_lat(rs.getString(2));
                historyDTO.setHistory_lnt(rs.getString(3));
                historyDTO.setHistory_regDate(rs.getString(4));
                historyDTOS.add(historyDTO);
            }
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return historyDTOS;
    }

    public HistoryDTO selectHistory(String historyId) {
        HistoryDTO historyDTO = new HistoryDTO();
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "select * from history where history_id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, historyId);
            rs = psmt.executeQuery();
            historyDTO.setHistory_id(rs.getString(1));
            historyDTO.setHistory_lat(rs.getString(2));
            historyDTO.setHistory_lnt(rs.getString(3));
            historyDTO.setHistory_regDate(rs.getString(4));
            rs.close();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return historyDTO;
    }

    public void deleteHistory(String historyId) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String sql = "delete from history where history_id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, historyId);
            psmt.executeUpdate();
            psmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
