package ui;

import model.Biblioteca;

import java.util.Scanner;

public class Menu {
    String bar= " ======================= ";
    Scanner sc= new Scanner(System.in);
    public void launch(Biblioteca b){
        String option;
        Dao dao= new Dao();
        System.out.println("Bienvenido!");
        do{

        System.out.println(bar+"Menu Principal"+bar);
        System.out.println("1\tAgregar nuevo\n2\tEliminar\n3\tMostrar\n4\tFiltrar\n5\tModificar\n0\tSalir");
        option= sc.nextLine();
        switch (option){
            case "1":
                dao.agregar(b);
                break;
            case "2":
                dao.eliminar(b);
                break;
            case "3":
                System.out.println(dao.mostrar(b));
                break;
            case "0":
                System.out.println("Adios!");
                return;
            default:
                System.out.println("La opcion elegida es incorrecta");
        }
        }while(true);
    }
}
