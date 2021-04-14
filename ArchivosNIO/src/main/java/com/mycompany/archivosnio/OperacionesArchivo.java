
package com.mycompany.archivosnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; 
 
/**
 *
 * @author JVC
 */
public class OperacionesArchivo {
    // crear directorio
    public void crearDirectorio(){
        Path  path=Paths.get("C:\\Users\\JVC\\Documents\\ARCHIVOSNIO");
        try {
            if(!Files.exists(path)){
                Files.createDirectory(path);
                System.out.println("directorio creado ");
                
            }else{
                System.out.println("ya existe el directorio ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void crearArchivo(){
        Path  path=Paths.get("C:\\Users\\JVC\\Documents\\ARCHIVOSNIO\\Archivo.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("archivo creado...");
            }
            else{
                System.out.println(" el archvo ya existe ");
                // agregando contenido al archivo creado anteriormente 
                Files.write(path, "Creando archivos con javadddd ".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }     
    public void eliminarArchivo(){ 
         System.out.println(" "); 
    }
    public static void main(String[] args) {
        OperacionesArchivo ob=new OperacionesArchivo();
        ob.crearDirectorio();
        ob.crearArchivo();
    } 
    
}
