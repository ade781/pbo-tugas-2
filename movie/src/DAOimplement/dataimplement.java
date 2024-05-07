/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplement;

/**
 *
 * @author ad
 */
import java.util.List;
import model.*;
public interface dataimplement {

    public void insert(movie p);
    public void update(movie p);
    public void delete(String judul);
    public List<movie> getAll();
    void clear();
}
