/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
 * @author SmartUrban2025
 */
public class Operaciones{

    List<ProyectoGrado> ListaProyecto;
    List<Libro> ListaLibro;
    List<MaterialBibliografico> ListaMaterial;
    Scanner leer = new Scanner(System.in);

    public Operaciones() {
        ListaProyecto = new ArrayList<>();
        ListaLibro = new ArrayList<>();
        ListaMaterial = new ArrayList<>();
    }

    public void AñadirProyecto() {
        MaterialBibliografico mb = new MaterialBibliografico();
        ProyectoGrado pg = new ProyectoGrado();
        System.out.print("Ingrese Titulo del Proyecto   : ");
        mb.setTitulo(leer.nextLine());
        System.out.print("Ingrese Autor del Proyecto    : ");
        mb.setAutor(leer.nextLine());
        System.out.print("Ingrese Tutor del Proyecto    : ");
        pg.setTutor(leer.nextLine());
        System.out.print("Ingrese Revisor del Proyecto  : ");
        pg.setRevisor(leer.nextLine());
        mb.setProyectogrado(pg);
        ListaMaterial.add(mb);
        System.out.println("        PROYECTO REGISTRADO CON EXITO        ");
        System.out.println("                                             ");
    }

    public void AñadirLibro() {
        MaterialBibliografico mb = new MaterialBibliografico();
        Libro li = new Libro();
        System.out.print("Ingrese Titulo del Libro      : ");
        mb.setTitulo(leer.nextLine());
        System.out.print("Ingrese Autor del Libro       : ");
        mb.setAutor(leer.nextLine());
        System.out.print("Ingrese Edicion del Libro     : ");
        li.setEdicion(leer.nextInt());
        System.out.print("Ingrese Area del Libro        : ");
        li.setArea(leer.nextLine());
        mb.setLibro(li);
        ListaMaterial.add(mb);
        System.out.println("        LIBRO REGISTRADO CON EXITO        ");
    }

    public void MostrarMaterial() {
        if (ListaMaterial != null) {
            System.out.println("            MATERIAL BIBLIOGRAFICO           ");
            for (Libro liAux : ListaLibro) {
                liAux.MostrarLibro();
            }
        }
        System.out.println("");
    }

    public void BuscarLibro(String libro) {
        int x = 0;
        if (ListaMaterial != null) {
            for (MaterialBibliografico lb : ListaMaterial) {
                if (lb.getTitulo() == libro) {
                    x = 1;
                    lb.getLibro();
                }
                if (x == 0) {
                    System.out.println("        EL LIBRO NO SE ENCUENTRA EN EL MATERIAL BIBLIOGRAFICO!!!        ");
                    System.out.println("");
                }
            }
        }
    }

    public void BuscarProyecto(String proy) {
        int x = 0;
        if (ListaMaterial != null) {
            for (MaterialBibliografico lb : ListaMaterial) {
                if (lb.getTitulo() == proy) {
                    x = 1;
                    lb.getProyectogrado();
                }
                if (x == 0) {
                    System.out.println("        EL PROYECTO NO SE ENCUENTRA EN EL MATERIAL BIBLIOGRAFICO!!!        ");
                    System.out.println("");
                }
            }
        }
    }

    public void CrearArchivo() {
        Path path = Paths.get("C:\\ProgramacionIII\\materialBibliografico.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("        ARCHIVO CREADO CON EXITO...     ");
                System.out.println("");
            } else {
                System.out.println("        EL ARCHIVO YA EXISTE...     ");
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    public void AlmacenarDatosPro() {
        String location = "C:\\ProgramacionIII\\materialBibliografico.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(ListaProyecto);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }

    public void AlmacenarDatosLib() {
        String location = "C:\\ProgramacionIII\\materialBibliografico.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(ListaLibro);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }

    public void LeerProyectos() {
        String location = "C:\\ProgramacionIII\\materialBibliografico.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                ListaProyecto = (List<ProyectoGrado>) ois.readObject();
            } else {
                System.out.println("        EL OBJETO ES NULO       ");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }

    public void LeerLibros() {
        String location = "C:\\ProgramacionIII\\materialBibliografico.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                ListaLibro = (List<Libro>) ois.readObject();
            } else {
                System.out.println("        EL OBJETO ES NULO       ");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
    
    public void LeerMaterial() {
        String location = "C:\\ProgramacionIII\\materialBibliografico.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                ListaMaterial = (List<MaterialBibliografico>) ois.readObject();
            } else {
                System.out.println("        EL OBJETO ES NULO       ");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
}
