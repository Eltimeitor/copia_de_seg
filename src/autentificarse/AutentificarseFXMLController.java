/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package autentificarse;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author david
 */
public class AutentificarseFXMLController implements Initializable {

    @FXML
    private TextField nickName;
    @FXML
    private PasswordField contras;

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
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutentificarseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        club.addSimpleData();
        miembros = club.getMembers();
        
    }    

    
    private boolean autentificarNick(List<Member> nicks){
        String nick;
        String name = nickName.getText();
        for(int i = 0; i < nicks.size(); i++ ){
            nick = nicks.get(i).getNickName();
            if(nick.equals(name)){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean autentificarPass(List<Member> passwords){
        String inipass;
        String pass = contras.getText();
        for(int i = 0; i < passwords.size(); i++ ){
            inipass = passwords.get(i).getPassword();
            if(inipass.equals(pass)){
                return true;
            }
        }
        
        return false;
    }
    
    
    @FXML
    private void accept(ActionEvent event) {
        boolean valido = autentificarNick(miembros) && autentificarPass(miembros);
        System.out.println(valido);
    }

    @FXML
    private void transicion(ActionEvent event) {
        
    }
    
}
