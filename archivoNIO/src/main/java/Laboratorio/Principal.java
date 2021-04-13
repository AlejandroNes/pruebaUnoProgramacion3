/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio;

import java.util.Scanner;

/**
 *
 * @author AlejandroNes
 */
public class Principal {
    public static void main(String[] args) {
        int x = 0;
        boolean seguir = true;
        Operaciones om = new Operaciones();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("                MENU DE OPCIONES            ");
            System.out.println("    1. Crear Archivo                        ");
            System.out.println("    2. Registrar Proyecto de Grado          ");
            System.out.println("    3. Registrar Libro                      ");
            System.out.println("    4. Guardar los Datos                    "); 
            System.out.println("    5. Mostrar Material Bibliografico       ");
            System.out.println("    6. Buscar Proyecto                      ");
            System.out.println("    7. Buscar Libro                         ");
            System.out.println("    8. Eliminar Libro o Proyecto            ");
            System.out.println("    9. Cerrar el programa                   ");
            System.out.print("      Elija una opcion:                       ");
            x = leer.nextInt();
            System.out.println("--------------------------------------------");
            switch (x) {
                case 1:
                    om.CrearArchivo();
                    break;
                case 2:
                    String p = "S";
                    while(p.equalsIgnoreCase("S")){
                        leer.nextLine();
                        om.AñadirProyecto();
                        System.out.print("¿Continuar registrando proyectos?   S/N   : ");
                        p = leer.nextLine();
                        System.out.println("");
                    }                    
                    break;
                case 3:
                    String l = "S";
                    while(l.equalsIgnoreCase("S")){
                        leer.nextLine();
                        om.AñadirLibro();
                        System.out.print("¿Continuar registrando libros?   S/N   : ");
                        l = leer.nextLine();
                        System.out.println("");
                    }                    
                    break;
                case 4:
                    om.AlmacenarDatosPro();
                    om.AlmacenarDatosLib();
                    System.out.println("        DATOS ALMACENADOS CON EXITO!!!      ");
                    System.out.println("");
                    break;
                case 5:
                    om.LeerMaterial();
                    om.MostrarMaterial();
                    break;
                case 6:
                    om.LeerMaterial();
                    System.out.print("Ingrese el titulo a buscar: ");
                    String proy = leer.nextLine();
                    om.BuscarProyecto(proy);
                    break;
                case 7:
                    om.LeerMaterial();
                    System.out.print("Ingrese el titulo a buscar: ");
                    String libro= leer.nextLine();
                    om.BuscarLibro(libro);
                    break;
                case 8:
                    om.LeerMaterial();
                    System.out.print("Ingrese el titulo a eliminar: ");
                    break;
                default:
                    seguir = false;
                    break;
            }
        } while (seguir);
    }
}
