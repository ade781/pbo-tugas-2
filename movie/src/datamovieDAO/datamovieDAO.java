/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamovieDAO;

/**
 *
 * @author ad
 */
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.dataimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class datamovieDAO implements dataimplement{
    Connection connection;
    
    final String select = "select * from movie;";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie set alur=?, penokohan=?, akting=?, nilai =? WHERE judul=?";
    final String delete = "DELETE from movie where judul=?";
    public datamovieDAO(){
        connection = connector.connection();
    }

@Override
public void insert(movie p) {
    PreparedStatement statement = null;
    try {
        // Validasi input
        if (p.getAlur() < 0 || p.getAlur() > 5 || p.getPenokohan() < 0 || p.getPenokohan() > 5 || p.getAkting() < 0 || p.getAkting() > 5) {
            JOptionPane.showMessageDialog(null, "rating harus berada dalam rentang 0-5", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika ada kesalahan
        }
        
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, p.getJudul());
        statement.setDouble(2, p.getAlur());
        statement.setDouble(3, p.getPenokohan());
        statement.setDouble(4, p.getAkting());
        double nilaiRating = (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3;
        statement.setDouble(5, nilaiRating);
        
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            p.setJudul(rs.getString(1));
        }
        JOptionPane.showMessageDialog(null, "Data film sukses ditambahkan", "COMPLETE", JOptionPane.PLAIN_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


    @Override
    public void update(movie p) {
            PreparedStatement statement = null;
            try {
                // Validasi input
                if (p.getAlur() < 0 || p.getAlur() > 5 || p.getPenokohan() < 0 || p.getPenokohan() > 5 || p.getAkting() < 0 || p.getAkting() > 5) {
                    JOptionPane.showMessageDialog(null, "rating harus berada dalam rentang 0-5", "masukan rating yang benar", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                statement = connection.prepareStatement(update);
                statement.setDouble(1, p.getAlur());
                statement.setDouble(2, p.getPenokohan());
                statement.setDouble(3, p.getAkting());
                double nilaiRating = (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3;
                statement.setDouble(4, nilaiRating);
                statement.setString(5, p.getJudul());

                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<movie> getAll() {
        List<movie> dp = null;
        try{
            dp = new ArrayList<movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                movie fl = new movie();
                fl.setJudul(rs.getString("judul"));
                fl.setAlur(rs.getDouble("Alur"));
                fl.setPenokohan(rs.getDouble("Penokohan"));
                fl.setAkting(rs.getDouble("Akting"));
                fl.setNilai(rs.getDouble("Nilai"));
                dp.add(fl);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dp;
    }
    
    @Override
public void clear() {
    try {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM movie");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

