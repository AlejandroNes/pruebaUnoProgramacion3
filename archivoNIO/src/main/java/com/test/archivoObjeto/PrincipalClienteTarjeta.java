/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.util.Scanner;

/**
 *
 * @author AlejandroNes
 */
public class PrincipalClienteTarjeta {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        OperacionesClienteTarjeta obj = new OperacionesClienteTarjeta();
        

        do {
            System.out.println("===================");
            System.out.println("1.- Crear archivo");
            System.out.println("2.- Registrar cliente / tarjeta");
            System.out.println("3.- Guardar los registros");
            System.out.println("4.- Mostrar datos");
            System.out.println("5.- Bloquear tarjeta");
            System.out.println("6.- Depositar dinero");
            System.out.println("7.- Salir");
            System.out.println("Digite una opción");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    String res = "S";
                    while (res.equalsIgnoreCase("S")) {
                        obj.crearClienteTarjeta();
                        System.out.println("Desea seguir registrando clientes? S/N");
                        res = entrada.nextLine();
                    }
                    break;
                case 3:
                    obj.guardarObjetos();
                    break;
                case 4:
                    obj.leerClientes();
                    obj.mostrarCliente();
                    break;
                case 5:
                    obj.leerClientes();
                    System.out.println("Digite el N° de cedula del cliente: ");
                    int c = entrada.nextInt();
                    obj.cambiarEstado(c);
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerClientes();
                    System.out.println("Digite el numero de cedula");
                    int ced = entrada.nextInt();
                    System.out.println("Digite el monto que desea depositar");
                    double m = entrada.nextDouble();
                    obj.depositar(ced, m);
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);

    }
}
