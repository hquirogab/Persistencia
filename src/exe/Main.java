/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import ui.GUI;
import dao.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hquiroga
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Gestion de Enteros");
        
        GUI gui = new GUI();
        DAO db = new DAO();
        GestionArchivo archivos = new GestionArchivo("enteros.txt");
        
        Scanner lectura = new Scanner(System.in);
        
        int opcion = 0;
        opcion = gui.menu();
        int valor;
        
        while(true){
            opcion = gui.menu();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese dato");
                    valor = lectura.nextInt();
                    db.addDb(valor);
                    break;
                case 2:
                    System.out.println("Guardando...");
            {
                try {
                    archivos.guardar(db.getDb());
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case 3:
                    System.out.println("Cargando archivo...");
                    ArrayList<Integer> respaldo = null;
                    try {
                        respaldo = archivos.cargar();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    db.setDb(respaldo);
                    break;
                case 4:
                    System.out.println("Lista");
                    gui.listar(db.getDb());
                    break;
                case 5:
                    System.out.println("Ingrese posición");
                    int posicion = lectura.nextInt();
                    System.out.println("Ingrese numero");
                    valor = lectura.nextInt();
                    
                    if(posicion > 0 && posicion < db.getDb().size() - 1){
                        db.modificar(valor, posicion);
                    }
                    break;
            }
        }
        
    }
}
