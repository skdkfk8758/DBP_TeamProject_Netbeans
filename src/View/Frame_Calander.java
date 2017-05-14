/*
    달력 프레임
*/

package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Frame_Calander extends javax.swing.JFrame implements MouseListener, ActionListener {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Calendar cal = Calendar.getInstance();

    String CalHeader[] = {"일", "월", "화", "수", "목", "금", "토"};
    String CalData[][] = new String[7][7];
    String Month;
    String DATE;
    
    JTable calTable;
    
    JButton MonthName;
    
    JButton Btn_Next;
    JButton Btn_Prev;
    JButton Btn_Enter;

    int flag = 0;

    // 날짜 설정
    static SimpleDateFormat year_S = new SimpleDateFormat("yyyy", Locale.KOREA);
    static SimpleDateFormat month_S = new SimpleDateFormat("MM", Locale.KOREA);
    static Date currentTime = new Date();
    static String mTime_Y = year_S.format(currentTime);
    static String mTime_M = month_S.format(currentTime);

    static int year = Integer.parseInt(mTime_Y);
    static int month = Integer.parseInt(mTime_M);

    // 달력구성하는 알고리즘
    class MakeCalendar 
    {

        public MakeCalendar(int flag) {

            //flag 받아서 전달, 다음달 계산을 위해 필요
            month = month + flag;

            //년도가 바뀌는거 계산
            if (month <= 0) {
                year--;
                month = 12;
            } else if (month > 12) {
                year++;
                month = 1;
            }

            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DATE, 1);

            int startDay = cal.get(Calendar.DAY_OF_WEEK); // 월 시작 요일
            int lastDay = cal.getActualMaximum(Calendar.DATE); // 월 마지막 날짜
            int inputDate = 1;
            int row = 0;

            for (int i = 1; inputDate <= lastDay; i++) {
                // 시작 요일이 오기전에는 공백 대입
                if (i < startDay) {
                    CalData[row][i - 1] = "";
                } else {
                    // 날짜 배열에 입력
                    CalData[row][(i - 1) % 7] = Integer.toString(inputDate);
                    inputDate++;

                    // 가로 마지막 열에 오면 행 바꿈
                    if (i % 7 == 0) {
                        row++;
                    }
                }
            }
        }
    }

    // 달력 테이블 생성 메소드
    public JScrollPane MakeCalScrollPane(int flag) {

        new MakeCalendar(flag);

        DefaultTableModel model = new DefaultTableModel(CalData, CalHeader);

        calTable = new JTable(model);

        calTable.addMouseListener(this);

        calTable.getTableHeader().setReorderingAllowed(false); // 컬럼 이동불가
        calTable.setColumnSelectionAllowed(true);
        calTable.setRowSelectionAllowed(true);
        calTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane CalScrollPane = new JScrollPane(calTable);
        CalScrollPane.setPreferredSize(new Dimension(200, 150)); // 스크롤펜 크기수정

        return CalScrollPane;
    }

    // 달력을 출력하는 메소드 (생성자)
    public Frame_Calander(int flag) {

        setLayout(new BorderLayout(20, 20));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout());

        Btn_Next = new JButton("Next");
        Btn_Prev = new JButton("Prev");
        Btn_Enter = new JButton("Enter");

        Btn_Next.addActionListener(this);
        Btn_Prev.addActionListener(this);
        Btn_Enter.addActionListener(this);

        JScrollPane CalScrollPane = MakeCalScrollPane(flag);

        Month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        MonthName = new JButton(cal.get(Calendar.YEAR) + " . " + Month);

        addMouseListener(this);
        add(MonthName, BorderLayout.NORTH);
        add(CalScrollPane, BorderLayout.CENTER);
        p.add(Btn_Next);
        p.add(Btn_Prev);
        p.add(Btn_Enter);
        add(p, BorderLayout.SOUTH);

        super.setTitle("달력");
        setBounds(1110,0,0,0);
        setVisible(true);
        pack();
    }

    //달력에서 날짜 얻어오고 텍스트필드에 세팅 이벤트 처리
    @Override
    public void mouseClicked(MouseEvent e) {

        int rowIndex = calTable.getSelectedRow();
        int colIndex = calTable.getSelectedColumn();
        String mydate = MonthName.getText();
        DATE = mydate +  " . " + calTable.getValueAt(rowIndex, colIndex);
        MainFrame.setTf_Date(DATE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //버튼 클릭액션 이벤트
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.equals(Btn_Next.getText())) {
            dispose();
            new Frame_Calander(-1);
        } else if (command.equals(Btn_Prev.getText())) {

            dispose();
            new Frame_Calander(1);

        } else
            dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
