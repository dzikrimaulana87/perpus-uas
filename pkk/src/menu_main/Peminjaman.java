/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu_main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luthf
 */
public class Peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public Peminjaman() {
        initComponents();
    }

    private void cbbbuku() {
        kdbuku.removeAllItems();
        kdbuku.addItem("~Pilih~");
        try {
            String Sql = "SELECT*FROM buku";
            Statement st = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while (pinjam.next()) {
                String AliasKode = pinjam.getString("kode_buku");
                kdbuku.addItem(AliasKode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menampilkan Data\n" + e.getMessage());
        }
    }

    private void cbniss() {
        cbnis.removeAllItems();
        cbnis.addItem("~Pilih~");
        try {
            String Sql = "SELECT*FROM siswa";
            Statement st = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while (pinjam.next()) {
                String AliasKode = pinjam.getString("nis");
                cbnis.addItem(AliasKode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menampilkan Data\n" + e.getMessage());
        }
    }

    private void cbpetugas() {
        idpetugas.removeAllItems();
        idpetugas.addItem("~Pilih~");
        try {
            String Sql = "SELECT*FROM petugas";
            Statement st = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while (pinjam.next()) {
                String AliasKode = pinjam.getString("id_petugas");
                idpetugas.addItem(AliasKode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menampilkan Data\n" + e.getMessage());
        }
    }

    protected void load_table() {
        Object[] baris = {"Kode Peminjaman", "Tgl Pinjam", "Nis", "Nama", "Kelas", "Kode Buku", "Judul Buku", "Jumlah Buku", "ID Petugas"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);

        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "select * from peminjaman ";
            ResultSet cari = state.executeQuery(sql);

            while (cari.next()) {
                String a = cari.getString(1);
                String b = cari.getString(2);
                String c = cari.getString(3);
                String d = cari.getString(4);
                String e = cari.getString(5);
                String f = cari.getString(6);
                String g = cari.getString(7);
                String h = cari.getString(8);
                String i = cari.getString(9);
                Object[] data = {a, b, c, d, e, f, g, h, i};
                tablek.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    private void teangan() {
        Object[] baris = {"Kode Peminjaman", "Tgl Pinjam", "Nis", "Nama", "Kelas", "Kode Buku", "Judul Buku", "Jumlah Buku", "ID Petugas"};
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        String carii = cari.getText();

        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "select * from peminjaman WHERE kode_peminjaman LIKE '%" + carii + "%'OR judul_buku LIKE '" + carii + "'";
            ResultSet cari = state.executeQuery(sql);

            while (cari.next()) {
                String a = cari.getString(1);
                String b = cari.getString(2);
                String c = cari.getString(3);
                String d = cari.getString(4);
                String e = cari.getString(5);
                String f = cari.getString(6);
                String g = cari.getString(7);
                String h = cari.getString(8);
                String i = cari.getString(9);
                Object[] data = {a, b, c, d, e, f, g, h, i};
                tablek.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Data Gak ada!");
        }
    }

    private void kosong() {
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

    private void struk() {
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
        jLabel1 = new javax.swing.JLabel();
        kdpeminjaman = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledor = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        tglpinjam = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kelas = new javax.swing.JTextField();
        jdlbuku = new javax.swing.JTextField();
        jmlhbuku = new javax.swing.JTextField();
        idpetugas = new javax.swing.JComboBox<>();
        cbnis = new javax.swing.JComboBox<>();
        kdbuku = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Peminjaman Buku");

        kdpeminjaman.setBackground(new java.awt.Color(208, 239, 239));
        kdpeminjaman.setForeground(new java.awt.Color(153, 153, 153));
        kdpeminjaman.setText("Kode Peminjaman");

        tabledor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Peminjaman", "Tgl Pinjam", "NIS", "Nama", "Kelas", "Kode Buku", "Judul Buku", "Jumlah Buku", "ID Petugas"
            }
        ));
        jScrollPane1.setViewportView(tabledor);

        cari.setForeground(new java.awt.Color(153, 153, 153));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(0, 0, 0));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnBersih.setBackground(new java.awt.Color(0, 0, 0));
        btnBersih.setForeground(new java.awt.Color(255, 255, 255));
        btnBersih.setText("Bersih");
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(0, 0, 0));
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tglpinjam.setBackground(new java.awt.Color(208, 239, 239));
        tglpinjam.setForeground(new java.awt.Color(153, 153, 153));
        tglpinjam.setText("Tanggal Pinjam (YYYY-MM-DD)");

        nama.setBackground(new java.awt.Color(208, 239, 239));
        nama.setForeground(new java.awt.Color(153, 153, 153));
        nama.setText("Nama");

        kelas.setBackground(new java.awt.Color(208, 239, 239));
        kelas.setForeground(new java.awt.Color(153, 153, 153));
        kelas.setText("Kelas");

        jdlbuku.setBackground(new java.awt.Color(208, 239, 239));
        jdlbuku.setForeground(new java.awt.Color(153, 153, 153));
        jdlbuku.setText("Judul Buku");
        jdlbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdlbukuActionPerformed(evt);
            }
        });

        jmlhbuku.setBackground(new java.awt.Color(208, 239, 239));
        jmlhbuku.setForeground(new java.awt.Color(153, 153, 153));
        jmlhbuku.setText("Jumlah Buku");
        jmlhbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlhbukuActionPerformed(evt);
            }
        });

        idpetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Petugas", "1", "2", "3", "4" }));
        idpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpetugasActionPerformed(evt);
            }
        });

        cbnis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIS", "171805432", "17180552", "17180556", "17180557" }));
        cbnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnisActionPerformed(evt);
            }
        });

        kdbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Buku", "BIO", "dawd121", "NLV001", "NVL002" }));
        kdbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdbukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnBersih)
                                .addGap(18, 18, 18)
                                .addComponent(btnKeluar))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(kdpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(cbnis, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(kdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(15, 15, 15)
                                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(15, 15, 15)
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jdlbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jmlhbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(btnCari))
                                .addComponent(jScrollPane1)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdlbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jmlhbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnBersih)
                    .addComponent(btnKeluar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdlbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdlbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdlbukuActionPerformed

    private void jmlhbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlhbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmlhbukuActionPerformed

    private void cbnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnisActionPerformed
        // TODO add your handling code here:
        try {
            String Sql="select * from siswa where nis='"+cbnis.getSelectedItem().toString()+"'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
            while(pinjam.next()){
                nama.setText(pinjam.getString("nama"));
                kelas.setText(pinjam.getString("kelas"));
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_cbnisActionPerformed

    private void kdbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdbukuActionPerformed
        // TODO add your handling code here:
        try {
            String Sql="select * from buku where kode_buku='"+kdbuku.getSelectedItem().toString()+"'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
            while(pinjam.next()){
                jdlbuku.setText(pinjam.getString("judul_buku"));
                jmlhbuku.setText(pinjam.getString("jumlah_buku"));//sesuaikan di database, atau bisa di ubah menjadi("nama_pelanggan")
                
            }
        } catch (Exception e) {
            
        }
          
    }//GEN-LAST:event_kdbukuActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        teangan();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "INSERT INTO peminjaman VALUES ('" + kdpeminjaman.getText() + "','" + tglpinjam.getText() + "','" + cbnis.getSelectedItem() + "','" + nama.getText() + "','" + kelas.getText() + "','" + kdbuku.getSelectedItem() + "','" + jdlbuku.getText() + "','" + jmlhbuku.getText() + "','" + idpetugas.getSelectedItem() + "')";
            state.executeUpdate(sql);
            String pilihan[] = {
                "Print aja", "Nanti aja"
            };
            int tny = JOptionPane.showOptionDialog(null,
                    "Struk mau langsung di print?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
            if (tny == 0) {
                try {
                    struk();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try{
        Statement state = handler_class.Koneksi.konek().createStatement();
        String sql = "update peminjaman set tanggal_pinjam='"+tglpinjam.getText()+"',nis='"+cbnis.getSelectedItem().toString()+"',nama='"+nama.getText()+"',kelas='"+kelas.getText()+"',kode_buku='"+kdbuku.getSelectedItem()+"',judul_buku='"+jdlbuku.getText()+"',jumlah_buku='"+jmlhbuku.getText()+"',id_petugas='"+idpetugas.getSelectedItem()+"' where kode_peminjaman='"+kdpeminjaman.getText()+"'";
        state.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Diedit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit");
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        new Menu_utama().show();
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btnBersihActionPerformed

    private void idpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpetugasActionPerformed
        // TODO add your handling code here:
        try{
            String Sql="select * from petugas where id_petugas='"+idpetugas.getSelectedItem().toString()+"'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam =state.executeQuery(Sql);
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_idpetugasActionPerformed

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbnis;
    private javax.swing.JComboBox<String> idpetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
