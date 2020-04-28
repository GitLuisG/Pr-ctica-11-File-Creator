package edu.upv.poo;

import java.io.*;
import java.lang.*;
import java.util.*;

import edu.upv.poo.randoms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Practica11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Practica11().run();
    }
    
    public void run() {
        
        System.out.println("== Practica 11 ==\n");
        
        String dir = System.getProperty("user.home");
        System.out.println("User dir: " + dir);
        
        Formatter f = null;
        try {
            f = openFile("Archivo1.txt");
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
            if (ex.getCause() != null)
                System.err.println("  Causa: " + ex.getCause().getMessage());
            System.exit(1);
        }
         
        f.format("%s\n", "Hola mundo");
        f.close();
        
        String desktopDir = System.getProperty("user.home") + "/Desktop/";
        TextFileGenerator tfg = new TextFileGenerator(desktopDir);
        try {
            tfg.generateFile("ArchivoRandoms.txt", 1233343);
        } catch (RandomException ex) {
            System.err.println("Error al generar archivo de randoms: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Practica11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private Formatter openFile(String fileName) throws Exception {
        String desktopDir = System.getProperty("user.home") + "/Desktop/";
        try {
            return new Formatter(desktopDir + fileName);
        }
        catch (SecurityException ex) {
            throw new Exception("Error de seguridad.", ex);
        }
        catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado.", ex);
        }
    }
    
}
