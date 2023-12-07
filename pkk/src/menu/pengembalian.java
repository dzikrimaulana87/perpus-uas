/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEKDES
 */
public class pengembalian extends javax.swing.JFrame {

    /**
     * Creates new form pengembalian
     */
    public pengembalian() {
        initComponents();
        load_table();
        kosong();
        cbbpinjam();
        teangan();
    }

    private void teangan() {
        Object[]baris={"Kode Pengembalian","Tanggal Pengembalian","Kode Peminjaman","Tanggal Peminjaman","NIS","Nama","Kelas","Kode Buku","Nama Buku","Jumlah Buku","Keterlambatan","Denda"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        String carii = cari.getText();
        
        try{
            Statement state=pkk.koneksi.konek().createStatement();
            String sql = "select * from pengembalian WHERE kode_pengembalian LIKE '%"+carii+"%'OR judul_buku LIKE '"+carii+"'" ;
            ResultSet cari = state.executeQuery(sql);
            
             while (cari.next()){
            String a = cari.getString(1);
            String b = cari.getString(2);
            String c = cari.getString(3);
            String d = cari.getString(4);
            String e = cari.getString(5);
            String f = cari.getString(6);
            String g = cari.getString(7);
            String h = cari.getString(8);
            String i = cari.getString(9);
            String j = cari.getString(10);
            String k = cari.getString(11);
            String l = cari.getString(12);
            Object[]data={a,b,c,d,e,f,g,h,i,j,k,l};
            tablek.addRow(data);
        }
    }catch (Exception e){
        System.out.println("Data Gak ada!");
    }
    }
    private void cbbpinjam(){
        kode_peminjaman.removeAllItems();
        kode_peminjaman.addItem("~Pilih~");
        try {
            String Sql ="SELECT*FROM peminjaman";
            Statement st= pkk.koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while(pinjam.next()){
            String AliasKode= pinjam.getString("kode_peminjaman");
            kode_peminjaman.addItem(AliasKode);
        }
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
            "Gagal Menampilkan Data\n"+e.getMessage());
}
     }
    protected void load_table() {
        Object[]baris={"Kode Pengembalian","Tanggal Pengembalian","Kode Peminjaman","Tanggal Peminjaman","Nis","Nama","Kelas","Kode Buku","Nama Buku","Jumlah Buku","Keterlambatan","Denda"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        
        try{
            Statement state=pkk.koneksi.konek().createStatement();
            String sql = "select * from pengembalian ";
            ResultSet cari = state.executeQuery(sql);
            
            while (cari.next()){
            String a = cari.getString(1);
            String b = cari.getString(2);
            String c = cari.getString(3);
            String d = cari.getString(4);
            String e = cari.getString(5);
            String f = cari.getString(6);
            String g = cari.getString(7);
            String h = cari.getString(8);
            String i = cari.getString(9);
            String j = cari.getString(10);
            String k = cari.getString(11);
            String l = cari.getString(12);
            Object[]data={a,b,c,d,e,f,g,h,i,j,k,l};
            tablek.addRow(data);
        }
    }catch (Exception e){
    }
    }
    private void kosong(){
        kode_pengembalian.setText("");
        tanggal_pengembalian.setText("");
        kode_peminjaman.setSelectedItem("~Pilih~");
        tanggal_peminjaman.setText("");
        nis.setText("");
        nama.setText("");
        kelas.setText("");
        kode_buku.setText("");
        nama_buku.setText("");
        jumlah_buku.setText("");
        keterlambatan.setText("");
        denda.setText("");
        uang_bayar.setText("");
        uang_kembali.setText("");
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tanggal_pengembalian = new javax.swing.JTextField();
        kode_pengembalian = new javax.swing.JTextField();
        kode_peminjaman = new javax.swing.JComboBox<>();
        tanggal_peminjaman = new javax.swing.JTextField();
        nis = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kelas = new javax.swing.JTextField();
        kode_buku = new javax.swing.JTextField();
        nama_buku = new javax.swing.JTextField();
        jumlah_buku = new javax.swing.JTextField();
        keterlambatan = new javax.swing.JTextField();
        denda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledor = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        uang_kembali = new javax.swing.JTextField();
        uang_bayar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PENGEMBALIAN BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel1)
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KODE PENGEMBALIAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TANGGAL PENGEMBALIAN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 128, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("KODE PEMINJAMAN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TANGGAL PEMINJAMAN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 207, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NIS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 247, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NAMA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("KELAS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 323, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KODE BUKU");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 361, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NAMA BUKU");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 399, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("JUMLAH BUKU");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 437, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("KETERLAMBATAN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 89, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DENDA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 128, -1, -1));

        tanggal_pengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_pengembalianActionPerformed(evt);
            }
        });
        jPanel1.add(tanggal_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 127, 221, -1));
        jPanel1.add(kode_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 88, 221, -1));

        kode_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_peminjamanActionPerformed(evt);
            }
        });
        jPanel1.add(kode_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 167, 221, -1));
        jPanel1.add(tanggal_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 206, 221, -1));
        jPanel1.add(nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 246, 221, -1));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 284, 221, -1));
        jPanel1.add(kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 322, 221, -1));
        jPanel1.add(kode_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 360, 221, -1));
        jPanel1.add(nama_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 398, 221, -1));
        jPanel1.add(jumlah_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 436, 221, -1));
        jPanel1.add(keterlambatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 88, 232, -1));
        jPanel1.add(denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 127, 232, -1));

        tabledor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pengembalian", "Tanggal Pengembalian", "Kode Peminjaman", "Tanggal Peminjaman", "Nis", "Nama", "Kelas", "Kode Buku", "Nama Buku", "Jumlah Buku", "Keterlambatan", "Denda"
            }
        ));
        tabledor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabledor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 519, 1193, 90));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("UANG BAYAR");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 168, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("UANG KEMBALI");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 207, -1, -1));

        uang_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uang_kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(uang_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 206, 232, -1));
        jPanel1.add(uang_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 167, 232, -1));

        jButton1.setText("HITUNG DENDA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 126, -1, -1));

        jButton2.setText("HITUNG UANG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 205, -1, -1));
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(898, 491, 232, -1));

        jButton3.setText("CARI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1136, 490, -1, -1));

        jButton4.setText("SIMPAN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 615, -1, -1));

        jButton5.setText("HAPUS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 615, 70, -1));

        jButton6.setText("EDIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 615, -1, -1));

        jButton7.setText("BATAL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 615, -1, -1));

        jButton8.setText("KELUAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 615, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("YYYY-MM-DD");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 209, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("YYYY-MM-DD");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tanggal_pengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_pengembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_pengembalianActionPerformed

    private void kode_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_peminjamanActionPerformed
        try {
            String Sql="select * from peminjaman where kode_peminjaman='"+kode_peminjaman.getSelectedItem()+"'";
            Statement state = pkk.koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
            while(pinjam.next()){
                tanggal_peminjaman.setText(pinjam.getString("tanggal_pinjam"));
                nis.setText(pinjam.getString("nis"));
                nama.setText(pinjam.getString("nama"));
                kelas.setText(pinjam.getString("kelas"));
                kode_buku.setText(pinjam.getString("kode_buku"));
                nama_buku.setText(pinjam.getString("judul_buku"));
                jumlah_buku.setText(pinjam.getString("jumlah_buku"));
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_kode_peminjamanActionPerformed

    private void uang_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uang_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uang_kembaliActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "UPDATE pengembalian SET tanggal_pengembalian='"+tanggal_pengembalian.getText()+"',kode_peminjaman='"+kode_peminjaman.getSelectedItem().toString()+"',tanggal_peminjaman='"+tanggal_peminjaman.getText()+"',nis='"+nis.getText()+"',nama='"+nama.getText()+"',kelas='"+kelas.getText()+"',kode_buku='"+kode_buku.getText()+"',nama_buku='"+nama_buku.getText()+"',jumlah_buku='"+jumlah_buku.getText()+"',keterlambatan='"+keterlambatan.getText()+"',denda='"+denda.getText()+"' where kode_pengembalian='"+kode_pengembalian.getText()+"'";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Di Edit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Di Edit");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new menu_utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a = Integer.parseInt(keterlambatan.getText());
        int b = 2000;
        int hasil = a*b;
        String c = Integer.toString(hasil);
        denda.setText(c);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = Integer.parseInt(uang_bayar.getText());
        int b = Integer.parseInt(denda.getText());
        int hasil = a-b;
        String c = Integer.toString(hasil);
        uang_kembali.setText(c);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "INSERT INTO pengembalian VALUES ('"+kode_pengembalian.getText()+"','"+tanggal_pengembalian.getText()+"','"+kode_peminjaman.getSelectedItem().toString()+"','"+tanggal_peminjaman.getText()+"','"+nis.getText()+"','"+nama.getText()+"','"+kelas.getText()+"','"+kode_buku.getText()+"','"+nama_buku.getText()+"','"+jumlah_buku.getText()+"','"+keterlambatan.getText()+"','"+denda.getText()+"')";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "delete from pengembalian where kode_pengembalian= '"+kode_pengembalian.getText()+"'";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Dihapus");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dihapus");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        kosong();
        load_table();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        teangan();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabledorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledorMouseClicked
        int baris = tabledor.rowAtPoint(evt.getPoint());
        String a = tabledor.getValueAt(baris, 0).toString();
        kode_pengembalian.setText(a);
        String b = tabledor.getValueAt(baris, 1).toString();
        tanggal_pengembalian.setText(b);
        String c = tabledor.getValueAt(baris, 2).toString();
        kode_peminjaman.setSelectedItem(c);
        String d = tabledor.getValueAt(baris, 3).toString();
        tanggal_peminjaman.setText(d);
        String e = tabledor.getValueAt(baris, 4).toString();
        nis.setText(e);
        String f = tabledor.getValueAt(baris, 5).toString();
        nama.setText(f);
        String g = tabledor.getValueAt(baris, 6).toString();
        kelas.setText(g);
        String h = tabledor.getValueAt(baris, 7).toString();
        kode_buku.setText(h);
        String i = tabledor.getValueAt(baris, 8).toString();
        nama_buku.setText(i);
        String j = tabledor.getValueAt(baris, 9).toString();
        jumlah_buku.setText(j);
        String k = tabledor.getValueAt(baris, 10).toString();
        keterlambatan.setText(k);
        String l = tabledor.getValueAt(baris, 11).toString();
        denda.setText(l);
    }//GEN-LAST:event_tabledorMouseClicked

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
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField denda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah_buku;
    private javax.swing.JTextField kelas;
    private javax.swing.JTextField keterlambatan;
    private javax.swing.JTextField kode_buku;
    private javax.swing.JComboBox<String> kode_peminjaman;
    private javax.swing.JTextField kode_pengembalian;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nama_buku;
    private javax.swing.JTextField nis;
    private javax.swing.JTable tabledor;
    private javax.swing.JTextField tanggal_peminjaman;
    private javax.swing.JTextField tanggal_pengembalian;
    private javax.swing.JTextField uang_bayar;
    private javax.swing.JTextField uang_kembali;
    // End of variables declaration//GEN-END:variables
}
