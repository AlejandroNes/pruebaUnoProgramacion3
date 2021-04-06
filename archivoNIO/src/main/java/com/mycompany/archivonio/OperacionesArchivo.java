/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivonio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1.-  Crear un Directorio
 * 2.- Añadir contenido al directorio
 * 3.- Añadir contenido al archivo
 * @author AlejandroNes
 */
public class OperacionesArchivo {

 public void crearDirectorio(){
     Path path = Paths.get("C:\\ProgramacionIII");
     try {
         if(!Files.exists(path)){
             Files.createDirectory(path);
             System.out.println("Archivo creado correctamente");
         }else{
             System.out.println("El archivo ya existe");
         }
         
     } catch (Exception e) {
         e.printStackTrace();
     }
     
 }
 
 //Añadir contenido al directorio
 public void crearArchivo(){
     Path path = Paths.get("C:\\ProgramacionIII\\miArchivo.txt");
     try {
         if(!Files.exists(path)){
             Files.createFile(path);
             System.out.println("Archivo creado correctamente");
         }else{
             System.out.println("El archivo ya existe!..");
             //agregando contenido al archivo creado anteriormente
             Files.write(path,"Archivo creado con Java8".getBytes(), StandardOpenOption.APPEND);
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 //clase principal
    public static void main(String[] args) {
        OperacionesArchivo obj = new OperacionesArchivo();
        obj.crearDirectorio();
        obj.crearArchivo();
    }
    
}
