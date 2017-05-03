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
public class MfsDAO {

    DB_Handler dB_Handler = new DB_Handler();

    //전체 회비 리스트 가져오는 메소드
    public Vector getMfsList() {

        Vector data = new Vector();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            String sql = "SELECT * FROM mfs";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                int Index_Num = rs.getInt(1);
                String Mydate = rs.getString(2);
                String MemberName = rs.getString(3);
                String Memo = rs.getString(4);
                int Price = rs.getInt(5);
                int Payment = rs.getInt(6);
                int Notpayment = rs.getInt(7);
                String Remarks = rs.getString(8);

                Vector row = new Vector();

                row.add(Index_Num);
                row.add(Mydate);
                row.add(MemberName);
                row.add(Memo);
                row.add(Price);
                row.add(Payment);
                row.add(Notpayment);
                row.add(Remarks);

                data.add(row);
            }

        } catch (Exception e) {
            e.getMessage();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return data;
    }

    //회비내용 추가
    public boolean insertMfs(MfsDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            String sql = "INSERT INTO mfs VALUES(?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, dto.getMydate());
            pstmt.setString(2, dto.getMemberName());
            pstmt.setString(3, dto.getMemo());
            pstmt.setInt(4, dto.getPrice());
            pstmt.setInt(5, dto.getPaymoney());
            pstmt.setInt(6, dto.getNotpaymoney());
            pstmt.setString(7, dto.getRemarks());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return ok;
    }
}
