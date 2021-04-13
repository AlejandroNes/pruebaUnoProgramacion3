package Laboratorio;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class ProyectoGrado extends MaterialBibliografico  implements Serializable{
     static final long serialVersionUID=42L;
    private String tutor;
    private String revisor;

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
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tutor: "+tutor);
        System.out.println("Revisor: "+revisor);
    }
    
    
    
}