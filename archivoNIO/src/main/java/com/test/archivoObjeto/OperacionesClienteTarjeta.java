/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import com.sun.corba.se.impl.io.IIOPInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AlejandroNes
 */
public class OperacionesClienteTarjeta {
        Scanner entrada = new Scanner (System.in);
       List<Cliente> listaCliente;
       
       //constructor

    public OperacionesClienteTarjeta() {
        listaCliente = new ArrayList<>();
    }
    
    //metodos
    public void crearClienteTarjeta(){
        Cliente cliente = new Cliente();
        TarjetaDebito tarjeta = new TarjetaDebito();
        //Datos del cliente
        System.out.println("Ingrese nombre:");
        cliente.setNombre(entrada.nextLine());
        System.out.println("Ingrese apellido Paterno");
        cliente.setPaterno(entrada.nextLine());
        System.out.println("Ingrese apellido Materno");
        cliente.setMaterno(entrada.nextLine());
        System.out.println("Ingrese su cedula de Identidad");
        cliente.setCedula(entrada.nextInt());
        //Datos de la tarjeta de debito
        System.out.println("Ingrese numero de tarjeta");
        tarjeta.setNroTarjeta(entrada.nextInt());
        System.out.println("Ingrese su numero de cuenta");
        tarjeta.setNroCuenta(entrada.nextInt());
        System.out.println("Ingrese su saldo");
        tarjeta.setSaldo(entrada.nextDouble());
        tarjeta.setEstado("ACTIVO");
        //agregando la tarjeta de debito al cliente
        cliente.setTarjeta(tarjeta);
        //adicionando el cleinte a la lista de clientes
        listaCliente.add(cliente);
        System.out.println("--- REGISTRO COMPLETADO!... ---");
        
    }
       public void mostrarCliente(){
           if(listaCliente != null){
               System.out.println("--- CLIENTES ACTIVOS ---");
               for(Cliente clienteAux:listaCliente){
                   clienteAux.mostrarCliente();
               }
           }
       }
       
       //cambiar el estado de la tarjeta a INACTIVO para poder bloquear su uso
       public void cambiarEstado(int cedula){
           int sw = 0;
           if(listaCliente != null){
               for(Cliente cliente:listaCliente){
                    if(cliente.getCedula() == cedula){
                        sw = 1;
                        cliente.getTarjeta().setEstado("Inactivo");
                        System.out.println("*****************");
                        System.out.println("Se bloqueo la tarjeta");
                        System.out.println("*****************");
                    }
               }
               if(sw == 0){
                   System.out.println("El cliente no esta registrado");
               }
           }
       }
       
       //realizando el deposito del monto de dinero a la cuenta
       public void depositar (int cedula, double monto){
           int sw = 0;
           if(listaCliente != null){
               for(Cliente cliente:listaCliente){
                    if(cliente.getCedula() == cedula){
                        sw = 1;
                        if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                            double saldo = cliente.getTarjeta().getSaldo();
                            saldo+= monto;
                            cliente.getTarjeta().setSaldo(saldo);
                            System.out.println("Se realizo el deposito");
                        }else{
                            System.out.println("La tarjeta esta bloqueada! comuniquese con el banco");
                        }
                    }
               }
               if(sw == 0){
                   System.out.println("El cliente no esta registrado");
               }
           }
       }
       
       //crear archivo cliente
       public void crearArchivo(){
           Path path = Paths.get("C:\\ProgramacionIII\\archivoCliente.txt");
           try {
               if(!Files.exists(path)){
                   Files.createFile(path);
                   System.out.println("Creado correctamente");
               }else{
                   System.out.println("el archivo ya existe");
               }
           } catch (Exception e) {
           }
           
       }
       //Guardando la lista Cliente dentro del archivo creado 
       public void guardarObjetos(){
           String ruta = "C:\\ProgramacionIII\\archivoCliente.txt";
           try {
               FileOutputStream archivos = new FileOutputStream(ruta);
               ObjectOutputStream oos = new ObjectOutputStream(archivos);
               oos.writeObject(listaCliente);
               oos.close();
               archivos.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       //leer clientes
       public void leerClientes(){
           String ruta = "C:\\ProgramacionIII\\archivoCliente.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream ois = new ObjectInputStream(archivos);
               if(ois != null){
                   listaCliente = (List<Cliente>)ois.readObject();
               }else{
                   System.out.println("El objeto es nulo");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
}
