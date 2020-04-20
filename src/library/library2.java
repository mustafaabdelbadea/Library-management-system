package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class library2 extends javax.swing.JFrame {
  DefaultTableModel model;
    Connection con;
    Statement stmt;
    ResultSet rs;
    public library2() {
        initComponents();
        
        connectToSql();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(myTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public void connectToSql(){
    model=new DefaultTableModel();
    model.addColumn("U_ID");
    model.addColumn("U_name");
    model.addColumn("Lpass");
   // model.addColumn("Phone");
    myTable.setModel(model);
    String path="jdbc:sqlserver://localhost:1433;databaseName=library3;integritySecurity=false";
    String Uname="sa";
    String password="mustafa";
    try{
    con=DriverManager.getConnection(path,Uname,password);
    stmt=con.createStatement();
    rs=stmt.executeQuery("select * from users");
    while(rs.next()){
    model.addRow(new Object[]{rs.getInt("U_ID"),rs.getString("U_name"),rs.getString("Lpass")/*,rs.getString("phone")*/});
    }
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(this,e.getMessage());
    }
    }
  /*
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new library2().setVisible(true);
            }
        });
    
}
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTable;
    // End of variables declaration//GEN-END:variables
}
