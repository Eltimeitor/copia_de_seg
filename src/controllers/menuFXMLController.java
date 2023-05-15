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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Member;
import model.Club;
import model.ClubDAO;
import model.ClubDAOException; 

/**
 * FXML Controller class
 *
 * @author david
 */
public class menuFXMLController implements Initializable {

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
            Logger.getLogger(menuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(menuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }    
    
    
    public void init(String log, String pass){
        this.login = log;
        textouser.setText(login);
        this.contra = pass;
        user = club.getMemberByCredentials(login, contra);
        imagenuser.setImage(user.getImage());
    }

    @FXML
    private void abrirPerfil(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/perfil/perfilFXML.fxml"));   
        Parent root = loader.load();
        perfilFXMLController controller = loader.getController();
        controller.init(login,contra);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) textouser.getScene().getWindow();
        myStage.close();
    }
    
    
}
