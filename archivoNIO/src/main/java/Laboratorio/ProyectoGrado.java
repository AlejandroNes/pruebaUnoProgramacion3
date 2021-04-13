/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class ProyectoGrado implements Serializable{
    static final long serialVersionUID=42L;
    private String tutor;
    private String revisor;
    
    public void MostrarProyecto(){
        System.out.println("Tutor   : "                 +this.tutor);
        System.out.println("Revisor : "                 +this.revisor);
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    
    
}