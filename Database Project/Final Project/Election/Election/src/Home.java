
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Home extends javax.swing.JFrame {
 private Connection con;// To create conncetion between mysql and java
    private Statement st;// To create statement
    private ResultSet rs;// To create Resultset
    
    public void Data(){
        try{
            Class.forName("com.mysql.jdbc.Driver");       
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/election","root","");
            st= con.createStatement();   
            
        }catch(Exception ex){
        System.out.println("Server not found !!!!!");
        }
    }  //To Make the Connection
    
    public Home() {
        initComponents();
        Data();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        becommission = new javax.swing.JButton();
        bcandidateinfo = new javax.swing.JButton();
        bvoterinfo = new javax.swing.JButton();
        bvelectionreg = new javax.swing.JButton();
        bcelectionreg = new javax.swing.JButton();
        bvotecast = new javax.swing.JButton();
        bshowinfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Homepage");

        becommission.setText("Election Commision");
        becommission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                becommissionActionPerformed(evt);
            }
        });

        bcandidateinfo.setText("Cadidate Registration");
        bcandidateinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcandidateinfoActionPerformed(evt);
            }
        });

        bvoterinfo.setText("Voter Registration");
        bvoterinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvoterinfoActionPerformed(evt);
            }
        });

        bvelectionreg.setText("Voter Election Regsitration");
        bvelectionreg.setToolTipText("");
        bvelectionreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvelectionregActionPerformed(evt);
            }
        });

        bcelectionreg.setText("Candidate Election Regsitration");
        bcelectionreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcelectionregActionPerformed(evt);
            }
        });

        bvotecast.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bvotecast.setText("Vote");
        bvotecast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvotecastActionPerformed(evt);
            }
        });

        bshowinfo.setText("Show Information");
        bshowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bshowinfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(bvotecast, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(becommission)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addComponent(bcandidateinfo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addComponent(bcelectionreg))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(bvoterinfo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(bvelectionreg))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bshowinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(becommission)
                    .addComponent(bshowinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcandidateinfo)
                    .addComponent(bvoterinfo))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcelectionreg)
                    .addComponent(bvelectionreg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(bvotecast)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //To Check The Password of Election Commission which is admin and To make Election Commission Open
    private void becommissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_becommissionActionPerformed
        JPasswordField pass = new JPasswordField();
        int ok = JOptionPane.showConfirmDialog(null, pass, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String password="";
        if (ok == JOptionPane.OK_OPTION) {
                password = new String(pass.getPassword());
                //System.err.println("You entered: " + password);
        }
      
        if(password.equals("admin"))// If the password is Correct, Make the form Open
       {
           electioncommision ec=new electioncommision();
           ec.setVisible(true);
       }
       else// In Case of Wrong Password
       {   
          JOptionPane.showMessageDialog(rootPane, "Try again");
       }
        //Passofpostinfo ps=new Passofpostinfo();
        //ps.setVisible(true);
        
    }//GEN-LAST:event_becommissionActionPerformed
    //To Make the fomr Open that has been clicked
    private void bcandidateinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcandidateinfoActionPerformed
        candidateinfo ci=new candidateinfo();
        ci.setVisible(true);
    }//GEN-LAST:event_bcandidateinfoActionPerformed

    private void bvoterinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvoterinfoActionPerformed
        Voterinfo vi=new Voterinfo();
        vi.setVisible(true);
    }//GEN-LAST:event_bvoterinfoActionPerformed

    private void bcelectionregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcelectionregActionPerformed
        celectionreg celec= new celectionreg();
        celec.setVisible(true);
    }//GEN-LAST:event_bcelectionregActionPerformed

    private void bvelectionregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvelectionregActionPerformed
        velectionreg velec=new velectionreg();
        velec.setVisible(true);
    }//GEN-LAST:event_bvelectionregActionPerformed

    private void bvotecastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvotecastActionPerformed
        votecast vc= new votecast();
        vc.setVisible(true);
    }//GEN-LAST:event_bvotecastActionPerformed

    private void bshowinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bshowinfoActionPerformed
           showinfo si=new showinfo();
           si.setVisible(true);
    }//GEN-LAST:event_bshowinfoActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcandidateinfo;
    private javax.swing.JButton bcelectionreg;
    private javax.swing.JButton becommission;
    private javax.swing.JButton bshowinfo;
    private javax.swing.JButton bvelectionreg;
    private javax.swing.JButton bvotecast;
    private javax.swing.JButton bvoterinfo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
