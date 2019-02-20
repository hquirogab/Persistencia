/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author hquiroga
 */
public class GestionArchivo {
    
    private String ruta;

    public GestionArchivo(String ruta) {
        this.ruta = ruta;
    }
    
    public boolean guardar(ArrayList<Integer> db) throws IOException {
        File archivo = new File(this.ruta);
        //Si el archivo no existe, lo crea en la ruta especificada
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        
        PrintStream salida = new PrintStream(archivo);
        for(Integer value : db) {
            salida.print(value);
            salida.print(" ");
        }
        //Flush empuja la información al archivo
        salida.flush();
        //Siempre hay que cerrar el archivo
        salida.close();
        return true;
    }
    
    public ArrayList<Integer> cargar() throws FileNotFoundException{
        ArrayList<Integer> data = new ArrayList<>();
        Scanner lectura = new Scanner(new File(this.ruta));
         
        while(lectura.hasNextInt()){
            data.add(lectura.nextInt());
        }
        return data;
    }
}
