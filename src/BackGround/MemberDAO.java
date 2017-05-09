/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackGround;

import View.MainFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author xkdlr
 */
public class MemberDAO {

    DB_Handler dB_Handler = new DB_Handler();

    //전체 멤버 리스트 가져오는 메소드
    public Vector getMemberList() {

        Vector data = new Vector();

        int countNew = 0;
        int countOld = 0;
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //신입생 재학생 구분을 위해 현재 날짜 얻어노는 부분
        Date date = new Date();
        SimpleDateFormat year_SDF = new SimpleDateFormat("yyyy", Locale.KOREA);
        String year = year_SDF.format(date);

        try {
            con = dB_Handler.getConnection();

            // 학번순으로 오름차순 정렬
            String sql = "SELECT * FROM dbp_team_member ORDER BY member_id";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                int Student_Id = rs.getInt(1);
                String Department = rs.getString(2);
                String Name = rs.getString(3);
                String Phone = rs.getString(4);
                String annual = rs.getString(5);
                
                //신입생, 재학생 수 카운트
                if(annual.equals(year))
                    countNew++;
                else
                    countOld++;
                
                //신입생, 재학생 수 출력(표시 -> 텍스트필드에)
                MainFrame.TF_NewStudent.setText(Integer.toString(countNew));
                MainFrame.TF_OldStudent.setText(Integer.toString(countOld));
                MainFrame.TF_AllStudent.setText(Integer.toString(countNew + countOld));
                
                //벡터에 DB테이블 데이터 넣어서 뷰테이블로 전달하기위한 부분
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

    //회원추가 메소드
    public boolean insertMember(MemberDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            String sql = "INSERT INTO dbp_team_member VALUES(?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);

            //신입생, 재학생 구분을 위한 현재날짜 얻어오는 부분
            Date date = new Date();
//            SimpleDateFormat year_SDF = new SimpleDateFormat("yyyy", Locale.KOREA);
//            String year = year_SDF.format(date);

            pstmt.setInt(1, dto.getStudent_id());
            pstmt.setString(2, dto.getDepartment());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getPhone());
            pstmt.setInt(5, dto.getYear());

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

    //회원삭제 메소드
    public boolean deleteMember(MemberDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            //학번으로 검색하여 삭제
            String sql = "DELETE FROM dbp_team_member WHERE member_id = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, dto.getStudent_id());

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

    //회원정보수정 메소드
    public boolean updateMember(MemberDTO dto) {
        boolean ok = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dB_Handler.getConnection();

            //학번을 가지고 나머지 데이터 수정
            String sql = "UPDATE dbp_team_member set member_department = ?, member_name = ?, member_phone = ? WHERE member_id = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, dto.getDepartment());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getPhone());
            pstmt.setInt(4, dto.getStudent_id());

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
