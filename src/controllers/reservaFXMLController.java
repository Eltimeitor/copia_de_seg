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
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
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
import javafx.scene.control.ChoiceBox;
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
public class reservaFXMLController implements Initializable {

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
    
    private int currentWeek;
    
    private int numDayNow;
    
    private LocalDate dia;
    
    private int diaPedido;
    
    private int mesPedido;
    
    private int yearPedido;
    @FXML
    private Button GoBack;
    @FXML
    private Text errorHora;
    @FXML
    private ChoiceBox<String> hora;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            club = Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        picker.setValue(LocalDate.now());
        inicializarHoras();
        hora.setValue((LocalTime.now().getHour() + 1)+":00");
        
        
      
        
    }    
    

    
    @FXML
    private void reservar(ActionEvent event) throws ClubDAOException, IOException{
        if(this.login.equals("Iniciar Sesion")){ 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxmlapplication/autentificarseFXML.fxml"));   
            Parent root = loader.load();
            AutentificarseFXMLController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) reservar1.getScene().getWindow();
            myStage.close();
        }else{
            var reservas = club.getForDayBookings(picker.getValue());
            boolean noApta = false;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm",Locale.US);
            fromTime = LocalTime.parse(hora.getValue(),dtf);
            for(int i = 0; i < reservas.size(); i++){
                noApta = reservas.get(i).getFromTime().getHour() == (fromTime.getHour());
                if(noApta){
                    break;
                }
            }
            if(!noApta){
                boolean paid = user.checkHasCreditInfo();
                court = club.getCourts().get(0);
                //getCurrentDate();
                //getHour();
                //DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.US);
                ///madeForDay = LocalDate.parse(picker.getValue(),dt);

                Booking registerBooking = club.registerBooking(LocalDateTime.now(), picker.getValue(), fromTime, paid, court, user);
                System.out.println("Exito al hacer la reserva");
            }else{
                //Sacar alert para decir reserva ya existente
            }
        }
    }
    
    private boolean fechaCorrecta(){
        //Comprobar que la fecha sea mayor a la actual
       return false;
    }
    
    private boolean horaCorrecta(){
        //Comprobar que si la fecha es hoy, la hora es mayor a la actual
        //Comprobar casos de uso de limites de horas
        return false;
    }
    
    private void inicializarHoras(){
        ObservableList<String> horas = FXCollections.observableArrayList();
        
        for(int i = 0; i <= 23;i++){
            horas.add((i<10?"0":"")+i+":00");
        }
        
        hora.setItems(horas);
        hora.setValue((LocalTime.now().getHour() + 1)+":00");
    }
    
    public void init(String log, String pass){
        this.login = log;
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
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
    private void sinTexto(KeyEvent event) {
        try{
            int numero = Integer.parseInt(event.getCharacter());
            System.out.println(numero);
        }catch(NumberFormatException nfe){
            
            System.out.println("Errorororrooror");
        }
    }



    
}