/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresionlambdaactionevent;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class ExpresionLambdaActionEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane cuadricula = new GridPane();
        cuadricula.setAlignment(Pos.CENTER);
        cuadricula.setHgap(10);
        cuadricula.setVgap(10);
        cuadricula.setPadding(new Insets(25, 25, 25, 25));
        
        Label tasaInteresAnual = new Label("Annual Interest Rate:");
        cuadricula.add(tasaInteresAnual, 0, 1);
        TextField campoTextoTasaInteresAnual = new TextField (); 
        cuadricula.add (campoTextoTasaInteresAnual, 1, 1);
        
        Label numeroDeAños = new Label("Number of Years:");
        cuadricula.add(numeroDeAños, 0, 2);
        TextField campoTextoNumeroDeAños = new TextField ();
        cuadricula.add(campoTextoNumeroDeAños, 1, 2); 
        
        Label montoPrestamo = new Label("Loan Amount:");
        cuadricula.add(montoPrestamo, 0, 3);
        TextField campoTextoMontoPrestamo = new TextField ();
        cuadricula.add(campoTextoMontoPrestamo, 1, 3);
        
        Label mensualidad = new Label("Monthly Payment:");
        cuadricula.add(mensualidad, 0, 4);
        TextField campoTextoMensualidad = new TextField ();
        cuadricula.add(campoTextoMensualidad, 1, 4);
        
        Label pagoTotal = new Label("Total Payment:");
        cuadricula.add(pagoTotal, 0, 5);
        TextField campoTextoPagoTotal = new TextField ();
        cuadricula.add(campoTextoPagoTotal, 1, 5);
        
        Button calcular = new Button("Calculate");
        HBox hbCalcular = new HBox(10);
        hbCalcular.setAlignment(Pos.BOTTOM_RIGHT);
        hbCalcular.getChildren().add(calcular);
        cuadricula.add(hbCalcular, 1, 6);
        
        // Lambda Handler
        
       calcular.setOnAction(e -> 
        {
            float i; // Interes
            float n; // Numero de años
            float h; // Importe del prestamo
            float mp;// Mensualidad
            float tp;//Total 
            float r; //Redito
            
            
            i = Float.parseFloat(campoTextoTasaInteresAnual.getText()); //cogemos el valor de interes
            r = (i / (100 * 12));
            n = Float.parseFloat(campoTextoNumeroDeAños.getText());//cogemos la cantidad de años
            h = Float.parseFloat(campoTextoMontoPrestamo.getText());//cogemos el  importe del prestamo
            
            //Formula
            mp = (float) ((h*r) / (1 - Math.pow((1 + r), (-12 * n))));
            tp = (float) (mp * 12 * n);
            
            campoTextoMensualidad.setText("€"+String.valueOf(mp));
            campoTextoPagoTotal.setText("€"+String.valueOf(tp));
            
        });
        

        Scene scene = new Scene(cuadricula, 300, 250);
        primaryStage.setTitle("Calculadora de prestamo");
        primaryStage.setScene(scene);
       
       
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
