/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaiii;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author andres.castro3
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label,mensaje;
   private Stage stage1=new Stage();
   @FXML
   private TextField atomo,ancestros, grado;
   static String hilera="(";
   @FXML
   private  Button  tSubArbol, subArbol, hermano, comienza, aceptar;
   int i=0, contador=0;
   @FXML
    private javafx.scene.control.Button empezar, terminar, calcular;
   
   /**
    * Método que permite ingresar la hilera correctamente
    **/
    @FXML
    private void handleButtonAction(ActionEvent event) {
       String revision =atomo.getText();
        
       if(!revision.equalsIgnoreCase("") && !hilera.contains(revision)){
        
         hilera+=atomo.getText();
         System.out.println(hilera);
         atomo.setText("");
         if(i==1){
             terminar.setDisable(false);
             hermano.setDisable(false);
             
             
         }
         if(i==2){
            tSubArbol.setDisable(false);
            hermano.setDisable(false);
            subArbol.setDisable(false);
         }
         if(i==3){
             subArbol.setDisable(false);
             hermano.setDisable(false);
             tSubArbol.setDisable(false);
         }
         if(i==4){
             subArbol.setDisable(false);
             terminar.setDisable(false);
         }
         
       aceptar.setVisible(false);
       atomo.setVisible(false);
       }else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error ");
         alert.setHeaderText("Ingrese un dato valido");
         alert.showAndWait();
         atomo.setText("");
        }
       mensaje.setText(hilera);
    }
    
    /**
     * Método que verifica cuando se termina un subárbol
     **/
    @FXML
    private void terminarSubArbol(ActionEvent event){
       hilera+=")";
       tSubArbol.setDisable(true);
       subArbol.setDisable(true);
       terminar.setDisable(true);
       hermano.setDisable(true);
       i=1;
       contador--;
       if(contador>=1){
           tSubArbol.setDisable(false);
           hermano.setDisable(false);
       }
       if(contador==0){
         atomo.setVisible(false);
         aceptar.setDisable(true);
         terminar.setDisable(false);
         tSubArbol.setDisable(true);
         subArbol.setDisable(true);
         hermano.setDisable(true);
       }
       mensaje.setText(hilera);
    }
    
    /**
     * Método que crea un nuevo subárbol
     **/
    @FXML
    private void subArbol(ActionEvent event){
       hilera+="("+atomo.getText();
       terminar.setDisable(true);
       tSubArbol.setDisable(true);
       hermano.setDisable(true);
       subArbol.setDisable(true);
       i=2;
       contador++;
       
       aceptar.setVisible(true);
       atomo.setVisible(true);
       mensaje.setText(hilera);
    }
    
    /**
     * Método que válida cuando se termina el árbol
     **/
    @FXML
    private void terminar(ActionEvent event){
        hilera+=")";        
       tSubArbol.setDisable(true);
       subArbol.setDisable(true);
       terminar.setDisable(true);
       hermano.setDisable(true);
        System.out.println(hilera);
        mensaje.setText(hilera);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Atencion ");
         alert.setHeaderText("la hilera entrada fue: "+hilera);
         alert.showAndWait();
        try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PedirUsuario.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage =(Stage) terminar.getScene().getWindow();
         stage.hide();
         stage1.setScene(new Scene(root1)); 
         stage1.setResizable(false);
         stage1.show();
         }catch(IOException e){
             System.out.println("No se puede cargar la puta pagina");
         }
    }
    
    /**
     * Método que crea un hermano
     **/
    @FXML
    private void hermano(ActionEvent event){
        hilera+=",";
        terminar.setDisable(true);
        tSubArbol.setDisable(true);
        subArbol.setDisable(true);
        hermano.setDisable(true);
        i=3;
        aceptar.setVisible(true);
       atomo.setVisible(true);
       mensaje.setText(hilera);
    }
    
    /**
     * Método para empezar a ingresar la hilera
     **/
    @FXML
    public void empezar(ActionEvent event){
         
        try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage =(Stage) empezar.getScene().getWindow();
         stage.hide();
         stage1.setScene(new Scene(root1));
         stage1.setResizable(false);
         stage1.show();
         }catch(IOException e){
             System.out.println("No se puede cargar la puta pagina");
         }
        
    }
    
    /**
     * Método que da la información para ingresar la hilera
     **/
    @FXML
    public void comienza(ActionEvent event){
        aceptar.setVisible(true);
        hermano.setVisible(true);
        subArbol.setVisible(true);
        tSubArbol.setVisible(true);
        terminar.setVisible(true);
        terminar.setDisable(true);
        tSubArbol.setDisable(true);
        subArbol.setDisable(true);
        hermano.setDisable(true);
        comienza.setVisible(false);
        atomo.setVisible(true);
        i=4;
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Atención ");
         alert.setHeaderText("Ingrese la raíz del arbol");
         alert.showAndWait();
    }
    
    /**
     * Método que permite ingresar solo letras al crear el árbol
     **/
     public void txtAtomo_KeyTyped(javafx.scene.input.KeyEvent keyEvent) {
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                 ) {
            keyEvent.consume();
        }  
       
        if(atomo.getText().length()>=1){ 
            keyEvent.consume(); 
        } 
    }
     
     /**
      * Método que permite ingresar solo letras para hallar el ancestro
      **/
     public void txtAncestros_KeyTyped(javafx.scene.input.KeyEvent keyEvent) {
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                 ) {
            keyEvent.consume();
        }
        
        
       
        if(ancestros.getText().length()>=1){ 
            keyEvent.consume(); 
        } 
    }
     
     /**
      * Método que permite ingresar solo letras para hallar el grado del dato
      **/
     public void txtGrado_KeyTyped(javafx.scene.input.KeyEvent keyEvent) {
        char car = keyEvent.getCharacter().charAt(0);
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                 ) {
            keyEvent.consume();
        }
        
        
       
        if(grado.getText().length()>=1){ 
            keyEvent.consume(); 
        } 
    }
     
     /**
      * Método principal que calcula todo lo solicitado en la práctica
      **/
     public void calcular(ActionEvent event){
         char dato1,dato2;
         String recorrido, recorridoInorden, recorridoPreorden,recorridoPosorden, ancestrosArbol, recorridoPorNiveles;
         int gradoArbol, altura, hojas,gradoDeDato;
         dato1=ancestros.getText().charAt(0);
         dato2=grado.getText().charAt(0);
         ArbolLG arbol=new ArbolLG();
         arbol.construyeArbol(hilera);//Se construye el arbol N-Ario
         arbol.escribirArbol(arbol.getRaiz());//muestra el arbol por consola
         recorrido=arbol.imprimirArbol(0, arbol.getRaiz());//Se extrae hilera del Arbol N-ario
         System.out.println("\033[33mEl recorrido del árbol es: \033[30m"+recorrido);
         ArbolBinario arbolBi=new ArbolBinario();
         arbolBi.convierteLGABinario(arbol);//Se pasa de N-ario a Binario
         gradoArbol=arbolBi.gradoNarioEnBinario(arbolBi.getRaiz());//Se calcula el grado del arbol
         System.out.println("\033[33mEl grado del árbol es:  \033[30m"+gradoArbol);
         recorridoInorden=arbolBi.inOrden(arbolBi.getRaiz());//Se extrae el recorrido inorden
         System.out.println("\033[33mEl recorrido en inorden es:  \033[30m"+recorridoInorden);
         recorridoPreorden=arbolBi.preOrden(arbolBi.getRaiz());//Se extrae el recorrido preorden
         System.out.println("\033[33mEl recorrido en preorden es: \033[30m"+recorridoPreorden);
         recorridoPosorden=arbolBi.posOrden(arbolBi.getRaiz());//Se extrae el recorrido posorden
         System.out.println("\033[33mEl recorrido en posorden es: \033[30m"+recorridoPosorden);
         altura=arbolBi.alturaNarioBinario(arbolBi.getRaiz());//Se calcula la altura del arbol
         System.out.println("\033[33mLa altura del árbol es: \033[30m"+altura);
         hojas=arbolBi.hojas(arbolBi.getRaiz());//Se calcula la cantidad de hojas
         System.out.println("\033[33mEl número de Hojas de árbol es: \033[30m"+hojas);
         if(!hilera.contains(ancestros.getText())){
           System.out.println("\033[33mLos ancestros del "+dato1+"  \033[30m no existe, ya que este no está en el árbol");
         }else{
             ancestrosArbol=arbolBi.ancestros(dato1, hilera);// se busca el ancestro de un dato;
             System.out.println("\033[33mLos ancestros del "+dato1+" son: \033[30m"+ancestrosArbol);
         }        
         recorridoPorNiveles=arbolBi.recorreNiveles();//se calcula el recorrido por niveles
         System.out.println("\033[33mEl recorrido por niveles es:\n\033[30m"+recorridoPorNiveles);
         if(!hilera.contains(grado.getText())){
             System.out.println("\033[33mEl grado de "+dato2+"  \033[30m no se puede calcular, ya que este no está en el árbol");
         }else{
            gradoDeDato=arbolBi.gradoDeUnDato(dato2);
            System.out.println("\033[33mEl grado de "+dato2+" es: \033[30m"+gradoDeDato);
         }         
         Stage stage =(Stage) calcular.getScene().getWindow();
         stage.hide();
     }
       
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
