/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Member;
import model.Club;
import model.ClubDAO;
import model.ClubDAOException; 

/**
 *
 * @author bland
 */
public class registroFXMLController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellidos;
    @FXML
    private TextField txt_tarjeta;
    @FXML
    private TextField txt_svc;
    @FXML
    private TextField txt_telefono;
    @FXML
    private TextField txt_nickname;
    @FXML
    private PasswordField txt_contrasena;
    @FXML
    private Text lblnombre;
    @FXML
    private Text lblapellido;
    @FXML
    private Text lbltarjeta;
    @FXML
    private Text lblsvc;
    @FXML
    private Text lbltelefono;
    @FXML
    private Text lblnickname;
    @FXML
    private Text lblcontrasena;
    @FXML
    private ComboBox<ImageView> imagen;
    @FXML
    private ImageView imgAvatar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<ImageView> avatars = FXCollections.observableArrayList();
         Image Predeterminado; 
         
         
         Image avatar1;
         ImageView view1 = new ImageView();
         
         Image avatar2;
         ImageView view2 = new ImageView();
         
         Image avatar3;
         ImageView view3 = new ImageView();
         
         Image avatar4;
         ImageView view4 = new ImageView();
         
         Image avatar5; 
         ImageView view5 = new ImageView();
         
         Image woman; 
         ImageView view6 = new ImageView();
        
         Image woman2; 
         ImageView view7 = new ImageView();
         
         Image woman3; 
         ImageView view8 = new ImageView();
         
         Image woman4; 
         ImageView view9 = new ImageView();
         
         Image woman5; 
         ImageView view10 = new ImageView();
         
         Image woman6; 
         ImageView view11 = new ImageView();
         
         try {
             
            Predeterminado = new Image(new FileInputStream("src\\resources\\default.png"), 50, 60, false, false);
            view1.setImage(Predeterminado);
            
            avatar1 = new Image(new FileInputStream("src\\resources\\men.png"), 50, 60, false, false);
            view1.setImage(avatar1);
           
            avatar2 = new Image(new FileInputStream("src\\resources\\men2.png"), 50, 60, false, false);
            view2.setImage(avatar2);
           
            avatar3 = new Image(new FileInputStream("src\\resources\\men3.png"), 50, 60, false, false);
            view3.setImage(avatar3);
           
            avatar4 = new Image(new FileInputStream("src\\resources\\men4.png"), 50, 60, false, false);
            view4.setImage(avatar4);
            
            avatar5 = new Image(new FileInputStream("src\\resources\\men5.png"), 50, 60, false, false);
            view5.setImage(avatar5);
            
            woman = new Image(new FileInputStream("src\\resources\\woman.png"), 50, 60, false, false);
            view6.setImage(woman);
            
            woman2 = new Image(new FileInputStream("src\\resources\\woman2.png"), 50, 60, false, false);
            view7.setImage(woman2);
            
            woman3 = new Image(new FileInputStream("src\\resources\\woman3.png"), 50, 60, false, false);
            view8.setImage(woman3);
            
            woman4 = new Image(new FileInputStream("src\\resources\\woman4.png"), 50, 60, false, false);
            view9.setImage(woman4);
            
            woman5 = new Image(new FileInputStream("src\\resources\\woman5.png"), 50, 60, false, false);
            view10.setImage(woman5);
            
            woman6 = new Image(new FileInputStream("src\\resources\\woman6.png"), 50, 60, false, false);
            view11.setImage(woman6);
            
            
            avatars.addAll(view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11);
            imagen.setItems(avatars);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void accept(ActionEvent event)throws ClubDAOException {
        String name = txt_nombre.getText(); 
        String surname = txt_apellidos.getText();
        String password = txt_contrasena.getText();
        String telephone = txt_telefono.getText();
        String nickName = txt_nickname.getText();
        String creditCard = txt_tarjeta.getText();
       
        
        if (txt_nombre.getText().isEmpty()){
       lblnombre.setText("Campo requerido"); 
       }else {
           lblnombre.setText("");
       }
        if (txt_apellidos.getText().isEmpty()){
       lblapellido.setText("Campo requerido"); 
       }else {
           lblapellido.setText("");
       }
        if (txt_contrasena.getText().isEmpty()){
       lblcontrasena.setText("Campo requerido"); 
       }else {
           lblcontrasena.setText("");
       }
        if (txt_telefono.getText().isEmpty()){
       lbltelefono.setText("Campo requerido"); 
       }else {
           lbltelefono.setText("");
       }
        if (txt_nickname.getText().isEmpty()){
       lblnickname.setText("Campo requerido"); 
       }else {
           lblnickname.setText("");
       }
        if (txt_tarjeta.getText().isEmpty()){
       lbltarjeta.setText("Campo requerido"); 
       }else {
           lbltarjeta.setText("");
       }
        /*
         if (Club.existsLogin()) no deja registrarse, 
         else
            registerMember();
         */
        
       
    }

    @FXML
    private void elegirAvatar(ActionEvent event) {
        
      Image img = null;
      ImageView seleccionado = imagen.getValue();
      
      
    
       if  ("avatar1".equals(seleccionado)){
             try {
                 img = new Image(new FileInputStream("Trabajo_IPC\\src\\resources\\men.png")) ;
                 imgAvatar.setImage(img);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } else if ("avatar2".equals(seleccionado)){
           try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\men2.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }} else if ("avatar3".equals(seleccionado)){
           try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\men3.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
       
           } } else if ("avatar4".equals(seleccionado)){
           try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\men4.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           } } else if ("avatar5".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\men5.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                 
           }   }else if ("woman".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }}else if ("woman2".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman2.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }}else if ("woman3".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman3.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }}else if ("woman4".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman4.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }}else if ("woman5".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman5.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }}else if ("woman6".equals(seleccionado)) {
            try {
               img = new Image(new FileInputStream("\\Trabajo_IPC\\src\\resources\\woman6.png"));
               imgAvatar.setImage(img);
           } catch (FileNotFoundException ex) {
                 Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
  }

    @FXML
    private void examinarImagen(ActionEvent event) {
        
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
               // new FileChooser.ExtensionFilter("All Images", "."),
               // new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        // Obtener la imagen seleccionada
        Stage stage = new Stage();
        File imgFile = fileChooser.showOpenDialog(stage);

        // Mostar la imagen
        if (imgFile != null) {
            
            String url = imgFile.getAbsolutePath();
            Image avatar;
            try {
                avatar = new Image(new FileInputStream(url));
                imgAvatar.imageProperty().setValue(avatar);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(registroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
