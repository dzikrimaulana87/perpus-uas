/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu1;

import menu.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEKDES
 */
public class peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form peminjaman
     */
    public peminjaman() {
        initComponents();
        cbbbuku();
        cbniss();
        cbpetugas();
        teangan();
        load_table();
        kosong();
        struk();
        hapuse.setEnabled(false);
    }
    private void cbbbuku(){
        kdbuku.removeAllItems();
        kdbuku.addItem("~Pilih~");
        try {
            String Sql ="SELECT*FROM buku";
            Statement st= pkk.koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while(pinjam.next()){
            String AliasKode= pinjam.getString("kode_buku");
            kdbuku.addItem(AliasKode);
        }
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
            "Gagal Menampilkan Data\n"+e.getMessage());
}
     }
    private void cbniss(){
        cbnis.removeAllItems();
        cbnis.addItem("~Pilih~");
        try {
            String Sql ="SELECT*FROM siswa";
            Statement st= pkk.koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while(pinjam.next()){
            String AliasKode= pinjam.getString("nis");
            cbnis.addItem(AliasKode);
        }
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
            "Gagal Menampilkan Data\n"+e.getMessage());
}
     }
    private void cbpetugas(){
        idpetugas.removeAllItems();
        idpetugas.addItem("~Pilih~");
        try {
            String Sql ="SELECT*FROM petugas";
            Statement st= pkk.koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while(pinjam.next()){
            String AliasKode= pinjam.getString("id_petugas");
            idpetugas.addItem(AliasKode);
        }
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null,
            "Gagal Menampilkan Data\n"+e.getMessage());
}
     }
    protected void load_table() {
        Object[]baris={"Kode Peminjaman","Tgl Pinjam","Nis","Nama","Kelas","Kode Buku","Judul Buku","Jumlah Buku","ID Petugas"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        
        try{
            Statement state=pkk.koneksi.konek().createStatement();
            String sql = "select * from peminjaman ";
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
            Object[]data={a,b,c,d,e,f,g,h,i};
            tablek.addRow(data);
        }
    }catch (Exception e){
    }
    }
    private void teangan() {
        Object[]baris={"Kode Peminjaman","Tgl Pinjam","Nis","Nama","Kelas","Kode Buku","Judul Buku","Jumlah Buku","ID Petugas"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        String carii = cari.getText();
        
        try{
            Statement state=pkk.koneksi.konek().createStatement();
            String sql = "select * from peminjaman WHERE kode_peminjaman LIKE '%"+carii+"%'OR judul_buku LIKE '"+carii+"'" ;
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
            Object[]data={a,b,c,d,e,f,g,h,i};
            tablek.addRow(data);
        }
    }catch (Exception e){
        System.out.println("Data Gak ada!");
    }
    }
     private void kosong(){
        kdpeminjaman.setText("");
        tglpinjam.setText("");
        cbnis.setSelectedItem("~Pilih~");
        nama.setText("");
        idpetugas.setSelectedItem("~Pilih~");
        kelas.setText("");
        kdbuku.setSelectedItem("~Pilih~");
        jdlbuku.setText("");
        jmlhbuku.setText("");
        }
     private void struk(){
         if (kdpeminjaman.getText().isEmpty()) {
        } else {
            PrintJob p = getToolkit().getPrintJob(this, "Cetak Tiket", null);

            Graphics g = p.getGraphics();
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("PERPUSTAKAAN SMK TI MUHAMMADIYAH CIKAMPEK", 200, 18);
            g.drawLine(10, 30, 600, 30);
            g.setFont(new Font("Courier New", Font.PLAIN, 12));
            g.drawString("Kode Peminjaman", 10, 50);
            g.drawString(" : ", 100, 50);
            g.drawString(kdpeminjaman.getText(), 160, 50);

            g.drawString("Tanggal Pinjam", 10, 60);
            g.drawString(" : ", 100, 60);
            g.drawString(tglpinjam.getText(), 160, 60);

            g.drawString("NIS", 10, 70);
            g.drawString(" : ", 100, 70);
            g.drawString((String) cbnis.getSelectedItem(), 160, 70);

            g.drawString("Nama", 10, 80);
            g.drawString(" : ", 100, 80);
            g.drawString(nama.getText(), 160, 80);

            g.drawString("Kelas", 10, 90);
            g.drawString(" : ", 100, 90);
            g.drawString(kelas.getText(), 160, 90);

            g.drawString("Jumlah", 10, 100);
            g.drawString(" : ", 100, 100);
            g.drawString(jmlhbuku.getText(), 160, 100);

            g.drawString("Judul", 10, 110);
            g.drawString(" : ", 100, 110);
            g.drawString(jdlbuku.getText(), 160, 110);

            p.end();
        }
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
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kdpeminjaman = new javax.swing.JTextField();
        cbnis = new javax.swing.JComboBox<>();
        nama = new javax.swing.JTextField();
        jmlhbuku = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdlbuku = new javax.swing.JTextField();
        kdbuku = new javax.swing.JComboBox<>();
        kelas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledor = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        hapuse = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tglpinjam = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        idpetugas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btncari = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PEMINJAMAN BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel9)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KODE PEMINJAMAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TANGGAL PINJAM");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, -1, -1));
        jPanel1.add(kdpeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 89, 192, -1));

        cbnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnisActionPerformed(evt);
            }
        });
        jPanel1.add(cbnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 162, 192, -1));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 200, 192, -1));
        jPanel1.add(jmlhbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 200, 192, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KELAS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 92, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("KODE BUKU");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 133, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("JUDUL BUKU");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 165, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JUMLAH BUKU");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 203, -1, -1));
        jPanel1.add(jdlbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 162, 192, -1));

        kdbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdbukuActionPerformed(evt);
            }
        });
        jPanel1.add(kdbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 127, 192, -1));
        jPanel1.add(kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 89, 192, -1));

        tabledor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Peminjaman", "Tgl Pinjam", "Nis", "Nama", "Kelas", "Kode Buku", "Judul Buku", "Jumlah Buku", "ID Petugas"
            }
        ));
        tabledor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabledor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 317, 893, 91));
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 289, 192, -1));

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 426, -1, -1));

        hapuse.setText("HAPUS");
        hapuse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapuseActionPerformed(evt);
            }
        });
        jPanel1.add(hapuse, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 426, -1, -1));

        jButton4.setText("EDIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 426, -1, -1));

        jButton5.setText("BATAL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 426, -1, -1));

        jButton6.setText("KEMBALI");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 426, -1, -1));
        jPanel1.add(tglpinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 127, 192, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID PETUGAS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, -1, -1));

        idpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpetugasActionPerformed(evt);
            }
        });
        jPanel1.add(idpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 238, 192, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("YYYY-MM-DD");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 130, -1, -1));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel1.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 288, -1, -1));

        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 426, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "INSERT INTO peminjaman VALUES ('"+kdpeminjaman.getText()+"','"+tglpinjam.getText()+"','"+cbnis.getSelectedItem()+"','"+nama.getText()+"','"+kelas.getText()+"','"+kdbuku.getSelectedItem()+"','"+jdlbuku.getText()+"','"+jmlhbuku.getText()+"','"+idpetugas.getSelectedItem()+"')";
        state.executeUpdate(sql);
        String pilihan[]={
            "Print aja","Nanti aja"
        };
        int tny = JOptionPane.showOptionDialog(null,
                   "Struk mau langsung di print?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,pilihan,pilihan[0]);
                   if (tny==0){
                       try {
                           struk();
                       } catch (Exception e) {
                       }
                   }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kdbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdbukuActionPerformed
        try {
            String Sql="select * from buku where kode_buku='"+kdbuku.getSelectedItem().toString()+"'";
            Statement state = pkk.koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
            while(pinjam.next()){
                jdlbuku.setText(pinjam.getString("judul_buku"));
                jmlhbuku.setText(pinjam.getString("jumlah_buku"));//sesuaikan di database, atau bisa di ubah menjadi("nama_pelanggan")
                
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_kdbukuActionPerformed

    private void cbnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnisActionPerformed
       try {
            String Sql="select * from siswa where nis='"+cbnis.getSelectedItem().toString()+"'";
            Statement state = pkk.koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
            while(pinjam.next()){
                nama.setText(pinjam.getString("nama"));
                kelas.setText(pinjam.getString("kelas"));
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_cbnisActionPerformed

    private void idpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpetugasActionPerformed
        try{
            String Sql="select * from petugas where id_petugas='"+idpetugas.getSelectedItem().toString()+"'";
            Statement state = pkk.koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_idpetugasActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        teangan();
    }//GEN-LAST:event_btncariActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        kosong();
        load_table();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabledorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledorMouseClicked
        int baris = tabledor.rowAtPoint(evt.getPoint());
        String a = tabledor.getValueAt(baris, 0).toString();
        kdpeminjaman.setText(a);
        String b = tabledor.getValueAt(baris, 1).toString();
        tglpinjam.setText(b);
        String c = tabledor.getValueAt(baris, 2).toString();
        cbnis.setSelectedItem(c);
        String d = tabledor.getValueAt(baris, 3).toString();
        nama.setText(d);
        String e = tabledor.getValueAt(baris, 4).toString();
        kelas.setText(e);
        String f = tabledor.getValueAt(baris, 5).toString();
        kdbuku.setSelectedItem(f);
        String g = tabledor.getValueAt(baris, 6).toString();
        jdlbuku.setText(g);
        String h = tabledor.getValueAt(baris, 7).toString();
        jmlhbuku.setText(h);
        String i = tabledor.getValueAt(baris, 8).toString();
        idpetugas.setSelectedItem(i);
    }//GEN-LAST:event_tabledorMouseClicked

    private void hapuseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapuseActionPerformed
        try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "delete from peminjaman where kode_peminjaman= '"+kdpeminjaman.getText()+"'";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Dihapus");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dihapus");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_hapuseActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
        Statement state = pkk.koneksi.konek().createStatement();
        String sql = "update peminjaman set tanggal_pinjam='"+tglpinjam.getText()+"',nis='"+cbnis.getSelectedItem().toString()+"',nama='"+nama.getText()+"',kelas='"+kelas.getText()+"',kode_buku='"+kdbuku.getSelectedItem()+"',judul_buku='"+jdlbuku.getText()+"',jumlah_buku='"+jmlhbuku.getText()+"',id_petugas='"+idpetugas.getSelectedItem()+"' where kode_peminjaman='"+kdpeminjaman.getText()+"'";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Di Edit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Di Edit");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new menu_utama1().show();
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        struk();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbnis;
    private javax.swing.JButton hapuse;
    private javax.swing.JComboBox<String> idpetugas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField jdlbuku;
    private javax.swing.JTextField jmlhbuku;
    private javax.swing.JComboBox<String> kdbuku;
    private javax.swing.JTextField kdpeminjaman;
    private javax.swing.JTextField kelas;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabledor;
    private javax.swing.JTextField tglpinjam;
    // End of variables declaration//GEN-END:variables
}
