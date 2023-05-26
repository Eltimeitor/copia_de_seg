/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Booking;
import model.Club;
import model.ClubDAOException;
import model.Court;
import model.Member;

/**
 * FXML Controller class
 *
 * @author david
 */
public class reservasFXMLController implements Initializable {

    @FXML
    private Button GoBack;
    @FXML
    private DatePicker picker;
    @FXML
    private TextField hora;
    @FXML
    private Text errorHora;
    @FXML
    private ImageView imgpista1;
    @FXML
    private ImageView imgpista2;
    @FXML
    private ImageView imgpista3;
    @FXML
    private ImageView imgpista4;
    @FXML
    private ImageView imgpista5;
    @FXML
    private ImageView imgpista6;
    
    private String login;
    
    private String contra;
    
    private Club club;
    
    private Member user;
    @FXML
    private Text rp1;
    @FXML
    private Text rp2;
    @FXML
    private Text rp3;
    @FXML
    private Text rp4;
    @FXML
    private Text rp5;
    @FXML
    private Text rp6;
    
    private List<Booking> reservas;
    @FXML
    private TextField userRes;
    @FXML
    private Text rp11;
    @FXML
    private Text rp21;
    @FXML
    private Text rp31;
    @FXML
    private Text rp41;
    @FXML
    private Text rp51;
    @FXML
    private Text rp61;
    
    private int cont = 0;
    @FXML
    private Button siguiente;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(reservasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reservasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        siguiente.setVisible(false);
        
        
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
    }

    @FXML
    private void pick(ActionEvent event) {
        LocalDate l = null;
        if(!hora.getText().equals("") && picker.getValue().equals(l))
        actualizarR();
    }

    @FXML
    private void dosPuntos(KeyEvent event) {
        
        String texto = hora.getText();
        
        
        if(!texto.contains(":00")){
        texto = texto + ":00";
        hora.setText(texto);
        errorHora.setText("");
        }
        
        
        else if(texto.length() == 4){
           texto = hora.getText();
           texto = texto.charAt(1) + texto.charAt(0) + ":00";
           
           hora.setText(texto);
        }
        if(texto.length()> 5){
           texto = hora.getText();
           errorHora.setText("");
           hora.setText("");
           }
        int horav = 0;
        if(texto.length() == 5){
            texto = hora.getText();
            char num1 = texto.charAt(0);
            char num2 = texto.charAt(1);
            horav = Character.getNumericValue(num1)*10 + Character.getNumericValue(num2);
        }
        if(horav > 24){
            errorHora.setText("Error, hora invalida");
        }
        
        if(picker.getValue()!= null && !hora.getText().equals("") && hora.getText().length() > 3)
        actualizarR();
    }
    
    
    
    public void init(String log, String pass){
        this.login = log;
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
        System.out.println(club.getBookings().get(0).getBookingDate().getHour());
        System.out.println(club.getBookings().get(0).getBookingDate().getDayOfWeek());
        System.out.println(club.getBookings().get(0).getCourt().getName());

    }
    
    private void actualizarR(){
        if(reservas == null){
        reservas = club.getBookings();
        }
        
        rp1.setText("No Reservado");
        rp11.setText("Nadie");
        rp2.setText("No Reservado");
        rp21.setText("Nadie");
        rp3.setText("No Reservado");
        rp31.setText("Nadie");
        rp4.setText("No Reservado");
        rp41.setText("Nadie");
        rp5.setText("No Reservado");
        rp51.setText("Nadie");
        rp6.setText("No Reservado");
        rp61.setText("Nadie");
        
        for(int i = 0; i < reservas.size(); i++){
            LocalDate aux1 = reservas.get(i).getMadeForDay();
            LocalTime aux2 = reservas.get(i).getFromTime();
            Court aux3 = reservas.get(i).getCourt();
            String aux = reservas.get(i).getMember().getNickName();
            if(aux1.equals(picker.getValue())){
                int horav = 0;
                
                if(hora.getText().length() == 5){
                char num1 = hora.getText().charAt(0);
                char num2 = hora.getText().charAt(1);
                horav = Character.getNumericValue(num1)*10 + Character.getNumericValue(num2);
                }
                else if(hora.getText().length() == 4)
                    horav = Character.getNumericValue(hora.getText().charAt(0));
                if(horav > 23) break;
                if(aux2.equals(LocalTime.of(horav,0))){
                    String pista = "";
                    List<Court> pistas = club.getCourts();
                    pista = pistas.get(0).getName().toString();
                    switch(aux3.getName()){
                        case "": 
                            rp1.setText("Reservado");
                            rp11.setText(aux);
                            break;
                        
                        case "Pista 2": 
                            rp2.setText("Reservado");
                            rp21.setText(aux);
                            break;
                        
                        case "Pista 3": 
                            rp3.setText("Reservado");
                            rp31.setText(aux);
                            break;
                        
                        case "Pista 4": 
                            rp4.setText("Reservado");
                            rp41.setText(aux);
                            break;
                        
                        case "Pista 5": 
                            rp5.setText("Reservado");
                            rp51.setText(aux);
                            break;
                        
                        case "Pista 6": 
                            rp6.setText("Reservado");
                            rp61.setText(aux);
                            break;
                        
                    }
                    
                     
                    
                    
                }
            }  
        }
        
    }

    

    @FXML
    private void userRes(KeyEvent event) {
       
        reservas = club.getUserBookings(userRes.getText());
        
        
        
        
        rp1.setText("No Reservado");
        rp11.setText("Nadie");
        rp2.setText("No Reservado");
        rp21.setText("Nadie");
        rp3.setText("No Reservado");
        rp31.setText("Nadie");
        rp4.setText("No Reservado");
        rp41.setText("Nadie");
        rp5.setText("No Reservado");
        rp51.setText("Nadie");
        rp6.setText("No Reservado");
        rp61.setText("Nadie");
        
        if(club.existsLogin(userRes.getText()) && reservas.size() > 0){
        cont++;
        for(int i = 0; i < cont; i++){
            LocalDate aux1 = reservas.get(i).getMadeForDay();
            LocalTime aux2 = reservas.get(i).getFromTime();
            Court aux3 = reservas.get(i).getCourt();
            String aux = reservas.get(i).getMember().getNickName();
            
            picker.setValue(aux1);
            hora.setText(String.valueOf(aux2.getHour() + ":00"));
            
            switch(aux3.getName()){
                        case "Pista 1": 
                            rp1.setText("Reservado");
                            rp11.setText(aux);
                            break;
                        
                        case "Pista 2": 
                            rp2.setText("Reservado");
                            rp21.setText(aux);
                            break;
                        
                        case "Pista 3": 
                            rp3.setText("Reservado");
                            rp31.setText(aux);
                            break;
                        
                        case "Pista 4": 
                            rp4.setText("Reservado");
                            rp41.setText(aux);
                            break;
                        
                        case "Pista 5": 
                            rp5.setText("Reservado");
                            rp51.setText(aux);
                            break;
                        
                        case "Pista 6": 
                            rp6.setText("Reservado");
                            rp61.setText(aux);
                            break;
            }
            
        }
        if(cont == reservas.size()){
            cont = 0;
            siguiente.setVisible(false);
        }
        if(cont > 0)
            siguiente.setVisible(true);
        }
    }

    @FXML
    private void siguienteRes(ActionEvent event) {
        
        reservas = club.getUserBookings(userRes.getText());
       
        
        
        
        rp1.setText("No Reservado");
        rp11.setText("Nadie");
        rp2.setText("No Reservado");
        rp21.setText("Nadie");
        rp3.setText("No Reservado");
        rp31.setText("Nadie");
        rp4.setText("No Reservado");
        rp41.setText("Nadie");
        rp5.setText("No Reservado");
        rp51.setText("Nadie");
        rp6.setText("No Reservado");
        rp61.setText("Nadie");
        
        if(club.existsLogin(userRes.getText()) && reservas.size() > 0){
        cont++;
        for(int i = 0; i < cont; i++){
            LocalDate aux1 = reservas.get(i).getMadeForDay();
            LocalTime aux2 = reservas.get(i).getFromTime();
            Court aux3 = reservas.get(i).getCourt();
            String aux = reservas.get(i).getMember().getNickName();
            
            picker.setValue(aux1);
            hora.setText(String.valueOf(aux2.getHour() + ":00"));
            
            switch(aux3.getName()){
                        case "Pista 1": 
                            rp1.setText("Reservado");
                            rp11.setText(aux);
                            break;
                        
                        case "Pista 2": 
                            rp2.setText("Reservado");
                            rp21.setText(aux);
                            break;
                        
                        case "Pista 3": 
                            rp3.setText("Reservado");
                            rp31.setText(aux);
                            break;
                        
                        case "Pista 4": 
                            rp4.setText("Reservado");
                            rp41.setText(aux);
                            break;
                        
                        case "Pista 5": 
                            rp5.setText("Reservado");
                            rp51.setText(aux);
                            break;
                        
                        case "Pista 6": 
                            rp6.setText("Reservado");
                            rp61.setText(aux);
                            break;
            }
            
        }
        if(cont == reservas.size()){
            cont = 0;
            siguiente.setVisible(false);
        }
        if(cont > 0)
            siguiente.setVisible(true);
        }
    }
        
    
}
