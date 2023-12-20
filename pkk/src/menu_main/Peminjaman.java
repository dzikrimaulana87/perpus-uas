/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu_main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luthf
 */
public final class Peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    String nilaiTanggal;

    public Peminjaman() {
        initComponents();
        cbbbuku();
        cbniss();
        cbpetugas();
        searchCredential();
        load_table();
        kosong();
        // struk();
        disableField();
        // Jika tanggal adalah objek JDateChooser

    }

    private void disableField() {
        nama.setEnabled(false);
        kelas.setEnabled(false);
        judulBuku.setEnabled(false);

    }

    private void tanggal() {
        Date date = tanggalPinjam.getDate();

        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format "tahun-bulan-tanggal"
            nilaiTanggal = dateFormat.format(date);
            System.out.println(nilaiTanggal);
        } else {
            nilaiTanggal = "0000-00-00";
        }

    }

    private void cbbbuku() {
        kdbuku.removeAllItems();
        kdbuku.addItem("~Pilih ID Buku~");
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
        cbnis.addItem("~Pilih NIS Siswa~");
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
        idPetugas.removeAllItems();
        idPetugas.addItem("~Pilih ID Petugas~");
        try {
            String Sql = "SELECT*FROM petugas";
            Statement st = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = st.executeQuery(Sql);
            while (pinjam.next()) {
                String AliasKode = pinjam.getString("id_petugas");
                idPetugas.addItem(AliasKode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menampilkan Data\n" + e.getMessage());
        }
    }

    protected void load_table() {
        Object[] baris = { "Kode Peminjaman", "Tgl Pinjam", "Nis", "Nama", "Kelas", "Kode Buku", "Judul Buku",
                "Jumlah Buku", "ID Petugas" };
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
                Object[] data = { a, b, c, d, e, f, g, h, i };
                tablek.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    private void searchCredential() {
        Object[] baris = { "Kode Peminjaman", "Tgl Pinjam", "Nis", "Nama", "Kelas", "Kode Buku", "Judul Buku",
                "Jumlah Buku", "ID Petugas" };
        DefaultTableModel tablek = new DefaultTableModel(null, baris);
        tabledor.setModel(tablek);
        String carii = cari.getText();

        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "select * from peminjaman WHERE kode_peminjaman LIKE '%" + carii + "%'OR judul_buku LIKE '"
                    + carii + "'";
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
                Object[] data = { a, b, c, d, e, f, g, h, i };
                tablek.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Data Tidak Tersedia!");
        }
    }

    private void kosong() {
        kodePeminjaman.setText("Kode Peminjaman");
        tanggalPinjam.setDate(null);
        cbnis.setSelectedItem("~Pilih NIS Siswa~");
        nama.setText("Nama");
        idPetugas.setSelectedItem("~Pilih ID Petugas~");
        kelas.setText("Kelas");
        kdbuku.setSelectedItem("~Pilih ID Buku~");
        judulBuku.setText("Judul Buku");
        jumlahBuku.setText("Jumlah Buku");
    }

    private void struk() {
        if (kodePeminjaman.getText().isEmpty()) {
        } else {
            PrintJob p = getToolkit().getPrintJob(this, "Cetak Tiket", null);

            Graphics g = p.getGraphics();
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.drawString("PERPUSTAKAAN SMAN 2 POCHINOK", 200, 18);
            g.drawLine(10, 30, 600, 30);
            g.setFont(new Font("Courier New", Font.PLAIN, 12));
            g.drawString("Kode Peminjaman", 10, 50);
            g.drawString(" : ", 100, 50);
            g.drawString(kodePeminjaman.getText(), 160, 50);

            g.drawString("Tanggal Pinjam", 10, 60);
            g.drawString(" : ", 100, 60);
            g.drawString(nilaiTanggal, 160, 60);

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
            g.drawString(jumlahBuku.getText(), 160, 100);

            g.drawString("Judul", 10, 110);
            g.drawString(" : ", 100, 110);
            g.drawString(judulBuku.getText(), 160, 110);

            p.end();
        }
    }

    // Memeriksa ketersediaan buku
    private boolean checkBookAvailability(String bookID, int requestedQuantity) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String query = "SELECT jumlah_buku FROM buku WHERE kode_buku = '" + bookID + "'";
            ResultSet result = state.executeQuery(query);

            if (result.next()) {
                int availableQuantity = result.getInt("jumlah_buku");
                System.out.println(availableQuantity);

                return availableQuantity >= requestedQuantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Mengurangi jumlah buku di tabel buku setelah peminjaman
    private void updateBookQuantity(String bookID, int quantityToReduce) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String query = "UPDATE buku SET jumlah_buku = jumlah_buku - " + quantityToReduce
                    + " WHERE kode_buku = '" + bookID + "'";
            state.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mengambil jumlah buku asli dari database sebelum pengeditan
    private int getOriginalQuantityFromDatabase(String peminjamanID) {
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String query = "SELECT jumlah_buku FROM peminjaman WHERE kode_peminjaman = '" + peminjamanID + "'";
            ResultSet result = state.executeQuery(query);

            if (result.next()) {
                return result.getInt("jumlah_buku");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kodePeminjaman = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledor = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        kelas = new javax.swing.JTextField();
        judulBuku = new javax.swing.JTextField();
        jumlahBuku = new javax.swing.JTextField();
        idPetugas = new javax.swing.JComboBox<>();
        cbnis = new javax.swing.JComboBox<>();
        kdbuku = new javax.swing.JComboBox<>();
        tanggalPinjam = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Peminjaman Buku");

        kodePeminjaman.setBackground(new java.awt.Color(208, 239, 239));
        kodePeminjaman.setForeground(new java.awt.Color(153, 153, 153));
        kodePeminjaman.setText("Kode Peminjaman");
        kodePeminjaman.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kodePeminjamanFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                kodePeminjamanFocusLost(evt);
            }
        });

        tabledor.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null }
                },
                new String[] {
                        "Kode Peminjaman", "Tgl Pinjam", "NIS", "Nama", "Kelas", "Kode Buku", "Judul Buku",
                        "Jumlah Buku", "ID Petugas"
                }));
        tabledor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledorMouseClicked(evt);
            }
        });
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

        nama.setBackground(new java.awt.Color(208, 239, 239));
        nama.setForeground(new java.awt.Color(153, 153, 153));
        nama.setText("Nama");
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        kelas.setBackground(new java.awt.Color(208, 239, 239));
        kelas.setForeground(new java.awt.Color(153, 153, 153));
        kelas.setText("Kelas");

        judulBuku.setBackground(new java.awt.Color(208, 239, 239));
        judulBuku.setForeground(new java.awt.Color(153, 153, 153));
        judulBuku.setText("Judul Buku");
        judulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulBukuActionPerformed(evt);
            }
        });

        jumlahBuku.setBackground(new java.awt.Color(208, 239, 239));
        jumlahBuku.setForeground(new java.awt.Color(153, 153, 153));
        jumlahBuku.setText("Jumlah Buku");
        jumlahBuku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jumlahBukuFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jumlahBukuFocusLost(evt);
            }
        });
        jumlahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBukuActionPerformed(evt);
            }
        });

        idPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPetugasActionPerformed(evt);
            }
        });

        cbnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnisActionPerformed(evt);
            }
        });

        kdbuku.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Kode Buku", "BIO", "dawd121", "NLV001", "NVL002" }));
        kdbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdbukuActionPerformed(evt);
            }
        });

        tanggalPinjam.setDateFormatString("d MMM, y");
        tanggalPinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggalPinjamMouseClicked(evt);
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
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(kodePeminjaman,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                250,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(15, 15, 15)
                                                                        .addComponent(cbnis,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                250,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(15, 15, 15)
                                                                        .addComponent(kdbuku,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                250,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(idPetugas,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                250,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(15, 15, 15)
                                                                                        .addComponent(kelas,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                250,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(tanggalPinjam,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(nama,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                250,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(15, 15, 15)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(judulBuku,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        250,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jumlahBuku,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        250,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(cari,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        233,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(btnCari))
                                                                .addComponent(jScrollPane1)))))
                                .addContainerGap(39, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnCari))
                                                .addGap(11, 11, 11))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(kodePeminjaman,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbnis, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(kdbuku, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(nama,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(judulBuku,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(tanggalPinjam,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jumlahBuku,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(idPetugas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(63, 63, 63)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSimpan)
                                        .addComponent(btnHapus)
                                        .addComponent(btnEdit)
                                        .addComponent(btnBersih)
                                        .addComponent(btnKeluar))
                                .addContainerGap(19, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tanggalPinjamMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tanggalPinjamMouseClicked
        // TODO add your handling code here:
        Date date = tanggalPinjam.getDate();

        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format "tahun-bulan-tanggal"
            nilaiTanggal = dateFormat.format(date);
            System.out.println(nilaiTanggal);
        } else {
            nilaiTanggal = "0000-00-00";
        }
    }// GEN-LAST:event_tanggalPinjamMouseClicked

    private void judulBukuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_judulBukuActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_judulBukuActionPerformed

    private void jumlahBukuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jumlahBukuActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jumlahBukuActionPerformed

    private void cbnisActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbnisActionPerformed
        // TODO add your handling code here:
        try {
            String Sql = "select * from siswa where nis='" + cbnis.getSelectedItem().toString() + "'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = state.executeQuery(Sql);
            while (pinjam.next()) {
                nama.setText(pinjam.getString("nama"));
                kelas.setText(pinjam.getString("kelas"));
            }
        } catch (Exception e) {

        }
    }// GEN-LAST:event_cbnisActionPerformed

    private void kdbukuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_kdbukuActionPerformed
        // TODO add your handling code here:
        try {
            String Sql = "select * from buku where kode_buku='" + kdbuku.getSelectedItem().toString() + "'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = state.executeQuery(Sql);
            while (pinjam.next()) {
                judulBuku.setText(pinjam.getString("judul_buku"));

            }
        } catch (Exception e) {

        }

    }// GEN-LAST:event_kdbukuActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        searchCredential();
    }// GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
        tanggal();

        // Memeriksa jumlah buku pada tabel buku
        String selectedBook = kdbuku.getSelectedItem().toString();
        int requestedQuantity = Integer.parseInt(jumlahBuku.getText());

        if (checkBookAvailability(selectedBook, requestedQuantity)) {
            try {
                Statement state = handler_class.Koneksi.konek().createStatement();
                String sql = "INSERT INTO peminjaman VALUES ('" + kodePeminjaman.getText() + "','" + nilaiTanggal
                        + "','" + cbnis.getSelectedItem() + "','" + nama.getText() + "','" + kelas.getText() + "','"
                        + selectedBook + "','" + judulBuku.getText() + "','" + requestedQuantity + "','"
                        + idPetugas.getSelectedItem() + "')";
                state.executeUpdate(sql);

                // Mengurangi jumlah buku di tabel buku
                updateBookQuantity(selectedBook, requestedQuantity);

                String pilihan[] = { "Print Sekarang", "Nanti" };
                int tny = JOptionPane.showOptionDialog(null, "Print Struk?", "", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
                if (tny == 0) {
                    try {
                        struk();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan" + e.getMessage());
            }
            load_table();
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah buku tidak mencukupi.");
        }
    }// GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "delete from peminjaman where kode_peminjaman= '" + kodePeminjaman.getText() + "'";
            state.executeUpdate(sql);
            int requestedQuantity = Integer.parseInt(jumlahBuku.getText());
            String selectedBook = kdbuku.getSelectedItem().toString();
            updateBookQuantity(selectedBook, -(requestedQuantity));
            JOptionPane.showMessageDialog(null, "Data Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus, Pinjaman Telah Dikembalikan");
        }
        load_table();
        kosong();
    }// GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        tanggal();
        try {
            int originalQuantity = getOriginalQuantityFromDatabase(kodePeminjaman.getText());
            Statement state = handler_class.Koneksi.konek().createStatement();
            String sql = "update peminjaman set tanggal_pinjam='" + nilaiTanggal + "',nis='"
                    + cbnis.getSelectedItem().toString() + "',nama='" + nama.getText() + "',kelas='" + kelas.getText()
                    + "',kode_buku='" + kdbuku.getSelectedItem() + "',judul_buku='" + judulBuku.getText()
                    + "',jumlah_buku='" + jumlahBuku.getText() + "',id_petugas='" + idPetugas.getSelectedItem()
                    + "' where kode_peminjaman='" + kodePeminjaman.getText() + "'";
            state.executeUpdate(sql);
            int requestedQuantity = Integer.parseInt(jumlahBuku.getText());
            String selectedBook = kdbuku.getSelectedItem().toString();
            updateBookQuantity(selectedBook, requestedQuantity-originalQuantity);
            JOptionPane.showMessageDialog(null, "Data Diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit");
        }
        load_table();
        kosong();
    }// GEN-LAST:event_btnEditActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        new Menu_utama().show();
        dispose();
    }// GEN-LAST:event_btnKeluarActionPerformed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBersihActionPerformed
        // TODO add your handling code here:
        kosong();
    }// GEN-LAST:event_btnBersihActionPerformed

    private void idPetugasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idPetugasActionPerformed
        // TODO add your handling code here:
        try {
            String Sql = "select * from petugas where id_petugas='" + idPetugas.getSelectedItem().toString() + "'";
            Statement state = handler_class.Koneksi.konek().createStatement();
            ResultSet pinjam = state.executeQuery(Sql);
        } catch (Exception e) {

        }
    }// GEN-LAST:event_idPetugasActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_namaActionPerformed

    private void tabledorMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tabledorMouseClicked
        // TODO add your handling code here:
        int baris = tabledor.rowAtPoint(evt.getPoint());
        String a = tabledor.getValueAt(baris, 0).toString();
        kodePeminjaman.setText(a);
        String b = tabledor.getValueAt(baris, 1).toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(b);
            tanggalPinjam.setDate(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String c = tabledor.getValueAt(baris, 2).toString();
        cbnis.setSelectedItem(c);
        String d = tabledor.getValueAt(baris, 3).toString();
        nama.setText(d);
        String e = tabledor.getValueAt(baris, 4).toString();
        kelas.setText(e);
        String f = tabledor.getValueAt(baris, 5).toString();
        kdbuku.setSelectedItem(f);
        String g = tabledor.getValueAt(baris, 6).toString();
        judulBuku.setText(g);
        String h = tabledor.getValueAt(baris, 7).toString();
        jumlahBuku.setText(h);
        String i = tabledor.getValueAt(baris, 8).toString();
        idPetugas.setSelectedItem(i);
    }// GEN-LAST:event_tabledorMouseClicked

    private void kodePeminjamanFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_kodePeminjamanFocusGained
        // TODO add your handling code here:
        if ("Kode Peminjaman".equals(kodePeminjaman.getText())) {
            kodePeminjaman.setText("");
            kodePeminjaman.setForeground(new Color(0, 0, 0));
        }
    }// GEN-LAST:event_kodePeminjamanFocusGained

    private void kodePeminjamanFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_kodePeminjamanFocusLost
        // TODO add your handling code here:
        if ("".equals(kodePeminjaman.getText())) {

            kodePeminjaman.setText("Kode Peminjaman");
            kodePeminjaman.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_kodePeminjamanFocusLost

    private void jumlahBukuFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jumlahBukuFocusGained
        // TODO add your handling code here:
        if ("Jumlah Buku".equals(jumlahBuku.getText())) {
            jumlahBuku.setText("");
            jumlahBuku.setForeground(new Color(0, 0, 0));
        }
    }// GEN-LAST:event_jumlahBukuFocusGained

    private void jumlahBukuFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jumlahBukuFocusLost
        // TODO add your handling code here:
        if ("".equals(jumlahBuku.getText())) {

            jumlahBuku.setText("Jumlah Buku");
            jumlahBuku.setForeground(new Color(153, 153, 153));
        }
    }// GEN-LAST:event_jumlahBukuFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

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
    private javax.swing.JComboBox<String> idPetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judulBuku;
    private javax.swing.JTextField jumlahBuku;
    private javax.swing.JComboBox<String> kdbuku;
    private javax.swing.JTextField kelas;
    private javax.swing.JTextField kodePeminjaman;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabledor;
    private com.toedter.calendar.JDateChooser tanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
