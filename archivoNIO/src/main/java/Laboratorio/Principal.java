
package Laboratorio;

import java.util.Scanner;

/**
 *
 * @author AlejandroNes
 */
public class Principal {
     public static void main(String[] args) {
        
           boolean next = true;
        int opc = 0;
        Scanner read = new Scanner(System.in);
        Operaciones op= new Operaciones();
        do {
            System.out.println("______________MENU PRINCIPAL________________");
            System.out.println("1.- Adicionar material bibilografico y registrar");
            System.out.println("2.- Mostrar todos los libros o proyectos que pertenecen a la Biblioteca");
            System.out.println("3.- Buscar un determinado libro por  titulo");
            System.out.println("4.- Buscar un determinado proyecto por revisor");
            
            System.out.println("5.- Eliminar un Libro o Proyecto de grado por deterioro");
            System.out.println("6.- Crear archivo");
            System.out.println("7.- Guardar los registros");
           
            System.out.println("8.- Salir");
            System.out.println("Ingrese una opcion");
            System.out.println("___________________________________________");
            opc = read.nextInt();

            switch (opc) {
                case 1:
                    op.leerObjetos();
                    op.crear();
                    op.guardarObjetos();
                    break;
                case 2:
                    op.leerObjetos();
                    op.mostrarLista();
                    break;
                case 3:
                    op.leerObjetos();
                    op.buscarLibro();
                    break;
                case 4:
                    op.leerObjetos();
                    op.BuscarRevisor();
                    break;
                case 5:
                    op.leerObjetos();
                    op.EliminarProyecto();
                    op.guardarObjetos();
                    break;
                case 6:
                    op.crearArchivo();
                    break;
                case 7:
                    op.guardarObjetos();
                    break;
                default:
                    next = false;
                    break;
            }
        } while (next);
    }
    
}