package Laboratorio;

import java.io.Serializable;

/**
 *
 * @author AlejandroNes
 */
public class MaterialBibliografico  implements Serializable {
static final long serialVersionUID=42L;
    private String titulo;
    private String autor;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void mostrar() {
        System.out.println("================================");
        System.out.println("Titulo:" + titulo);
        System.out.println("Autor:" + autor);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}