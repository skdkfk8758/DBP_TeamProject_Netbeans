package BackGround;

import View.MainFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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

            String sql = "SELECT * FROM mfs ORDER BY mydate";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String Mydate = rs.getString(1);
                String MemberName = rs.getString(2);
                String Memo = rs.getString(3);
                int Price = rs.getInt(4);
                int Payment = rs.getInt(5);
                int Notpayment = rs.getInt(6);
                String Remarks = rs.getString(7);

                Vector row = new Vector();

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

     //회원별 회비 리스트 가져오는 메소드
    public Vector getMfsListByMember(String name) {

        Vector data = new Vector();

        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        
        int notpaymoney = 0;

        try {
            con = dB_Handler.getConnection();

            String sql = "SELECT * FROM mfs WHERE membername = ? ORDER BY mydate";
            
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String Mydate = rs.getString(1);
                String MemberName = rs.getString(2);
                String Memo = rs.getString(3);
                int Price = rs.getInt(4);
                int Payment = rs.getInt(5);
                int Notpayment = rs.getInt(6);
                String Remarks = rs.getString(7);

                notpaymoney = notpaymoney + Notpayment;
                
                Vector row = new Vector();

                row.add(Mydate);
                row.add(MemberName);
                row.add(Memo);
                row.add(Price);
                row.add(Payment);
                row.add(Notpayment);
                row.add(Remarks);

                data.add(row);
            }

            MainFrame.Tf_NotPayMoney_Mfs.setText(Integer.toString(notpaymoney));
            
        } catch (Exception e) {
            e.getMessage();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return data;
    }
   
    //회비 잔고계산을 위한 메소드
    public Vector getMfsSelectMoney() {

        Vector data = new Vector();

        int allmoney = 0, notpaymoney = 0, currentmonry = 0;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            String sql = "SELECT payment, notpayment FROM mfs";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                currentmonry = currentmonry + rs.getInt(1);
                notpaymoney = notpaymoney + rs.getInt(2);

                allmoney = currentmonry + notpaymoney;
            }

            data.add(allmoney);
            data.add(currentmonry);
            data.add(notpaymoney);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return data;
    }

    //회비내용 추가 메소드
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
            pstmt.setString(2, dto.getMembername());
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

    //회비목록 삭제 메소드
    public boolean deleteMfs(MfsDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            //학번으로 검색하여 삭제
            String sql = "DELETE FROM mfs WHERE mydate = ? and memo = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, dto.getMydate());
            pstmt.setString(2, dto.getMemo());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                ok = true;
            }

        } catch (Exception e) {
            e.getMessage();
        } finally {
            dB_Handler.close(con, pstmt, rs);
        }

        return ok;
    }

    //회비내용 수정 메소드
    public boolean updateMfs(MfsDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            //날짜와 행사이름을 가지고 납부금액 수정
            String sql = "UPDATE mfs set payment = ?, notpayment = ?, remarks = ? WHERE mydate = ? and memo = ?";
            pstmt = con.prepareStatement(sql);

            int notpayment = dto.getPrice() - dto.getPaymoney();

            pstmt.setInt(1, dto.getPaymoney());
            pstmt.setInt(2, notpayment);
            pstmt.setString(3, dto.getRemarks());
            pstmt.setString(4, dto.getMydate());
            pstmt.setString(5, dto.getMemo());

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
