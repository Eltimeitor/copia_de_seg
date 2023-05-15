/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Club;
import model.ClubDAOException;
import model.Court;
import model.Member;

/**
 * FXML Controller class
 *
 * @author david
 */
public class reservaFXMLController implements Initializable {

    @FXML
    private Text numPistas;
    @FXML
    private Button reservar1;
    @FXML
    private Button reservar2;
    @FXML
    private Button reservar3;
    @FXML
    private Button reservar4;
    @FXML
    private Button reservar5;
    @FXML
    private Button reservar6;
    @FXML
    private Text pista1;
    @FXML
    private Text pista2;
    @FXML
    private Text pista3;
    @FXML
    private Text pista4;
    @FXML
    private Text pista5;
    @FXML
    private Text pista6;
    
    private Club club;
    private String login;
    private String contra;
    private Member user;

    private Court court;
    private LocalDateTime bookingDate;
    private LocalDate madeForDay;
    private LocalTime fromTime;
    @FXML
    private DatePicker picker;
    @FXML
    private ImageView imgpista1;
    @FXML
    private ImageView imgpista2;
    @FXML
    private ImageView imgpista3;
    @FXML
    private ImageView imgpista5;
    @FXML
    private ImageView imgpista6;
    @FXML
    private ImageView imgpista4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            club = club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        club.addSimpleData();
       
        
        
        
        
    }    

    @FXML
    private void reservar(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        
    }
    
    public void init(String log, String pass){
        this.login = log;
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
    }

    @FXML
    private void reservar2(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
    }

    @FXML
    private void reservar3(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
    }
    

    @FXML
    private void reservar4(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
    }

    @FXML
    private void reservar5(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
    }

    @FXML
    private void reservar6(ActionEvent event) throws ClubDAOException {
        boolean paid = user.checkHasCreditInfo();
        
        club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
    }

    @FXML
    private void pick(ActionEvent event) {
        
    }
    
}
