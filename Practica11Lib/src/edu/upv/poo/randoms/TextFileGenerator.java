package edu.upv.poo.randoms;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.SecureRandom;

public class TextFileGenerator {
 
    public TextFileGenerator(String directorio) {
        if (directorio == null)
            throw new IllegalArgumentException(
                    "directorio cannot be null.");
        this.directorio = directorio;
    }
    
    public String getDirectorio() { return directorio; }
    
    
    public void generateFile(String filename, int cant) 
            throws RandomException, IllegalArgumentException {
        
        if (filename == null || filename.equals(""))
            throw new IllegalArgumentException(
                    "filename cannot be null or empty.");
        
        Path filePath = Paths.get(directorio, filename);
        SecureRandom sr = new SecureRandom();
        Charset charset = Charset.forName("UTF-8");
        
        try (BufferedWriter w = Files.newBufferedWriter(filePath, charset)) {
            for (int i = 0; i < cant; i++) {
                w.write(String.format("%.9f\n", sr.nextFloat()));
            }
        }
        catch (IOException ex) {
            throw new RandomException(
                    "Error al crear el archivo.", ex);
        }
        
    }
    
    private String directorio;
    
}
