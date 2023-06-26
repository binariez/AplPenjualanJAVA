/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 *
 * @author Raaa
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksikedatabase;
import java.sql.Date;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransaksiPenjualan extends javax.swing.JFrame {

    public String tanggal;
    private String sql;
    private PreparedStatement ps = null;
    /**
     * Creates new form TransaksiPenjualan
     */
    public TransaksiPenjualan() {
        initComponents();
        tampilkanDataPelanggan();
        tampilkanDataBarang();
        tampilkanDataTransaksiJual();
    }
    
    private void tampilkanDataTransaksiJual()
    {
        try{
        String sql = "SELECT * FROM relasijual";
        PreparedStatement ps = null;
        Object [] row = {"ID Transaksi", "No. Transaksi", "Tanggal", "Kode Plg", "Nama Plg", "Alamat", "Telp", 
            "Kode Barang", "Nama Barang", "Satuan", "Harga Jual", "Stok", "Jml Jual", "Jml Harga"};
        DefaultTableModel dtm = new DefaultTableModel(null, row);
            tblTransaksi.setModel(dtm);
            jScrollPane3.setEnabled(true);
            jScrollPane3.setBorder(null);
            jScrollPane3.setViewportView( tblTransaksi);
        ResultSet rs = null;
        ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
        rs = ps.executeQuery();
            while(rs.next()){
                String idtransaksi = rs.getString(1);
                String nomotransaksi = rs.getString(2);
                String tanggal = rs.getString(3);
                String kodepel = rs.getString(4);
                String namapel = rs.getString(5);
                String alamat = rs.getString(6);
                String telp = rs.getString(7);
                String kodebarang = rs.getString(8);
                String namabarang = rs.getString(9);
                String satuan = rs.getString(10);
                String hargajual = rs.getString(13);
                String stok = rs.getString(14);
                String jmljual = rs.getString(15);
                String jmlharga = rs.getString(16);
                
                String [] baris = {idtransaksi, nomotransaksi, tanggal, kodepel, namapel, alamat, telp, 
                    kodebarang, namabarang, satuan, hargajual, stok, jmljual, jmlharga};
                dtm.addRow(baris);
            }
        } catch (Exception e){}
    }
    
    private void tampilkanDataBarang()
    {
        try{
        String sql = "SELECT * FROM tbl_barang";
        PreparedStatement ps = null;
        Object [] row = {"Kode Barang","Nama Barang","Satuan","Jenis Barang","Harga Beli","Harga Jual","Stok"};
        DefaultTableModel dtm = new DefaultTableModel(null, row);
            tblBarang.setModel(dtm);
            jScrollPane2.setEnabled(true);
            jScrollPane2.setBorder(null);
            jScrollPane2.setViewportView( tblBarang);
        ResultSet rs = null;
        ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
        rs = ps.executeQuery();
            while(rs.next()){
                String kodebarang = rs.getString(1);
                String namabarang = rs.getString(2);
                String satuan = rs.getString(3);
                String jenisbarang = rs.getString(4);
                String hargabeli = rs.getString(5);
                String hargajual = rs.getString(6);
                String stok = rs.getString(7);
                
                String [] baris = {kodebarang,namabarang,satuan,jenisbarang,hargabeli,hargajual,stok};
                dtm.addRow(baris);
            }
        } catch (Exception e){}
    }
    
    private void tampilkanDataPelanggan()
    {
        try{
            String sql = "SELECT * FROM tbl_pelanggan";
            PreparedStatement ps = null;
            Object [] row = {"Kode Pelanggan","Nama Pelanggan","Alamat","Telepon"};
            DefaultTableModel dtm = new DefaultTableModel(null, row);
                tblPelanggan.setModel(dtm);
                jScrollPane1.setEnabled(true);
                jScrollPane1.setBorder(null);
                jScrollPane1.setViewportView( tblPelanggan);
            ResultSet rs = null;
            ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
            rs = ps.executeQuery();
                while(rs.next()){
                    String kodepelanggan = rs.getString(1);
                    String namapelanggan = rs.getString(2);
                    String alamat = rs.getString(3);
                    String telp = rs.getString(4);

                    String [] baris = {kodepelanggan,namapelanggan,alamat,telp};
                    dtm.addRow(baris);
                }
        } catch (Exception e){}
    }
    
    private void cariDataPelanggan(){
        try{
            String search = txtCariDataPelanggan.getText();
            String sql = "SELECT * FROM tbl_pelanggan WHERE kdpel LIKE '%"+search+"%' OR nmpel like'%"+search+"%'";
            PreparedStatement ps = null;
            Object [] row = {"Kode Pelanggan","Nama Pelanggan","Alamat","Telepon"};
            DefaultTableModel dtm = new DefaultTableModel(null, row);
                tblPelanggan.setModel(dtm);
                jScrollPane1.setEnabled(true);
                jScrollPane1.setBorder(null);
                jScrollPane1.setViewportView( tblPelanggan);
            ResultSet rs = null;
            ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
            rs = ps.executeQuery();
            while(rs.next()){
                    String kodepelanggan = rs.getString(1);
                    String namapelanggan = rs.getString(2);
                    String alamat = rs.getString(3);
                    String telp = rs.getString(4);

                    String [] baris = {kodepelanggan,namapelanggan,alamat,telp};
                    dtm.addRow(baris);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Data yang anda cari tidak dapat ditemukan, " + e.getMessage());
        }
    }
    
    private void cariDataBarang(){
        try{
            String search = txtCariDataBarang.getText();
            String sql = "SELECT * FROM tbl_barang WHERE kdbrg LIKE '%"+search+"%' OR nmbrg like'%"+search+"%'";
            PreparedStatement ps = null;
            Object [] row = {"Kode Barang","Nama Barang","Satuan","Jenis Barang","Harga Beli","Harga Jual","Stok"};
            DefaultTableModel dtm = new DefaultTableModel(null, row);
                tblBarang.setModel(dtm);
                jScrollPane2.setEnabled(true);
                jScrollPane2.setBorder(null);
                jScrollPane2.setViewportView( tblBarang);
            ResultSet rs = null;
            ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
            rs = ps.executeQuery();
            while(rs.next()){
                    String kodebarang = rs.getString(1);
                    String namabarang = rs.getString(2);
                    String satuan = rs.getString(3);
                    String jenisbarang = rs.getString(4);
                    String hargabeli = rs.getString(5);
                    String hargajual = rs.getString(6);
                    String stok = rs.getString(7);

                    String [] baris = {kodebarang,namabarang,satuan,jenisbarang,hargabeli,hargajual,stok};
                    dtm.addRow(baris);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Data yang anda cari tidak dapat ditemukan, " + e.getMessage());
        }
    }
    
    private void cariDataTransaksi(){
        try{
            String search = txtCariDataTransaksi.getText();
            String sql = "SELECT * FROM relasijual WHERE id_transaksi LIKE '%"+search+"%' OR kdpel like'%"+search+"%'";
            PreparedStatement ps = null;
            Object [] row = {"ID Transaksi", "No. Transaksi", "Tanggal", "Kode Plg", "Nama Plg", "Alamat", "Telp", 
                            "Kode Barang", "Nama Barang", "Satuan", "Harga Jual", "Stok", "Jml Jual", "Jml Harga"};
            DefaultTableModel dtm = new DefaultTableModel(null, row);
                tblBarang.setModel(dtm);
                jScrollPane3.setEnabled(true);
                jScrollPane3.setBorder(null);
                jScrollPane3.setViewportView( tblBarang);
            ResultSet rs = null;
            ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);   
            rs = ps.executeQuery();
            while(rs.next()){
                    String idtransaksi = rs.getString(1);
                    String nomotransaksi = rs.getString(2);
                    String tanggal = rs.getString(3);
                    String kodepel = rs.getString(4);
                    String namapel = rs.getString(5);
                    String alamat = rs.getString(6);
                    String telp = rs.getString(7);
                    String kodebarang = rs.getString(8);
                    String namabarang = rs.getString(9);
                    String satuan = rs.getString(10);
                    String hargajual = rs.getString(13);
                    String stok = rs.getString(14);
                    String jmljual = rs.getString(15);
                    String jmlharga = rs.getString(16);

                    String [] baris = {idtransaksi, nomotransaksi, tanggal, kodepel, namapel, alamat, telp, 
                        kodebarang, namabarang, satuan, hargajual, stok, jmljual, jmlharga};
                    dtm.addRow(baris);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Data yang anda cari tidak dapat ditemukan, " + e.getMessage());
        }
    }
    
    private void bersihkandata()
    {
        txtIdTransaksi.setText("");
        txtNoTrans.setText("");
        txtKodePlg.setText("");
        txtNamaPlg.setText("");
        txtAlamat.setText("");
        txtTelp.setText("");
        txtKodeBrg.setText("");
        txtNamaBrg.setText("");
        txtSatuan.setText("");
        txtHrgJual.setText("");
        txtStok.setText("");
        txtJmlJual.setText("");
        txtJmlHrg.setText("");
        txtCariDataBarang.setText("");
        txtCariDataPelanggan.setText("");
        txtCariDataTransaksi.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNoTrans = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dtTglTrans = new com.toedter.calendar.JCalendar();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtTelp = new javax.swing.JTextField();
        txtKodePlg = new javax.swing.JTextField();
        txtCariDataPelanggan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtNamaPlg = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtKodeBrg = new javax.swing.JTextField();
        txtNamaBrg = new javax.swing.JTextField();
        txtSatuan = new javax.swing.JTextField();
        txtHrgJual = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtJmlJual = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtJmlHrg = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        txtCariDataBarang = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtCariDataTransaksi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Input Data Transaksi Penjualan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Id. Transaksi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(txtIdTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("No. Transaksi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel1.add(txtNoTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tgl. Transaksi");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        dtTglTrans.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtTglTransPropertyChange(evt);
            }
        });
        jPanel1.add(dtTglTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 330, 240));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Kode Pelanggan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nama Pelanggan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Telepon");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Alamat");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel2.add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 270, -1));
        jPanel2.add(txtTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));
        jPanel2.add(txtKodePlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, -1));

        txtCariDataPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariDataPelangganKeyPressed(evt);
            }
        });
        jPanel2.add(txtCariDataPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 160, -1));

        jButton1.setText("Cari Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelanggan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 290, 150));

        jLabel9.setText("Pencarian Data Pelanggan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));
        jPanel2.add(txtNamaPlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 150, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 710, 240));

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nama Barang");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Satuan");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Harga Jual");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Kode Barang");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Stok");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel3.add(txtKodeBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, -1));
        jPanel3.add(txtNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 200, -1));
        jPanel3.add(txtSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, -1));
        jPanel3.add(txtHrgJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 70, -1));
        jPanel3.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 70, -1));

        jButton2.setText("Cari Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Jumlah Jual");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        txtJmlJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJmlJualKeyReleased(evt);
            }
        });
        jPanel3.add(txtJmlJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 70, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Jumlah Harga");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));
        jPanel3.add(txtJmlHrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 100, -1));

        jLabel17.setText("Pencarian Data Barang");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBarang);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 420, 140));

        txtCariDataBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariDataBarangKeyPressed(evt);
            }
        });
        jPanel3.add(txtCariDataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 160, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 1040, 210));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel4.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel4.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 1040, 50));

        jLabel18.setText("Pencarian Data Transaksi");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        txtCariDataTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariDataTransaksiKeyPressed(evt);
            }
        });
        getContentPane().add(txtCariDataTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, 160, -1));

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTransaksi);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 1040, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        bersihkandata();
        tampilkanDataTransaksiJual();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        int selectedRow = tblPelanggan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tblPelanggan.getModel();
        txtKodePlg.setText(model.getValueAt(selectedRow, 0).toString());
        txtNamaPlg.setText(model.getValueAt(selectedRow, 1).toString());
        txtAlamat.setText(model.getValueAt(selectedRow, 2).toString());
        txtTelp.setText(model.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        int selectedRow = tblBarang.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tblBarang.getModel();
        txtKodeBrg.setText(model.getValueAt(selectedRow, 0).toString());
        txtNamaBrg.setText(model.getValueAt(selectedRow, 1).toString());
        txtSatuan.setText(model.getValueAt(selectedRow, 2).toString());
        txtHrgJual.setText(model.getValueAt(selectedRow, 5).toString());
        txtStok.setText(model.getValueAt(selectedRow, 6).toString());
    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int keluar = JOptionPane.showConfirmDialog(null, "Keluar Program? ","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(keluar == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtCariDataPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDataPelangganKeyPressed
        cariDataPelanggan();
    }//GEN-LAST:event_txtCariDataPelangganKeyPressed

    private void txtCariDataBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDataBarangKeyPressed
        cariDataBarang();
    }//GEN-LAST:event_txtCariDataBarangKeyPressed

    private void txtCariDataTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDataTransaksiKeyPressed
        cariDataTransaksi();
    }//GEN-LAST:event_txtCariDataTransaksiKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Form.CariDataBarang().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Form.CariDataPelanggan().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dtTglTransPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtTglTransPropertyChange
        try
        {
            if(dtTglTrans.getDate()!=null){
                String ubahtanggal = "yyyy/MM/dd";
                SimpleDateFormat format = new SimpleDateFormat(ubahtanggal);
                tanggal = String.valueOf(format.format(dtTglTrans.getDate()));
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_dtTglTransPropertyChange

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        int row = tblTransaksi.getSelectedRow();
        txtIdTransaksi.setText(tblTransaksi.getModel().getValueAt(row, 0).toString());
        txtNoTrans.setText(tblTransaksi.getModel().getValueAt(row, 1).toString());
        
        //tanggal
        String tgl = (String) tblTransaksi.getModel().getValueAt(row, 2);
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = format.parse(tgl);
            dtTglTrans.setDate(d);
        }catch(ParseException ex){
            
        }
        
        txtKodePlg.setText(tblTransaksi.getModel().getValueAt(row, 3).toString());
        txtNamaPlg.setText(tblTransaksi.getModel().getValueAt(row, 4).toString());
        txtAlamat.setText(tblTransaksi.getModel().getValueAt(row, 5).toString());
        txtTelp.setText(tblTransaksi.getModel().getValueAt(row, 6).toString());
        txtKodeBrg.setText(tblTransaksi.getModel().getValueAt(row, 7).toString());
        txtNamaBrg.setText(tblTransaksi.getModel().getValueAt(row, 8).toString());
        txtSatuan.setText(tblTransaksi.getModel().getValueAt(row, 9).toString());  
        txtHrgJual.setText(tblTransaksi.getModel().getValueAt(row, 10).toString());
        txtJmlJual.setText(tblTransaksi.getModel().getValueAt(row, 12).toString());
        txtJmlHrg.setText(tblTransaksi.getModel().getValueAt(row, 13).toString());
        
        String stokbarang1;
        Integer stokbarang2, jumlahjual, returnstok;
        stokbarang1 = (String) tblTransaksi.getModel().getValueAt(row, 11);
        jumlahjual = Integer.parseInt(txtJmlJual.getText());
        stokbarang2 = Integer.parseInt(stokbarang1);
        returnstok = (jumlahjual+stokbarang2);
        txtStok.setText(String.valueOf(returnstok));
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void txtJmlJualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJmlJualKeyReleased
        Integer stokbrg, hrgjual, jmljual, jmlharga;
        String jumlah;
        
        stokbrg = Integer.parseInt(txtStok.getText());
        hrgjual = Integer.parseInt(txtHrgJual.getText());
        jmljual = Integer.parseInt(txtJmlJual.getText());
        jumlah = String.valueOf(txtHrgJual.getText());
        
        if(jumlah.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Jumlah barang kosong");
            txtKodeBrg.setText("");
            txtNamaBrg.setText("");
            txtSatuan.setText("");
            txtHrgJual.setText("");
            txtStok.setText("");
            txtJmlJual.setText("");
            txtJmlHrg.setText("");
        }
        else{
            if(stokbrg < jmljual){
                JOptionPane.showMessageDialog(rootPane, "Jumlah barang tidak mencukupi");
                txtKodeBrg.setText("");
                txtNamaBrg.setText("");
                txtSatuan.setText("");
                txtHrgJual.setText("");
                txtStok.setText("");
                txtJmlJual.setText("");
                txtJmlHrg.setText("");
            }
            else{
                jmlharga=(hrgjual*jmljual);
                txtJmlHrg.setText(String.valueOf(jmlharga));
            }
        }
        
    }//GEN-LAST:event_txtJmlJualKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            if (((txtNoTrans.getText().equals(""))
              || (txtKodePlg.getText().equals(""))
              || (txtKodeBrg.getText().equals(""))
              || (txtJmlJual.getText().equals(""))
              || (txtStok.getText().equals(""))))
            {
                JOptionPane.showMessageDialog(rootPane, "Lengkapi data dengan benar terlebih dahulu!");
            }
            else{
                String sqlA = "SELECT * FROM tbl_transaksi WHERE no_transaksi='" +txtNoTrans.getText()+ "' AND kdbrg='" +txtKodeBrg.getText()+ "'";
                ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sqlA);
                ResultSet rs = ps.executeQuery(sqlA);
                System.out.println(rs.first());
                if(rs.first() == true){
                    JOptionPane.showMessageDialog(rootPane, "Data sudah ada!");
                }
                else{
                    String sqlB = "INSERT INTO tbl_transaksi(no_transaksi, tgltrans, kdpel, kdbrg, jmljual, jmlhrg) VALUES"+
                            "('" +txtNoTrans.getText()+
                            "','" +tanggal+
                            "','" +txtKodePlg.getText()+
                            "','" +txtKodeBrg.getText()+
                            "','" +txtJmlJual.getText()+
                            "','" +txtJmlHrg.getText()+ "')";
                    ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sqlB);
                    ps.executeUpdate(sqlB);
                    JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan!");
                    
                    Integer stokbarang, jumlahjual, sisastok;
                    stokbarang = Integer.parseInt(txtStok.getText());
                    jumlahjual = Integer.parseInt(txtJmlJual.getText());
                    
                    sisastok = (stokbarang-jumlahjual);
                    sql = "UPDATE tbl_barang SET stok='" +sisastok+ "' WHERE kdbrg='" +txtKodeBrg.getText()+ "'";
                    ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);
                    ps.executeUpdate(sql);
                    
                    txtKodeBrg.setText("");
                    txtNamaBrg.setText("");
                    txtSatuan.setText("");
                    txtHrgJual.setText("");
                    txtStok.setText("");
                    txtJmlJual.setText("");
                    txtJmlHrg.setText("");
                    
                    tampilkanDataTransaksiJual();
                    tampilkanDataBarang();
                    
                }
            }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Cek lagi sistem! " +e.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            if (((txtNoTrans.getText().equals(""))
              || (txtKodePlg.getText().equals(""))
              || (txtKodeBrg.getText().equals(""))
              || (txtJmlJual.getText().equals(""))
              || (txtStok.getText().equals(""))))
            {
                JOptionPane.showMessageDialog(rootPane, "Pilih data yang akan di edit");
            }
            else{
                sql = "UPDATE tbl_transaksi SET no_transaksi='" +txtNoTrans.getText()+ 
                        "',tgltrans='" +tanggal+
                        "',kdpel='" +txtKodePlg.getText()+
                        "',kdbrg='" +txtKodeBrg.getText()+
                        "',jmljual='" +txtJmlJual.getText()+
                        "',jmlhrg='" +txtJmlHrg.getText()+
                        "' WHERE id_transaksi='" +txtIdTransaksi.getText() +"'";
                ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(rootPane, "Data berhasil di edit");
                
                Integer stokbarang, jumlahjual, sisastok;
                stokbarang = Integer.parseInt(txtStok.getText());
                jumlahjual = Integer.parseInt(txtJmlJual.getText());
                    
                sisastok = (stokbarang-jumlahjual);
                sql = "UPDATE tbl_barang SET stok='" +sisastok+ "' WHERE kdbrg='" +txtKodeBrg.getText()+ "'";
                ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);
                ps.executeUpdate(sql);
                   
                tampilkanDataTransaksiJual();
                tampilkanDataBarang();
                bersihkandata();
            }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Cek lagi sistem! " +e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            if (((txtNoTrans.getText().equals(""))
              || (txtKodePlg.getText().equals(""))
              || (txtKodeBrg.getText().equals(""))
              || (txtJmlJual.getText().equals(""))
              || (txtStok.getText().equals(""))))
            {
                JOptionPane.showMessageDialog(rootPane, "Pilih data yang akan di delete");
            }
            else{
                sql = "UPDATE tbl_barang SET stok='" +txtStok.getText()+ "' WHERE kdbrg='" +txtKodeBrg.getText()+ "'";
                ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);
                ps.executeUpdate(sql);
                tampilkanDataBarang();
                
                PreparedStatement ps = null;
                String sql = "DELETE FROM tbl_transaksi WHERE id_transaksi='"+txtIdTransaksi.getText()+"'";
                ps = koneksikedatabase.ambilKoneksiDatabase().prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil di hapus");
                tampilkanDataTransaksiJual();
                bersihkandata();
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JCalendar dtTglTrans;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTable tblTransaksi;
    public javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCariDataBarang;
    private javax.swing.JTextField txtCariDataPelanggan;
    private javax.swing.JTextField txtCariDataTransaksi;
    public javax.swing.JTextField txtHrgJual;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtJmlHrg;
    private javax.swing.JTextField txtJmlJual;
    public javax.swing.JTextField txtKodeBrg;
    public javax.swing.JTextField txtKodePlg;
    public javax.swing.JTextField txtNamaBrg;
    public javax.swing.JTextField txtNamaPlg;
    private javax.swing.JTextField txtNoTrans;
    public javax.swing.JTextField txtSatuan;
    public javax.swing.JTextField txtStok;
    public javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
