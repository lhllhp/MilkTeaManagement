/*
 * Created by JFormDesigner on Sun Oct 14 22:26:58 ICT 2018
 */

package view;

import Entity.NhanVien;
import com.jgoodies.forms.factories.*;
import dao.NhanVienDAO;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author Admin
 */
public class ViewTableNhanVien extends JFrame {
    public ViewTableNhanVien() {
        initComponents();
    }

    private void btnFillDataActionPerformed(ActionEvent e) {
        getData();
    }
    private void getData(){
        NhanVienDAO dao = new NhanVienDAO();
        DefaultTableModel model = new DefaultTableModel(); //kẻ cột hàng
        model.addColumn("Mã NV");
        model.addColumn("Tên NV");
        model.addColumn("Ca");
        model.addColumn("SĐT");
        model.addColumn("Lương");
        model.addColumn("Thưởng");

        for (NhanVien nv : dao.selectNV()){
            model.addRow(new Object[]{
                    nv.getMaNV(), nv.getTen(), nv.getCa(), nv.getSdt(), nv.getLuong(), nv.getThuong()
            });
        }
        tableNV.setModel(model);
    }

    private void txtSearchKeyReleased(KeyEvent e) {
        String str = txtSearch.getText();
        DefaultRowSorter<?,?> sorter = (DefaultRowSorter<?, ?>) tableNV.getRowSorter();
        sorter.setRowFilter(RowFilter.regexFilter(str));//điều kiện
        sorter.setSortKeys(null);//trả về null
    }

    private void tableNVMouseClicked(MouseEvent e) {
        int indexRow = tableNV.getSelectedRow();
        txtMaNV.setText(tableNV.getValueAt(indexRow,0).toString());
        txtTen.setText(tableNV.getValueAt(indexRow,1).toString());
        chCa.setSelected(Boolean.parseBoolean(tableNV.getValueAt(indexRow,2).toString()));
        txtSdt.setText(tableNV.getValueAt(indexRow,3).toString());
        txtLuong.setText(tableNV.getValueAt(indexRow, 4).toString());
        txtThuong.setText(tableNV.getValueAt(indexRow,5).toString());
    }

    private void btnInsertActionPerformed(ActionEvent e) {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        nv.setTen(txtTen.getText());
        nv.setCa(chCa.isSelected());
        nv.setSdt(txtSdt.getText());
        nv.setLuong(Integer.parseInt(txtLuong.getText()));
        nv.setThuong(Integer.parseInt(txtThuong.getText()));
        dao.insertNV(nv);
        getData();
    }

    private void btnUpDateActionPerformed(ActionEvent e) {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        nv.setMaNV(Integer.parseInt(txtMaNV.getText()));
        nv.setTen(txtTen.getText());
        nv.setCa(chCa.isSelected());
        nv.setSdt(txtSdt.getText());
        nv.setLuong(Integer.parseInt(txtLuong.getText()));
        nv.setThuong(Integer.parseInt(txtThuong.getText()));
        dao.suaNV(nv);
        getData();
    }

    private void btnDeleteActionPerformed(ActionEvent e) {
       NhanVienDAO dao = new NhanVienDAO();
        dao.deleteNV(Integer.parseInt(
                tableNV.getValueAt(tableNV.getSelectedRow(),0).toString()
        ));
        getData();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        scrollPane1 = new JScrollPane();
        tableNV = new JTable();
        btnFillData = new JButton();
        txtSearch = new JTextField();
        title1 = compFactory.createTitle("T\u00ecm");
        panel1 = new JPanel();
        txtMaNV = new JTextField();
        txtSdt = new JTextField();
        txtThuong = new JTextField();
        txtTen = new JTextField();
        txtLuong = new JTextField();
        title2 = compFactory.createTitle("M\u00e3 NV");
        title3 = compFactory.createTitle("T\u00ean NV");
        title5 = compFactory.createTitle("Ca");
        title6 = compFactory.createTitle("S\u0110T");
        title7 = compFactory.createTitle("L\u01b0\u01a1ng");
        title8 = compFactory.createTitle("Th\u01b0\u1edfng");
        chCa = new JCheckBox();
        btnInsert = new JButton();
        btnUpDate = new JButton();
        btnDelete = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tableNV ----
            tableNV.setAutoCreateRowSorter(true);
            tableNV.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tableNVMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tableNV);
        }

        //---- btnFillData ----
        btnFillData.setText("Xem b\u1ea3ng Nh\u00e2n Vi\u00ean");
        btnFillData.setBackground(new Color(51, 255, 51));
        btnFillData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFillDataActionPerformed(e);
            }
        });

        //---- txtSearch ----
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtSearchKeyReleased(e);
            }
        });

        //======== panel1 ========
        {

            //---- txtMaNV ----
            txtMaNV.setEnabled(false);

            //---- chCa ----
            chCa.setText("1/2");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(chCa))
                        .addGap(110, 110, 110)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(title6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(txtLuong, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(title8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtThuong, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(90, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(title2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(title6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(title3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(title7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(title8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(chCa)))
                        .addGap(0, 59, Short.MAX_VALUE))
            );
        }

        //---- btnInsert ----
        btnInsert.setText("Th\u00eam NV");
        btnInsert.setBackground(new Color(255, 204, 0));
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnInsertActionPerformed(e);
            }
        });

        //---- btnUpDate ----
        btnUpDate.setText("C\u1eadp Nh\u1eadt");
        btnUpDate.setBackground(new Color(255, 204, 0));
        btnUpDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpDateActionPerformed(e);
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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(96, Short.MAX_VALUE)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 725, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnFillData)
                                    .addGap(49, 49, 49)
                                    .addComponent(title1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(btnInsert)
                            .addGap(44, 44, 44)
                            .addComponent(btnUpDate)
                            .addGap(40, 40, 40)
                            .addComponent(btnDelete)))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(btnFillData)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(title1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsert)
                        .addComponent(btnUpDate)
                        .addComponent(btnDelete))
                    .addContainerGap(118, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tableNV;
    private JButton btnFillData;
    private JTextField txtSearch;
    private JLabel title1;
    private JPanel panel1;
    private JTextField txtMaNV;
    private JTextField txtSdt;
    private JTextField txtThuong;
    private JTextField txtTen;
    private JTextField txtLuong;
    private JLabel title2;
    private JLabel title3;
    private JLabel title5;
    private JLabel title6;
    private JLabel title7;
    private JLabel title8;
    private JCheckBox chCa;
    private JButton btnInsert;
    private JButton btnUpDate;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ViewTableNhanVien view = new ViewTableNhanVien();
                    view.setVisible(true);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage()); //JOptionPane giống alert
                }
            }
        });
    }
}
