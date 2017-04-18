/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGround;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CarpDm
 */
public class DB_Handler {

    /*
	 * 싱글톤패턴으로 DB_Handler 구현
     */
    // private static 로 선언.
    private static DB_Handler instance = null;

    public static DB_Handler getInstance() {
        if (instance == null) {
            return instance = new DB_Handler();
        } else {
            return instance;
        }
    }

    //디비 접속을 위한 변수선
    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@25.11.88.29:1521:xe";
    private static String user = "system1";
    private static String password = "system1";

    static {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver Loading Succ");
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
    }

    //sql 커넥션 얻어오는 메소드
    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Succ");

        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }

        return connection;
    }
    
    //커넥션 및 기타 리소스 해제
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        
        try{
         if(rs != null) rs.close();
         if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
        } catch(Exception e){
            e.getMessage();
        }
    }

}
