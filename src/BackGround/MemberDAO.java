/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGround;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author xkdlr
 */
public class MemberDAO {

    DB_Handler dB_Handler = new DB_Handler();

    public Vector getMemberList() {

        Vector data = new Vector();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            String sql = "SELECT * FROM member";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                int Student_Id = rs.getInt(1);
                String Department = rs.getString(2);
                String Name = rs.getString(3);
                String Phone = rs.getString(4);
                
                Vector row = new Vector();
                
                row.add(Student_Id);
                row.add(Department);
                row.add(Name);
                row.add(Phone);
                
                data.add(row);
            }

        } catch (Exception e) {
            e.getMessage();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return data;
    }

}
