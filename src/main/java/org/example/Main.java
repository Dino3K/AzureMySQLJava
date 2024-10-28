package org.example;
import java.sql.SQLOutput;
import java.util.Scanner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.example.Autos;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Autos.insertarAuto("Renault","4","gris","456DFG");
//        Autos.mostrarAutos();
//        Autos.eliminarAutoPP("456DFG");
//        Autos.actualizarCPP("ABC123","Panda");
        int op;
        do {
            System.out.println("|------Menu------|");
            System.out.println("1. Insertar auto");
            System.out.println("2. Ver autos");
            System.out.println("3. Eliminar auto");
            System.out.println("4. Actualizar auto");
            System.out.println("5. Salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Marca: ");
                    String marca = sc.next();
                    System.out.println("Modelo: ");
                    String modelo = sc.next();
                    System.out.println("Color: ");
                    String color = sc.next();
                    System.out.println("Placa: ");
                    String placa = sc.next();
                    Autos.insertarAuto(marca, modelo, color, placa);
                    break;
                    case 2:
                        Autos.mostrarAutos();
                        break;
                        case 3:
                            System.out.println("Digite la placa del auto a eliminar: ");
                            String pla = sc.next();
                            Autos.eliminarAutoPP(pla);
                            break;
                            case 4:
                                System.out.println("Digite la placa del auto a actualizar: ");
                                String plaa = sc.next();
                                System.out.println("Digite el nuevo color: ");
                                String color2 = sc.next();
                                Autos.actualizarCPP(plaa, color2);
                                break;
                                default:
                                    System.out.println("Pendejo");
                                    break;

            }

        }while (op != 5);
        System.out.println("Gud bai....");
 }
}
