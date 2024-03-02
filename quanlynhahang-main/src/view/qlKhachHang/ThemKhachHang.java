/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.qlKhachHang;

import controller.KhachHangDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.KhachHang;

/**
 *
 * @author hung
 */
public class ThemKhachHang extends javax.swing.JDialog {

    QLKhachHang father;

    /**
     * Creates new form ThemKH
     */
    public ThemKhachHang(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        this.father = (QLKhachHang) parent;
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private boolean checkEmpty() {
        if (txtHo.getText().isBlank() || txtTen.getText().isBlank() || txtSdt.getText().isBlank()
                || txtQuanHuyen.getText().isBlank() || txtTinhTp.getText().isBlank()) {
            return true;
        }
        return false;
    }

    private boolean checkValid() {
        String[] w = txtSdt.getText().replace("\\s+", "").split(",");
        for (String sdt : w) {
            if (!sdt.matches("^(0)(3|5|7|8|9)([0-9]{8})$")) {
                JOptionPane.showMessageDialog(this, "Nhập số điện thoại có 10 chữ số,\n bắt đầu bằng 03, 05, 07, 08, 09",
                        "Lỗi định dạng", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        String s = txtHo.getText() + txtTenDem.getText() + txtTen.getText();
        if (!s.matches("^([a-zA-Zàáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý"
                + "ÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ\\s\\/]+)$")) {
            JOptionPane.showMessageDialog(rootPane, "Kiểm tra lại định dạng họ tên",
                    "Lỗi định dạng", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHo = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        lblTenDem = new javax.swing.JLabel();
        txtTenDem = new javax.swing.JTextField();
        lblTen = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        lblSdt = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        lblSoNha = new javax.swing.JLabel();
        txtSoNha = new javax.swing.JTextField();
        lblDuong = new javax.swing.JLabel();
        txtDuong = new javax.swing.JTextField();
        lblQuanHuyen = new javax.swing.JLabel();
        txtQuanHuyen = new javax.swing.JTextField();
        lblTinhTP = new javax.swing.JLabel();
        txtTinhTp = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm khách hàng");

        lblHo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblHo.setText("Họ*");

        txtHo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTenDem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenDem.setText("Tên đệm");

        txtTenDem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTen.setText("Tên*");

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSdt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSdt.setText("SĐT*");

        txtSdt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSoNha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoNha.setText("Số nhà");

        txtSoNha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblDuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDuong.setText("Đường");

        txtDuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblQuanHuyen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblQuanHuyen.setText("Quận/Huyện*");

        txtQuanHuyen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTinhTP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTinhTP.setText("Tỉnh/Thành phố*");

        txtTinhTp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 224, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuanHuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoNha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTinhTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenDem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtQuanHuyen, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDuong, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtSoNha, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTinhTp, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHo)
                                .addComponent(txtTenDem)
                                .addComponent(txtTen)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHo)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenDem)
                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTen)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSdt)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoNha)
                    .addComponent(txtSoNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuong)
                    .addComponent(txtDuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuanHuyen)
                    .addComponent(txtQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTinhTP)
                    .addComponent(txtTinhTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnHuy))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        //         TODO add your handling code here:
        if (checkEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            if (checkValid()) {
                try {
                    ArrayList<String> sdtList = new ArrayList<>(
                            Arrays.asList(txtSdt.getText().replaceAll("\\s+", "").split(",")));
                    Set<String> set = new LinkedHashSet<>();
                    set.addAll(sdtList);
                    sdtList.clear();
                    sdtList.addAll(set);
                    KhachHang kh = new KhachHang(0, txtHo.getText().trim(), txtTenDem.getText().trim(),
                            txtTen.getText().trim(), txtDuong.getText().isBlank() ? "" : txtSoNha.getText().trim(),
                            txtDuong.getText().trim(), txtQuanHuyen.getText().trim(),
                            txtTinhTp.getText().trim(), sdtList);
                    KhachHangDAO.addKhachHang(kh);
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    this.father.showKhachHang();
                    this.dispose();
                } catch (ClassNotFoundException | IOException | SQLException ex) {
                    Logger.getLogger(ThemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemKhachHang dialog = new ThemKhachHang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel lblDuong;
    private javax.swing.JLabel lblHo;
    private javax.swing.JLabel lblQuanHuyen;
    private javax.swing.JLabel lblSdt;
    private javax.swing.JLabel lblSoNha;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTenDem;
    private javax.swing.JLabel lblTinhTP;
    private javax.swing.JTextField txtDuong;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtQuanHuyen;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoNha;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtTinhTp;
    // End of variables declaration//GEN-END:variables
}