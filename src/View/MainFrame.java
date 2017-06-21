/*
    회비관리 프로그램 메인 프레임
*/


package View;

import BackGround.EventManagerDAO;
import BackGround.MemberDAO;
import BackGround.MemberDTO;
import BackGround.MfsDAO;
import BackGround.MfsDTO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class MainFrame extends javax.swing.JFrame {

    MfsDAO dao_mfs = new MfsDAO();
    MemberDAO dao_member = new MemberDAO();
    EventManagerDAO dao_eventmanager = new EventManagerDAO();

    public MainFrame() {
        initComponents();
        tableRefresh_EventTable();
        tableRefresh_MemberTable();
        tableRefresh_MfsTable(dao_mfs.getMfsList());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTabbedPane = new javax.swing.JTabbedPane();
        Panel_PayManager = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Tf_Date = new javax.swing.JTextField();
        Tf_Price = new javax.swing.JTextField();
        Tf_Event = new javax.swing.JTextField();
        Tf_Name = new javax.swing.JTextField();
        Tf_Payment = new javax.swing.JTextField();
        Tf_Remarks = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        MsfTable = new javax.swing.JTable();
        FrameCall_Calander = new javax.swing.JButton();
        Btn_Enter_Mfs = new javax.swing.JButton();
        Btn_Reset_Mfs = new javax.swing.JButton();
        Btn_Update_Mfs = new javax.swing.JButton();
        Btn_Delete_Mfs = new javax.swing.JButton();
        Label_SearchMember_Mfs = new javax.swing.JLabel();
        Tf_SearchMember_Mfs = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Tf_AllMoney = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Tf_PresentMoney = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Tf_NotPaymoney = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        NotPaymentAll_Mfs = new javax.swing.JLabel();
        Tf_NotPayMoney_Mfs = new javax.swing.JTextField();
        Btn_SearchMember_Mfs = new javax.swing.JButton();
        Btn_TableRefrash_Mfs = new javax.swing.JButton();
        Panel_MemberManager = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MemberTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        TF_StudentId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Tf_Department = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Tf_Name_Mem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Tf_Phone = new javax.swing.JTextField();
        javax.swing.JButton Btn_Enter_Mem = new javax.swing.JButton();
        Btn_Update_Mem = new javax.swing.JButton();
        Btn_Delete_Mem = new javax.swing.JButton();
        Btn_Reset_Mem = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        TF_OldStudent = new javax.swing.JTextField();
        TF_NewStudent = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TF_AllStudent = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Panel_EventManager = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        EventTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("날      짜");

        jLabel2.setText("행      사");

        jLabel3.setText("금      액");

        jLabel4.setText("이      름");

        jLabel5.setText("납부금액");

        jLabel7.setText("비      고");

        Tf_Date.setEditable(false);
        Tf_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_DateActionPerformed(evt);
            }
        });

        Tf_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_PriceActionPerformed(evt);
            }
        });

        Tf_Event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_EventActionPerformed(evt);
            }
        });

        Tf_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_NameActionPerformed(evt);
            }
        });

        Tf_Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_PaymentActionPerformed(evt);
            }
        });

        Tf_Remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_RemarksActionPerformed(evt);
            }
        });

        MsfTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "날짜", "이름", "행사", "금액", "납부금액", "미납금액", "비고"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MsfTable.getTableHeader().setResizingAllowed(false);
        MsfTable.getTableHeader().setReorderingAllowed(false);
        MsfTable.getTableHeader().setReorderingAllowed(false);
        MsfTable.getTableHeader().setResizingAllowed(false);
        MsfTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MsfTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(MsfTable);

        FrameCall_Calander.setText("달력");
        FrameCall_Calander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrameCall_CalanderActionPerformed(evt);
            }
        });

        Btn_Enter_Mfs.setText("입력");
        Btn_Enter_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Enter_MfsActionPerformed(evt);
            }
        });

        Btn_Reset_Mfs.setText("초기화");
        Btn_Reset_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Reset_MfsActionPerformed(evt);
            }
        });

        Btn_Update_Mfs.setText("수정");
        Btn_Update_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Update_MfsActionPerformed(evt);
            }
        });

        Btn_Delete_Mfs.setText("삭제");
        Btn_Delete_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Delete_MfsActionPerformed(evt);
            }
        });

        Label_SearchMember_Mfs.setText("회원검색");

        Tf_SearchMember_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_SearchMember_MfsActionPerformed(evt);
            }
        });

        jLabel12.setText("전체잔액");

        Tf_AllMoney.setEditable(false);
        Tf_AllMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_AllMoneyActionPerformed(evt);
            }
        });

        jLabel17.setText("현재잔액");

        Tf_PresentMoney.setEditable(false);
        Tf_PresentMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_PresentMoneyActionPerformed(evt);
            }
        });

        jLabel19.setText("미납총액");

        Tf_NotPaymoney.setEditable(false);
        Tf_NotPaymoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_NotPaymoneyActionPerformed(evt);
            }
        });

        NotPaymentAll_Mfs.setText("미납총액");

        Tf_NotPayMoney_Mfs.setEditable(false);
        Tf_NotPayMoney_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_NotPayMoney_MfsActionPerformed(evt);
            }
        });

        Btn_SearchMember_Mfs.setText("검색");
        Btn_SearchMember_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SearchMember_MfsActionPerformed(evt);
            }
        });

        Btn_TableRefrash_Mfs.setText("새로고침");
        Btn_TableRefrash_Mfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TableRefrash_MfsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PayManagerLayout = new javax.swing.GroupLayout(Panel_PayManager);
        Panel_PayManager.setLayout(Panel_PayManagerLayout);
        Panel_PayManagerLayout.setHorizontalGroup(
            Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PayManagerLayout.createSequentialGroup()
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Tf_Remarks, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tf_Payment, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tf_Name, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tf_Price, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tf_Event))
                                .addGap(64, 64, 64))
                            .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                                .addComponent(Tf_Date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FrameCall_Calander)))
                        .addContainerGap())
                    .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                        .addComponent(Btn_Enter_Mfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Update_Mfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Delete_Mfs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Reset_Mfs)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tf_NotPaymoney))
                        .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tf_PresentMoney))
                        .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tf_AllMoney))
                        .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Label_SearchMember_Mfs)
                                .addComponent(NotPaymentAll_Mfs))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Tf_NotPayMoney_Mfs, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(Tf_SearchMember_Mfs))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Btn_TableRefrash_Mfs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_SearchMember_Mfs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap()))))
            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PayManagerLayout.createSequentialGroup()
                    .addContainerGap(836, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(216, 216, 216)))
        );
        Panel_PayManagerLayout.setVerticalGroup(
            Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tf_AllMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tf_PresentMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tf_NotPaymoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_SearchMember_Mfs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tf_SearchMember_Mfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_SearchMember_Mfs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tf_NotPayMoney_Mfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NotPaymentAll_Mfs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_TableRefrash_Mfs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tf_Event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tf_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tf_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tf_Remarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tf_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FrameCall_Calander)))
                        .addGap(44, 44, 44)
                        .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Enter_Mfs)
                            .addComponent(Btn_Reset_Mfs)
                            .addComponent(Btn_Update_Mfs)
                            .addComponent(Btn_Delete_Mfs)))
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(Panel_PayManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_PayManagerLayout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
        );

        JTabbedPane.addTab("회비관리", Panel_PayManager);
        Panel_PayManager.getAccessibleContext().setAccessibleName("회비관리");
        Panel_PayManager.getAccessibleContext().setAccessibleDescription("");

        MemberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "학번", "이름", "학과", "전화번호"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MemberTable.getTableHeader().setResizingAllowed(false);
        MemberTable.getTableHeader().setReorderingAllowed(false);
        MemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MemberTable);

        jLabel6.setText("학      번");

        TF_StudentId.setText("숫자입력");
        TF_StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_StudentIdActionPerformed(evt);
            }
        });

        jLabel8.setText("학      과");

        Tf_Department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_DepartmentActionPerformed(evt);
            }
        });

        jLabel9.setText("이      름");

        jLabel10.setText("전화번호");

        Tf_Phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tf_PhoneActionPerformed(evt);
            }
        });

        Btn_Enter_Mem.setText("입력");
        Btn_Enter_Mem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Enter_MemActionPerformed(evt);
            }
        });

        Btn_Update_Mem.setText("수정");
        Btn_Update_Mem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Update_MemActionPerformed(evt);
            }
        });

        Btn_Delete_Mem.setText("삭제");
        Btn_Delete_Mem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Delete_MemActionPerformed(evt);
            }
        });

        Btn_Reset_Mem.setText("초기화");
        Btn_Reset_Mem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Reset_MemActionPerformed(evt);
            }
        });

        jLabel21.setText("재 학 생");

        TF_OldStudent.setEditable(false);
        TF_OldStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_OldStudentActionPerformed(evt);
            }
        });

        TF_NewStudent.setEditable(false);
        TF_NewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NewStudentActionPerformed(evt);
            }
        });

        jLabel22.setText("신 입 생");

        TF_AllStudent.setEditable(false);
        TF_AllStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_AllStudentActionPerformed(evt);
            }
        });

        jLabel23.setText("총     원");

        javax.swing.GroupLayout Panel_MemberManagerLayout = new javax.swing.GroupLayout(Panel_MemberManager);
        Panel_MemberManager.setLayout(Panel_MemberManagerLayout);
        Panel_MemberManagerLayout.setHorizontalGroup(
            Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                        .addComponent(Btn_Enter_Mem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Update_Mem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Delete_Mem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Reset_Mem))
                    .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_MemberManagerLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tf_Department))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_MemberManagerLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TF_StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_OldStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_NewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_AllStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                        .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tf_Phone)
                            .addComponent(Tf_Name_Mem))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Panel_MemberManagerLayout.setVerticalGroup(
            Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MemberManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MemberManagerLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_OldStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_NewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_AllStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf_Department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf_Name_Mem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(Panel_MemberManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Enter_Mem)
                    .addComponent(Btn_Reset_Mem)
                    .addComponent(Btn_Update_Mem)
                    .addComponent(Btn_Delete_Mem))
                .addGap(113, 113, 113))
        );

        JTabbedPane.addTab("회원관리", Panel_MemberManager);

        EventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "날짜", "행사", "참여인원", "회비총액", "미납총액"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EventTable.getTableHeader().setResizingAllowed(false);
        EventTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(EventTable);

        javax.swing.GroupLayout Panel_EventManagerLayout = new javax.swing.GroupLayout(Panel_EventManager);
        Panel_EventManager.setLayout(Panel_EventManagerLayout);
        Panel_EventManagerLayout.setHorizontalGroup(
            Panel_EventManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EventManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        Panel_EventManagerLayout.setVerticalGroup(
            Panel_EventManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EventManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedPane.addTab("행사관리", Panel_EventManager);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabbedPane)
                .addContainerGap())
        );

        JTabbedPane.getAccessibleContext().setAccessibleName("");
        JTabbedPane.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_AllStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_AllStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_AllStudentActionPerformed

    private void TF_NewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NewStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NewStudentActionPerformed

    private void TF_OldStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_OldStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_OldStudentActionPerformed

    //회원목록 초기화 버튼 액션이벤트
    private void Btn_Reset_MemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Reset_MemActionPerformed
        setNullData_Member();
    }//GEN-LAST:event_Btn_Reset_MemActionPerformed

    //회원목록 삭제버튼 액션이벤트
    private void Btn_Delete_MemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Delete_MemActionPerformed

        MemberDAO dao = new MemberDAO();
        boolean ok = dao.deleteMember(getTfDataToMember());

        if (ok) {
            JOptionPane.showMessageDialog(this, "회원 삭제 성공");
            setNullData_Member();
            tableRefresh_MemberTable();
        } else {
            JOptionPane.showMessageDialog(this, "회원 삭제 실패");
        }
    }//GEN-LAST:event_Btn_Delete_MemActionPerformed

    //회원정보 수정 버튼 액션이벤트
    private void Btn_Update_MemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Update_MemActionPerformed
        MemberDAO dao = new MemberDAO();
        boolean ok = dao.updateMember(getTfDataToMember());

        if (ok) {
            JOptionPane.showMessageDialog(this, "회원정보 수정 성공");
            setNullData_Member();
            tableRefresh_MemberTable();
        } else {
            JOptionPane.showMessageDialog(this, "회원정보 수정 실패");
        }
    }//GEN-LAST:event_Btn_Update_MemActionPerformed

    // 회원목록 입력버튼 액션이벤트
    private void Btn_Enter_MemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Enter_MemActionPerformed

        MemberDAO dao = new MemberDAO();
        boolean ok = dao.insertMember(getTfDataToMember());
        if (ok) {

            JOptionPane.showMessageDialog(this, "회원 추가 성공");
            setNullData_Member();
            tableRefresh_MemberTable();
        } else {
            JOptionPane.showMessageDialog(this, "학번에 숫자를 입력해주세요");
        }
    }//GEN-LAST:event_Btn_Enter_MemActionPerformed

    private void Tf_PhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_PhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_PhoneActionPerformed

    private void Tf_DepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_DepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_DepartmentActionPerformed

    private void TF_StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_StudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_StudentIdActionPerformed

    //-------------테이블 클릭시 회원 정보 세팅 이벤트
    private void MemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberTableMouseClicked

        int r = MemberTable.getSelectedRow();
        String id = Integer.toString((int) MemberTable.getValueAt(r, 0));
        String department = (String) MemberTable.getValueAt(r, 2);
        String name_Mem = (String) MemberTable.getValueAt(r, 1);
        String phone = (String) MemberTable.getValueAt(r, 3);

        TF_StudentId.setText(id);
        Tf_Department.setText(department);
        Tf_Name_Mem.setText(name_Mem);
        Tf_Phone.setText(phone);
    }//GEN-LAST:event_MemberTableMouseClicked

    //새로고침 버튼 이벤트
    private void Btn_TableRefrash_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TableRefrash_MfsActionPerformed

        tableRefresh_MfsTable(dao_mfs.getMfsList());
        Tf_NotPayMoney_Mfs.setText("");
        Tf_SearchMember_Mfs.setText("");
    }//GEN-LAST:event_Btn_TableRefrash_MfsActionPerformed

    //회원 이름으로 검색하는 버튼 이벤트
    private void Btn_SearchMember_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SearchMember_MfsActionPerformed

        tableRefresh_MfsTable(dao_mfs.getMfsListByMember(Tf_SearchMember_Mfs.getText()));
    }//GEN-LAST:event_Btn_SearchMember_MfsActionPerformed

    private void Tf_NotPayMoney_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_NotPayMoney_MfsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_NotPayMoney_MfsActionPerformed

    private void Tf_NotPaymoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_NotPaymoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_NotPaymoneyActionPerformed

    private void Tf_PresentMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_PresentMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_PresentMoneyActionPerformed

    private void Tf_AllMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_AllMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_AllMoneyActionPerformed

    private void Tf_SearchMember_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_SearchMember_MfsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_SearchMember_MfsActionPerformed

    //회비관리 내용삭제 버튼 액션
    private void Btn_Delete_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Delete_MfsActionPerformed

        MfsDAO dao = new MfsDAO();
        boolean ok = dao.deleteMfs(getTfDataToMfs());

        if (ok) {
            JOptionPane.showMessageDialog(this, "회비내용 삭제 성공");
            setNullData_Mfs();
            tableRefresh_MfsTable(dao.getMfsList());
        } else {
            JOptionPane.showMessageDialog(this, "회비내용 삭제 실패");
        }
    }//GEN-LAST:event_Btn_Delete_MfsActionPerformed

    //회비관리 내용 수정 액션
    private void Btn_Update_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Update_MfsActionPerformed

        MfsDAO dao = new MfsDAO();
        boolean ok = dao.updateMfs(getTfDataToMfs());

        if (ok) {
            JOptionPane.showMessageDialog(this, "회비내용 수정 성공");
            setNullData_Mfs();
            tableRefresh_MfsTable(dao.getMfsList());
        } else {
            JOptionPane.showMessageDialog(this, "납부금액과 비고만 수정이 가능합니다");
        }
    }//GEN-LAST:event_Btn_Update_MfsActionPerformed

    //회비관리 초기화 버튼 액션리스너
    private void Btn_Reset_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Reset_MfsActionPerformed
        setNullData_Mfs();
    }//GEN-LAST:event_Btn_Reset_MfsActionPerformed

    //회비관리 회비입력 버튼 액션이벤트
    private void Btn_Enter_MfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Enter_MfsActionPerformed
        MfsDAO dao = new MfsDAO();

        boolean ok = dao.insertMfs(getTfDataToMfs());

        if (ok) {
            JOptionPane.showMessageDialog(this, "입력 성공");
            setNullData_Mfs();
            tableRefresh_MfsTable(dao.getMfsList());
        } else {
            JOptionPane.showMessageDialog(this, "회원이 없습니다");
        }
    }//GEN-LAST:event_Btn_Enter_MfsActionPerformed

    //달력 프레임 호출
    private void FrameCall_CalanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrameCall_CalanderActionPerformed

        Frame_Calander frame_Calander = new Frame_Calander(0);
    }//GEN-LAST:event_FrameCall_CalanderActionPerformed

    // 회비관리 마우스 클릭 이벤트
    private void MsfTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MsfTableMouseClicked

        int r = MsfTable.getSelectedRow();

        String date = (String) MsfTable.getValueAt(r, 0);
        String membername = (String) MsfTable.getValueAt(r, 1);
        String event = (String) MsfTable.getValueAt(r, 2);
        String price = Integer.toString((int) MsfTable.getValueAt(r, 3));
        String payment = Integer.toString((int) MsfTable.getValueAt(r, 4));
        String remarks = (String) MsfTable.getValueAt(r, 6);

        Tf_Date.setText(date);
        Tf_Name.setText(membername);
        Tf_Event.setText(event);
        Tf_Price.setText(price);
        Tf_Payment.setText(payment);
        Tf_Remarks.setText(remarks);
    }//GEN-LAST:event_MsfTableMouseClicked

    private void Tf_RemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_RemarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_RemarksActionPerformed

    private void Tf_PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_PaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_PaymentActionPerformed

    private void Tf_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_NameActionPerformed

    private void Tf_EventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_EventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_EventActionPerformed

    private void Tf_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_PriceActionPerformed

    private void Tf_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tf_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tf_DateActionPerformed

    //-----------------컬럼 헤드 읽어와서 테이블 헤드생성--------
     public Vector getColumn_EventTable() {
        // 행사관리 테이블
        Vector col = new Vector();

        for (int i = 0; i < EventTable.getColumnCount(); i++) {
            col.add(EventTable.getColumnName(i));
        }
        return col;
    }
     
    public Vector getColumn_MemberTable() {
        // 멤버 테이블
        Vector col = new Vector();

        for (int i = 0; i < MemberTable.getColumnCount(); i++) {
            col.add(MemberTable.getColumnName(i));
        }
        return col;
    }

    public Vector getColumn_MsfTable() {
        // 회비관리 테이블
        Vector col = new Vector();

        for (int i = 0; i < MsfTable.getColumnCount(); i++) {
            col.add(MsfTable.getColumnName(i));
        }
        return col;
    }
    // --------------------------------------------------------

    //------------- 테이블 새로고침-----------------------
    public void tableRefresh_EventTable() {
        // 행사관리 테이블

        DefaultTableModel model = new DefaultTableModel(dao_eventmanager.getEventIfon(), getColumn_EventTable());
        EventTable.setModel(model);
        
    }
    public void tableRefresh_MemberTable() {
        // 멤버 테이블

        DefaultTableModel model = new DefaultTableModel(dao_member.getMemberList(), getColumn_MemberTable());
        MemberTable.setModel(model);
        
    }

    public void tableRefresh_MfsTable(Vector vv) {
        // 회비관리 테이블
//        MfsDAO dao = new MfsDAO();
        DefaultTableModel model = new DefaultTableModel(vv, getColumn_MsfTable());
        MsfTable.setModel(model);

        tableRefresh_EventTable();
        
        Vector v = dao_mfs.getMfsSelectMoney();

        Tf_AllMoney.setText(String.format("%,10d", v.get(0)) + "원");
        Tf_PresentMoney.setText(String.format("%,10d", v.get(1)) + "원");
        Tf_NotPaymoney.setText(String.format("%,10d", v.get(2)) + "원");

    }
    //------------------------------------------------

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame f = new MainFrame();
            
            f.setTitle("회비관리 프로그램");
            f.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete_Mem;
    private javax.swing.JButton Btn_Delete_Mfs;
    private javax.swing.JButton Btn_Enter_Mfs;
    private javax.swing.JButton Btn_Reset_Mem;
    private javax.swing.JButton Btn_Reset_Mfs;
    private javax.swing.JButton Btn_SearchMember_Mfs;
    private javax.swing.JButton Btn_TableRefrash_Mfs;
    private javax.swing.JButton Btn_Update_Mem;
    private javax.swing.JButton Btn_Update_Mfs;
    private javax.swing.JTable EventTable;
    private javax.swing.JButton FrameCall_Calander;
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JLabel Label_SearchMember_Mfs;
    private javax.swing.JTable MemberTable;
    private javax.swing.JTable MsfTable;
    private javax.swing.JLabel NotPaymentAll_Mfs;
    private javax.swing.JPanel Panel_EventManager;
    public static javax.swing.JPanel Panel_MemberManager;
    private javax.swing.JPanel Panel_PayManager;
    public static javax.swing.JTextField TF_AllStudent;
    public static javax.swing.JTextField TF_NewStudent;
    public static javax.swing.JTextField TF_OldStudent;
    private javax.swing.JTextField TF_StudentId;
    private javax.swing.JTextField Tf_AllMoney;
    public static javax.swing.JTextField Tf_Date;
    private javax.swing.JTextField Tf_Department;
    private javax.swing.JTextField Tf_Event;
    private javax.swing.JTextField Tf_Name;
    private javax.swing.JTextField Tf_Name_Mem;
    public static javax.swing.JTextField Tf_NotPayMoney_Mfs;
    private javax.swing.JTextField Tf_NotPaymoney;
    private javax.swing.JTextField Tf_Payment;
    private javax.swing.JTextField Tf_Phone;
    private javax.swing.JTextField Tf_PresentMoney;
    private javax.swing.JTextField Tf_Price;
    private javax.swing.JTextField Tf_Remarks;
    public static javax.swing.JTextField Tf_SearchMember_Mfs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    //날짜텍스트 필드에 날짜 세팅 메소드
    //Frame_Calander 에서 사용 - 날자 세팅할때
    public static void setTf_Date(String str) {
        MainFrame.Tf_Date.setText(str);
    }

    //---------------------텍스트필드 내용을  dto에 저장
    public MemberDTO getTfDataToMember() {
        // MemberDTO
        MemberDTO dto = new MemberDTO();

        String id = TF_StudentId.getText();
        String department = Tf_Department.getText();
        String name = Tf_Name_Mem.getText();
        String phone = Tf_Phone.getText();
        String year = TF_StudentId.getText().substring(0, 4);

        dto.setStudent_id(Integer.parseInt(id));
        dto.setDepartment(department);
        dto.setName(name);
        dto.setPhone(phone);
        dto.setYear(Integer.parseInt(year));

        return dto;
    }

    public MfsDTO getTfDataToMfs() {
        // MfsDTO
        MfsDTO dto = new MfsDTO();

        String mydate = Tf_Date.getText();
        String membername = Tf_Name.getText();
        String memo = Tf_Event.getText();
        String price = Tf_Price.getText();
        String payment = Tf_Payment.getText();
        String notpayment = Integer.toString(Integer.parseInt(price) - Integer.parseInt(payment));
        String remarks = Tf_Remarks.getText();

        dto.setMydate(mydate);
        dto.setMembername(membername);
        dto.setMemo(memo);
        dto.setPrice(Integer.parseInt(price));
        dto.setPaymoney(Integer.parseInt(payment));
        dto.setNotpaymoney(Integer.parseInt(notpayment));
        dto.setRemarks(remarks);

        return dto;
    }

    //------------------------------------------------------
    //-------------------------------------텍스트필드 초기화
    public void setNullData_Member() {
        //회원목록
        TF_StudentId.setText("숫자입력");
        Tf_Department.setText("");
        Tf_Name_Mem.setText("");
        Tf_Phone.setText("");
    }

    public void setNullData_Mfs() {
        //회비목록
        Tf_Date.setText("");
        Tf_Name.setText("");
        Tf_Event.setText("");
        Tf_Price.setText("");
        Tf_Payment.setText("");
        Tf_Remarks.setText("");
    }
    //---------------------------------------------
}
