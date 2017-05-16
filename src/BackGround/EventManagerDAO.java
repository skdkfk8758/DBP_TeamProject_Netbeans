/*
   행사관리 데이터 접근 객체
 */
package BackGround;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EventManagerDAO {

    DB_Handler dB_Handler = new DB_Handler();

    //행사관련 데이터 얻어오는 부분
    public Vector getEventIfon() {

        Vector data = new Vector();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DB_Handler.getConnection();

            String sql = "select mydate, event, count(name), sum(pay), sum(notpay) as pay from team_mfs group by mydate, event";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String date = rs.getString(1);
                String event = rs.getString(2);
                int sumMember = rs.getInt(3);
                int sumPay = rs.getInt(4);
                int sumNotpay = rs.getInt(5);

                //벡터에 DB테이블 데이터 넣어서 뷰테이블로 전달하기위한 부분
                Vector row = new Vector();

                row.add(date);
                row.add(event);
                row.add(sumMember);
                row.add(sumPay);
                row.add(sumNotpay);

                data.add(row);
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB_Handler.close(con, pstmt, rs);
        }

        return data;
    }
}
