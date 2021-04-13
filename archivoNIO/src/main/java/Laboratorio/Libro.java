
package Laboratorio;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class Libro extends MaterialBibliografico  implements Serializable{
     static final long serialVersionUID=42L;
    private int edicion;
    private String area;
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Edicion: "+edicion);
        System.out.println("Area:  "+area);
    }
   


    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
}