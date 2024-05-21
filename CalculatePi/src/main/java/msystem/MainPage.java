/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package msystem;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import msystem.CalculatePi;
/**
 *
 * @author never
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public MainPage() {
        initComponents();
        //CalculatePi.doubleCalcPi(1000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblMainTitle = new javax.swing.JLabel();
        rdbtnDoubleProcess = new javax.swing.JRadioButton();
        rdbtnBigDecimalProcess = new javax.swing.JRadioButton();
        lblCycles = new javax.swing.JLabel();
        txtNumberOfRuns = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpnComparison = new javax.swing.JTextPane();
        lblCompare = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        lblAccuracy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMainTitle.setText("Calculate Pi Java");

        buttonGroup1.add(rdbtnDoubleProcess);
        rdbtnDoubleProcess.setSelected(true);
        rdbtnDoubleProcess.setText("Calculate Pi using doubles");

        buttonGroup1.add(rdbtnBigDecimalProcess);
        rdbtnBigDecimalProcess.setText("Calculate Pi using BigDecimals");

        lblCycles.setText("Number of cycles to run");

        txtNumberOfRuns.setText("1000000");

        txtpnComparison.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        txtpnComparison.setText("12345678901234567890123456789012345678901234567890");
        txtpnComparison.setFocusable(false);
        jScrollPane1.setViewportView(txtpnComparison);

        lblCompare.setText("Comparison - ");

        btnRun.setText("Run Comparison");
        btnRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRunMouseClicked(evt);
            }
        });

        lblAccuracy.setText("This is accurate to the nnth digit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbtnBigDecimalProcess)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbtnDoubleProcess)
                                    .addComponent(lblMainTitle))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCycles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumberOfRuns))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCompare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAccuracy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnRun)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rdbtnBigDecimalProcess, rdbtnDoubleProcess});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMainTitle)
                    .addComponent(lblCycles))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnDoubleProcess)
                    .addComponent(txtNumberOfRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbtnBigDecimalProcess)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCompare)
                        .addComponent(lblAccuracy))
                    .addComponent(btnRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRunMouseClicked
        // TODO add your handling code here:

        StyledDocument doc = txtpnComparison.getStyledDocument();
        Style style = txtpnComparison.addStyle("work damnit", null);
        StyleConstants.setForeground(style, Color.red);
        
        try{ doc.insertString(doc.getLength(), "Test", style); }
        catch(Exception e){System.out.println("MainPage-btnRunMouseClicked" + e);}
        
        
    }//GEN-LAST:event_btnRunMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccuracy;
    private javax.swing.JLabel lblCompare;
    private javax.swing.JLabel lblCycles;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JRadioButton rdbtnBigDecimalProcess;
    private javax.swing.JRadioButton rdbtnDoubleProcess;
    private javax.swing.JTextField txtNumberOfRuns;
    private javax.swing.JTextPane txtpnComparison;
    // End of variables declaration//GEN-END:variables
}
