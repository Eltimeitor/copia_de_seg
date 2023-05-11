/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Member;
import model.Club;
import model.ClubDAO;
import model.ClubDAOException; 

/**
 * FXML Controller class
 *
 * @author david
 */
public class InicioFXMLController implements Initializable {

    @FXML
    private Text textouser;
    @FXML
    private ImageView imagenuser;
    private Image avatar;
    
    private String login;
    private String contra;
    Member user;
    
    private Club club;
    
    private List<Member> miembros = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            club = club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(InicioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }    
    
    
    public void init(String log, String pass){
        this.login = log;
        textouser.setText(login);
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
        imagenuser.setImage(user.getImage());
        String k = user.getImage().getUrl();
        System.out.println(k);
    }
    
    
}
