/*
    회비관리 DB에 접근하기위한 객체
 */
package BackGround;

import View.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
            con = DB_Handler.getConnection();

            //날짜순으로 정렬해서 테이블 출력
            String sql = "SELECT * FROM team_mfs ORDER BY mydate";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String date = rs.getString(1);
                String MemberName = rs.getString(2);
                String evnet = rs.getString(3);
                int Price = rs.getInt(4);
                int Payment = rs.getInt(5);
                int Notpayment = rs.getInt(6);
                String Remarks = rs.getString(7);

                Vector row = new Vector();

                row.add(date);
                row.add(MemberName);
                row.add(evnet);
                row.add(Price);
                row.add(Payment);
                row.add(Notpayment);
                row.add(Remarks);

                data.add(row);
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB_Handler.close(con, pstmt, rs);
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
            con = DB_Handler.getConnection();

            //회원 이름별로 날짜순 정렬 -> 회원검색시
            String sql = "SELECT * FROM team_mfs WHERE name = ? ORDER BY mydate";

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

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB_Handler.close(con, pstmt, rs);
        }

        return data;
    }

    //회비 잔고계산을 위한 메소드
    public Vector getMfsSelectMoney() {

        Vector data = new Vector();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            int allmoney = 0, notpaymoney = 0, currentmonry = 0;

            con = DB_Handler.getConnection();

            // 납부금액, 미납금액을 읽어오는 쿼리문
            String sql = "SELECT pay, notpay FROM team_mfs";

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

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB_Handler.close(con, pstmt, rs);
        }

        return data;
    }

    //회비내용 추가할때 중복확인 메소드
    public boolean check_overlap(MfsDTO dto) {
        boolean ok = false;
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DB_Handler.getConnection();

            //회원목록에서 회원이 있는지 검색
            String select_sql = "SELECT count(*) FROM team_mfs where name = ? and mydate = ? and event = ?";

            pstmt = con.prepareStatement(select_sql);

            pstmt.setString(1, dto.getMembername());
            pstmt.setString(2, dto.getMydate());
            pstmt.setString(3, dto.getMemo());

            rs = pstmt.executeQuery();
            rs.next();
            if(rs.getInt(1)<=0)
                ok=true;
            
        } catch (SQLException e) {
        } finally {
            DB_Handler.close(con, pstmt, rs);
        }
        return ok;
    }
    
    //회비내용 추가 메소드
    public boolean insertMfs(MfsDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DB_Handler.getConnection();

            //회원목록에서 회원이 있는지 검색
            String select_sql = "SELECT count(*) FROM team_member where name = ?";

            pstmt = con.prepareStatement(select_sql);

            pstmt.setString(1, dto.getMembername());

            rs = pstmt.executeQuery();
            rs.next();
   
            if (rs.getInt(1) > 0 && check_overlap(dto)) {
                //회원검색 성공 시 회비 내용 추가
                String sql = "INSERT INTO team_mfs VALUES(?,?,?,?,?,?,?)";
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
            }
        } catch (SQLException e) {
        } finally {
            DB_Handler.close(con, pstmt, rs);
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
            con = DB_Handler.getConnection();

            //날짜, 행사, 이름을 가지고 레코드 삭제
            String sql = "DELETE FROM team_mfs WHERE mydate = ? and event = ? and name = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, dto.getMydate());
            pstmt.setString(2, dto.getMemo());
            pstmt.setString(3, dto.getMembername());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                ok = true;
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB_Handler.close(con, pstmt, rs);
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
            con = DB_Handler.getConnection();

            //날짜와 행사이름, 회원이름을 가지고 납부금액 수정, 비고도 수정 가능
            String sql = "UPDATE team_mfs set pay = ?, notpay = ?, remarks = ? WHERE mydate = ? and event = ? and name = ?";
            pstmt = con.prepareStatement(sql);

            int notpayment = dto.getPrice() - dto.getPaymoney();

            pstmt.setInt(1, dto.getPaymoney());
            pstmt.setInt(2, notpayment);
            pstmt.setString(3, dto.getRemarks());
            pstmt.setString(4, dto.getMydate());
            pstmt.setString(5, dto.getMemo());
            pstmt.setString(6, dto.getMembername());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                ok = true;
            }

        } catch (SQLException e) {
        } finally {
            DB_Handler.close(con, pstmt, rs);
        }

        return ok;
    }
}
