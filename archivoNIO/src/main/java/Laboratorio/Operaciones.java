
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
 * @author AlejandroNes
 */
public class Operaciones {

    private String nombre;
    private String direccion;
    Scanner leer = new Scanner(System.in);

    private List<MaterialBibliografico> library;

    public Operaciones() {
        library = new ArrayList<>();
    }

    public void crear() {
        System.out.println("Digite el Nombre:");
        nombre = leer.nextLine();

        System.out.println("Digite la Direccion:");
        nombre = leer.nextLine();

        /*Opciones*/
        boolean estado = true;
        do {
            System.out.println("-------------MENU DE OPCIONES------------");
            System.out.println("1 REGISTRAR LIBRO");
            System.out.println("2 REGISTRAR PROYECTO DE GRADO");
            System.out.println("3 SALIR");
            System.out.println("DIGITE UNA OPCION");
            System.out.println("-----------------------------------------------");
            int opc = leer.nextInt();
            leer.nextLine();

            switch (opc) {
                case 1:
                    Libro libro = new Libro();
                    System.out.println("Ingrese el Titulo");
                    libro.setTitulo(leer.nextLine());
                    System.out.println("Ingrese el Autor");
                    libro.setAutor(leer.nextLine());
                    System.out.println("Ingrese su edicion");
                    libro.setEdicion(leer.nextInt());
                    leer.nextLine();
                    System.out.println("Ingrese el area");
                    libro.setArea(leer.nextLine());
                    library.add(libro);
                    break;
                case 2:
                    ProyectoGrado proyecto = new ProyectoGrado();
                    System.out.println("Digite el Titulo");
                    proyecto.setTitulo(leer.nextLine());
                    System.out.println("Digite el Autor");
                    proyecto.setAutor(leer.nextLine());
                    System.out.println("Digite el tutor");
                    proyecto.setTutor(leer.nextLine());
                    System.out.println("Digite el revisor");
                    proyecto.setRevisor(leer.nextLine());
                    library.add(proyecto);
                    break;
                default:
                    estado = false;
                    break;
            }
        } while (estado);

    }

    public void mostrarLista() {
        if (!library.isEmpty()) {
            System.out.println("------LISTA DE MATERIAL BIBLIOGRAFICO------");
            for (MaterialBibliografico item : library) {
                if (item instanceof Libro) {

                    Libro bo = (Libro) item;
                    bo.mostrar();
                    System.out.println("----------------------------------------------");
                } else {

                    ProyectoGrado pr = (ProyectoGrado) item;
                    pr.mostrar();
                    System.out.println("----------------------------------------------");
                }
            }
        }
    }

    //buscar el libro
    public void buscarLibro() {

        System.out.println("----DIGITE EL TITULO DEL LIBRO: -----");
        String titulo = leer.nextLine();
        boolean estado = false;

        for (MaterialBibliografico emp : library) {
            if (emp.getTitulo().equalsIgnoreCase(titulo)) {
                estado = true;
                System.out.println("----Encontrado---");
                emp.mostrar();
                System.out.println("-------------------");

            }
        }
        if (!estado) {
            System.out.println("no existe");
        }

    }
    //revisar el libro
    public void BuscarRevisor() {

        System.out.println("DIGITE EL REVISOR:");
        String revisor = leer.nextLine();

        boolean estado3 = false;
        for (MaterialBibliografico item : library) {

            if (item instanceof ProyectoGrado) {
                ProyectoGrado pr = (ProyectoGrado) item;
                if (pr.getRevisor().equalsIgnoreCase(revisor)) {
                    System.out.println("-----Encontrado-----");
                    pr.mostrar();
                    System.out.println("-----Encontrado-----");
                    estado3 = true;

                    break;
                }
            }

        }

    }

    public void EliminarProyecto() {
        System.out.println("DIGITE EL TITULO PROYECTO O LIBRO QUE DESEA ELIMINAR");
        String respuesta = leer.nextLine();
        boolean estado2 = false;

        for (MaterialBibliografico item : library) {
            if (item instanceof Libro) {

                Libro bo = (Libro) item;

                if (bo.getTitulo().equalsIgnoreCase(respuesta)) {
                    estado2 = true;
                    library.remove(bo);

                    System.out.println("------ELIMINADO EXITOSAMENTE-------");
                    break;
                }

            } else {
                ProyectoGrado pr = (ProyectoGrado) item;
                if (pr.getTitulo().equalsIgnoreCase(respuesta)) {
                    library.remove(pr);
                    estado2 = true;
                    System.out.println("------ELIMINADO EXITOSAMENTE-------");
                    break;
                }

            }

        }

        System.out.print((!estado2) ? "=====NO EXISTE ESE TITULO=====  \n" : "");


    }


    //manejo de archivos con java
    
    //creando el archivo
    public void crearArchivo() {
        Path path = Paths.get("C:\\ProgramacionIII\\archivoBibliografia.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    
    
    //guardando el objeto len el archivo creado 
    public void guardarObjetos() {
        String ruta = "C:\\ProgramacionIII\\archivoBibliografia.txt";
        try {

            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);

            oos.writeObject(library);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    //leemos los archivos guardados
    public void leerObjetos() {
        String ruta = "C:\\ProgramacionIII\\archivoBibliografia.txt";
        try {

            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);

            if (ois != null) {
                library = (List<MaterialBibliografico>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}