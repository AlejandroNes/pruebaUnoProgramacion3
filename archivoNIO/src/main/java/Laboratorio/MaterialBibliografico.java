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
public class MaterialBibliografico implements Serializable{
    static final long serialVersionUID=42L;
    private String titulo;
    private String autor;
    private ProyectoGrado proyectogrado;
    private Libro libro;
    
    public void MostrarMaterialProyecto(){
        System.out.println("       MATERIAL BIBLIOGRAFICO        ");
        System.out.println("          PROYECTO DE GRADO        ");
        System.out.println("Titulo  : "      +this.titulo);
        System.out.println("Autor   : "      +this.autor);
        
        if(proyectogrado!=null){
            proyectogrado.MostrarProyecto();
        }else{
            System.out.println("        NO EXISTEN PROYECTOS REGISTRADOS     ");
            System.out.println("");
        }
        System.out.println("-------------------------------");
    }
    
    public void MostrarMaterialLibro(){
        System.out.println("       MATERIAL BIBLIOGRAFICO        ");
        System.out.println("                LIBRO                ");
        System.out.println("Titulo  : "      +this.titulo);
        System.out.println("Autor   : "      +this.autor);
        
        if(libro!=null){
            libro.MostrarLibro();
        }else{
            System.out.println("        NO EXISTEN LIBROS REGISTRADOS     ");
            System.out.println("");
        }
        System.out.println("-------------------------------");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ProyectoGrado getProyectogrado() {
        return proyectogrado;
    }

    public void setProyectogrado(ProyectoGrado proyectogrado) {
        this.proyectogrado = proyectogrado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
}
