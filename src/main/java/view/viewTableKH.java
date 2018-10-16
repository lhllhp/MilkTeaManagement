/*
 * Created by JFormDesigner on Tue Oct 16 22:30:18 ICT 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import Entity.KhachHang;
import Entity.NhanVien;
import com.jgoodies.forms.factories.*;
import dao.KhachHangDAO;
import dao.NhanVienDAO;

/**
 * @author Admin
 */
public class viewTableKH extends JFrame {
    public viewTableKH() {
        initComponents();
    }

    private void btnSelectActionPerformed(ActionEvent e) {
        getData();
    }
    private void getData(){
        KhachHangDAO dao = new KhachHangDAO();
        DefaultTableModel model = new DefaultTableModel(); //kẻ cột hàng
        model.addColumn("Mã KH");
        model.addColumn("SĐT");
        model.addColumn("Điểm");
        for (KhachHang kh : dao.selectKH()){
            model.addRow(new Object[]{
                    kh.getMaKhachHang(), kh.getSdt(), kh.getDiem()
            });
        }
        tableKH.setModel(model);
    }

    private void tableKHMouseClicked(MouseEvent e) {
        int indexRow = tableKH.getSelectedRow();
        txtMaKH.setText(tableKH.getValueAt(indexRow,0).toString());
        txtSDT.setText(tableKH.getValueAt(indexRow,1).toString());
        txtDiem.setText(tableKH.getValueAt(indexRow,2).toString());
    }

    private void txtSearchKeyReleased(KeyEvent e) {
        String str = txtSearch.getText();
        DefaultRowSorter<?,?> sorter = (DefaultRowSorter<?, ?>) tableKH.getRowSorter();
        sorter.setRowFilter(RowFilter.regexFilter(str));//điều kiện
        sorter.setSortKeys(null);//trả về null
    }

    private void tableKHKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void btnInsertActionPerformed(ActionEvent e) {
        KhachHangDAO dao = new KhachHangDAO();
        KhachHang kh = new KhachHang();
        kh.setSdt(txtSDT.getText());
        kh.setDiem(Integer.parseInt(txtDiem.getText()));
        dao.insertKH(kh);
        getData();
    }

    private void btnUpdateActionPerformed(ActionEvent e) {
        KhachHangDAO dao = new KhachHangDAO();
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(Integer.parseInt(txtMaKH.getText()));
        kh.setSdt(txtSDT.getText());
        kh.setDiem(Integer.parseInt(txtDiem.getText()));
        dao.suaKH(kh);
        getData();
    }

    private void btnDeleteActionPerformed(ActionEvent e) {
        KhachHangDAO dao = new KhachHangDAO();
        dao.xoaKH(Integer.parseInt(tableKH.getValueAt(tableKH.getSelectedRow(),0).toString()));
        getData();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        tableKH = new JTable();
        btnSelect = new JButton();
        txtSearch = new JTextField();
        txtMaKH = new JTextField();
        txtDiem = new JTextField();
        title1 = compFactory.createTitle("M\u00e3 KH");
        title2 = compFactory.createTitle("S\u0110T");
        title3 = compFactory.createTitle("\u0110i\u1ec3m");
        btnInsert = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        txtSDT = new JTextField();
        title4 = compFactory.createTitle("T\u00ecm ki\u1ebfm");

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tableKH ----
            tableKH.setAutoCreateRowSorter(true);
            tableKH.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tableKHKeyReleased(e);
                }
            });
            tableKH.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tableKHMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tableKH);
        }

        //---- btnSelect ----
        btnSelect.setText("Xem b\u1ea3ng Kh\u00e1ch H\u00e0ng");
        btnSelect.setBackground(new Color(255, 204, 0));
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSelectActionPerformed(e);
            }
        });

        //---- txtSearch ----
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtSearchKeyReleased(e);
            }
        });

        //---- txtMaKH ----
        txtMaKH.setEnabled(false);

        //---- btnInsert ----
        btnInsert.setText("Th\u00eam KH");
        btnInsert.setBackground(new Color(255, 204, 0));
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnInsertActionPerformed(e);
            }
        });

        //---- btnUpdate ----
        btnUpdate.setText("C\u1eadp Nh\u1eadt");
        btnUpdate.setBackground(new Color(255, 204, 0));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateActionPerformed(e);
            }
        });

        //---- btnDelete ----
        btnDelete.setText("X\u00f3a");
        btnDelete.setBackground(new Color(255, 204, 0));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnInsert)
                            .addGap(71, 71, 71)
                            .addComponent(btnUpdate)
                            .addGap(67, 67, 67)
                            .addComponent(btnDelete)
                            .addGap(0, 325, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiem, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                            .addContainerGap(472, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                    .addGap(18, 18, 18))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnSelect)
                                    .addGap(32, 32, 32)
                                    .addComponent(title4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(41, 41, 41)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(78, 78, 78)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsert)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete))
                    .addContainerGap(137, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tableKH;
    private JButton btnSelect;
    private JTextField txtSearch;
    private JTextField txtMaKH;
    private JTextField txtDiem;
    private JLabel title1;
    private JLabel title2;
    private JLabel title3;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JTextField txtSDT;
    private JLabel title4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    viewTableKH view = new viewTableKH();
                    view.setVisible(true);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage()); //JOptionPane giống alert
                }
            }
        });
    }
}
