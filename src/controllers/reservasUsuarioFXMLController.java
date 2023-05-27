/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Booking;
import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author david
 */
public class reservasUsuarioFXMLController implements Initializable {

    @FXML
    private DatePicker picker;
    @FXML
    private Text errorHora;
    @FXML
    private Button GoBack;
    @FXML
    private ListView<String> lvPista1;
    @FXML
    private ListView<String> lvPista2;
    @FXML
    private ListView<String> lvPista3;
    @FXML
    private ListView<String> lvPista4;
    @FXML
    private ListView<String> lvPista5;
    @FXML
    private ListView<String> lvPista6;
    
    private Club club;
    private String login;
    private String contra;
    private Member user;
    @FXML
    private Button eliminar;
    private eliminarReservaUsuarioFXMLController controller;
    private reservasUsuarioFXMLController thiscontroller;
    private Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(reservasUsuarioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reservasUsuarioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        picker.setValue(LocalDate.now());
        inicializarListView();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/eliminarReserva/eliminarReservaUsuarioFXML.fxml")); 
        Parent root;
        try {
            root = loader.load();
            controller = loader.getController();
            
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(reservasUsuarioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    
    public void init(String log, String pass, reservasUsuarioFXMLController controller){
        this.login = log;
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
        thiscontroller = controller;
       inicializarListView();
    }

    @FXML
    private void inicializarListView() {
        
        List<Booking> reservaPista = club.getForDayBookings(picker.getValue());
        
        ObservableList<String> reservasPista1 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista2 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista3 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista4 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista5 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista6 = FXCollections.observableArrayList();
        
        
        for(int i = 0; i < reservaPista.size();i++){
            switch (reservaPista.get(i).getCourt().getName().toUpperCase().replace(" ","")) {
                case "PISTA1":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista1.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA2":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista2.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA3":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista3.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA4":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista4.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA5":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista5.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA6":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista6.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                default:
                    System.out.println("Pista no encontrada:" + reservaPista.get(i).getCourt().getName().toUpperCase().trim() );
                       
            }
        }
        lvPista1.setItems(reservasPista1);
        lvPista2.setItems(reservasPista2);
        lvPista3.setItems(reservasPista3);
        lvPista4.setItems(reservasPista4);
        lvPista5.setItems(reservasPista5);
        lvPista6.setItems(reservasPista6);
        
        
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu/menuFXML.fxml")); 
            Parent root = loader.load();
            menuFXMLController controller = loader.getController();
            controller.init(login, contra);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) GoBack.getScene().getWindow();
            myStage.close();
            
            
            if((this.controller.getMyStage().isShowing())){
                this.stage.close();
            }
    }

    @FXML
    private void eliminarReserva(ActionEvent event) throws IOException {
            
            
            if(!(controller.getMyStage().isShowing())){
                   
                
                
                controller.init(login, contra, thiscontroller);
                stage.show();
            }
           
            
    }
    
    
    public void inicializarListViewPicker(LocalDate value) {
        
        List<Booking> reservaPista = club.getForDayBookings(value);
        
        ObservableList<String> reservasPista1 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista2 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista3 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista4 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista5 = FXCollections.observableArrayList();
        ObservableList<String> reservasPista6 = FXCollections.observableArrayList();
        
        
        for(int i = 0; i < reservaPista.size();i++){
            switch (reservaPista.get(i).getCourt().getName().toUpperCase().replace(" ","")) {
                case "PISTA1":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista1.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA2":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista2.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA3":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista3.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA4":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista4.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA5":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista5.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                case "PISTA6":
                    if(reservaPista.get(i).getMember().getNickName().equals(login))
                        reservasPista6.add(reservaPista.get(i).getFromTime().getHour()+":00h - "+ (reservaPista.get(i).getFromTime().getHour() + 1) +":00h" + "\n" +reservaPista.get(i).getMember().getNickName());
                    break;
                default:
                    System.out.println("Pista no encontrada:" + reservaPista.get(i).getCourt().getName().toUpperCase().trim() );
                       
            }
        }
        lvPista1.setItems(reservasPista1);
        lvPista2.setItems(reservasPista2);
        lvPista3.setItems(reservasPista3);
        lvPista4.setItems(reservasPista4);
        lvPista5.setItems(reservasPista5);
        lvPista6.setItems(reservasPista6);
        
        
    }
    
    
    
}
