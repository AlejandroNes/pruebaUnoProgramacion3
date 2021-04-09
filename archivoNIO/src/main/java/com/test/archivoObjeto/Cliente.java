/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class Cliente implements Serializable {
    static final long serialVersionUID=43L;
     //atributos
    private String nombre;
    private String paterno;
    private String materno;
    private int cedula;
    
    //definiendo agregacion
   private TarjetaDebito tarjeta;
    //metodo mostrar informacion
    public void mostrarCliente(){
        System.out.println("************************");
        System.out.println("-----CLIENTE------");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Apellido Paterno: "+this.paterno);
        System.out.println("Apellido Materno: "+this.materno);
        System.out.println("Cedula: "+this.cedula);
        if(tarjeta != null){
            tarjeta.mostrarTarjeta();
        }else{
            System.out.println("El cliente no tiene aún una tarjeta de debito");
        }
    }
    //getter and setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public TarjetaDebito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDebito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
