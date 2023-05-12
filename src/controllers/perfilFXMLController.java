/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author david
 */
public class perfilFXMLController implements Initializable {

    
    
    String login;
    
    String contra;
    
    Member user;
    
    Club club;
    
    private List<Member> miembros = new ArrayList();
    @FXML
    private Button editar;
    @FXML
    private Button cerrar;
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
        //club.setInitialData();//para no añadir nada nuevo a la base de datos, sin esto todo se queda registrado
        
        club.addSimpleData();
        
        miembros = club.getMembers();
    }    

    
    public void init(String log, String pass){
        this.login = log;
        
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
        
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/editar/editarFXML.fxml"));   
        Parent root = loader.load();
        editarFXMLController controller = loader.getController();
        controller.init(login,contra);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) editar.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void cerrar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/inicio/inicioFXML.fxml"));   
        Parent root = loader.load();
        InicioFXMLController controller = loader.getController();
        controller.init(login,contra);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) cerrar.getScene().getWindow();
        myStage.close();
    }
    
}
