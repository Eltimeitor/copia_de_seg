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
import java.time.temporal.WeekFields;
import java.util.Locale;
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
import javafx.scene.image.ImageView;
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
    
    private int currentWeek;
    
    private int numDayNow;
    
    private LocalDate dia;
    
    private int diaPedido;
    
    private int mesPedido;
    
    private int yearPedido;
    @FXML
    private Button GoBack;
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
        
        
      
        
    }    

    public void getCurrentDate(){
        WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
        currentWeek = (LocalDate.now().get(weekFields.weekOfWeekBasedYear()))/ 4;  
        numDayNow = LocalDate.now().get(weekFields.dayOfWeek());
        dia = picker.getValue();
        diaPedido = dia.getDayOfMonth();
        mesPedido = dia.getMonthValue();
        yearPedido = dia.getYear();
         madeForDay = LocalDate.of(yearPedido,mesPedido,diaPedido);
        fromTime = LocalTime.of(0,0);
        bookingDate = LocalDateTime.of(madeForDay,fromTime);
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista1");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
        
    }
    
    public void init(String log, String pass){
        this.login = log;
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
    }

    private void reservar2(ActionEvent event) throws ClubDAOException, IOException{
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista2");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
    }
    private void reservar3(ActionEvent event) throws ClubDAOException, IOException{
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista3");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
    }
    

    private void reservar4(ActionEvent event) throws ClubDAOException, IOException{
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista4");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
    }

    private void reservar5(ActionEvent event) throws ClubDAOException, IOException{
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista5");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
    }

    private void reservar6(ActionEvent event) throws ClubDAOException, IOException{
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
    }
        else{boolean paid = user.checkHasCreditInfo();
        court = new Court("pista6");
        getCurrentDate();
       
        Booking registerBooking = club.registerBooking(bookingDate, madeForDay, fromTime, paid, court, user);
        }
    }

    @FXML
    private void pick(ActionEvent event) {
        
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
}
