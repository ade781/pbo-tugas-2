/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ad
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabelmovie extends AbstractTableModel{
    
    List<movie> dp;
    public modeltabelmovie(List<movie>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }
    
    @Override
    public int getColumnCount() {
         return 5;
    }

    @Override
    public String getColumnName(int column) {
    switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }  
    }

    @Override
    public Object getValueAt(int row, int column) {
    switch(column){
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getAlur();
            case 2:
                return dp.get(row).getPenokohan();
            case 3:
                return dp.get(row).getAkting();
            case 4:
                return dp.get(row).getNilai();
            default:
                return null;
        }     
    }
    
}
