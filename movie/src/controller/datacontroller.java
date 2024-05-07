/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ad
 */
import java.util.List;
import datamovieDAO.datamovieDAO;
import DAOimplement.dataimplement;
import model.*;
import movie.MainView;

public class datacontroller {
        MainView frame;
    dataimplement impldata;
    List<movie> dp;
    
    public datacontroller(MainView frame){
        this.frame = frame;
        impldata = new datamovieDAO();
        dp = impldata.getAll();
    }
    public void isitabel(){
        dp = impldata.getAll();
        modeltabelmovie mp = new modeltabelmovie(dp);
        frame.getTabelData().setModel(mp);
    }
    
     public void insert(){
        movie dp = new movie();
        dp.setJudul(frame.getjTextJudul().getText());
        dp.setAlur(Double.parseDouble(frame.getjTextAlur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getjTextPenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getjTextAkting().getText()));
        double nilaiRating = (dp.getAlur() + dp.getPenokohan() + dp.getAkting()) / 3;
        dp.setNilai(nilaiRating);
        impldata.insert(dp);
        
    }
   
     public void update(){
        movie dp = new movie();
        dp.setJudul(frame.getjTextJudul().getText());
        dp.setAlur(Double.parseDouble(frame.getjTextAlur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getjTextPenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getjTextAkting().getText()));
        double nilaiRating = (dp.getAlur() + dp.getPenokohan() + dp.getAkting()) / 3;
        dp.setNilai(nilaiRating);
        impldata.update(dp);
    }
     
     public void delete(){
        String judul = (frame.getjTextJudul().getText());
        impldata.delete(judul);
    }
}
