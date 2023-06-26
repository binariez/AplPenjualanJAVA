/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

/**
 *
 * @author Raaa
 */
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksikedatabase {
    private static Connection koneksi_db = null;
    public static Connection ambilKoneksiDatabase(){
        MysqlDataSource db_jual = new MysqlDataSource();
            db_jual.setDatabaseName("dbjual");
            db_jual.setPassword("");
            db_jual.setUser("root");
                try{
                    koneksi_db = db_jual.getConnection();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Koneksi gagal, silakan cek koneksi anda terlebih dahulu!"+e.getMessage());
                }
                return koneksi_db;
    }
}
